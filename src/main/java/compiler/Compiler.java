package compiler;

import antlr.CBaseListener;
import antlr.CLexer;
import antlr.CParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.apache.commons.text.StringEscapeUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

public class Compiler extends CBaseListener {

    private static final StringBuilder ret = new StringBuilder();
    private static Namespace currentNamespace;
    private static Method currentMethod;
    private static final HashMap<String, Namespace> namespaces = new HashMap<>();
    private static final HashMap<String, String> constants = new HashMap<>();
    public static boolean showLogs = false;
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy@HH:mm:ss");
    public static int line = 0;
    public static int col = 0;

    private static void log(String msg) {
        if (showLogs) {
            Date date = new Date();
            System.out.println("LOG " + formatter.format(date) + ": " + msg);
        }
    }

    public static void evaluateExpression(CParser.ExpressionContext expression) {
        evaluatePostfix(convertInfixToPostfix(expression));
    }

    public static String compile(String code) throws Exception{
        CLexer lexer = new CLexer(CharStreams.fromString(code));
        CParser parser = new CParser(new CommonTokenStream(lexer));

        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
            }
        });

        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        Compiler listener = new Compiler();

        walker.walk(listener, tree);
        constants.clear();
        return Assembler.assemble(getOutput());
    }

    public static String compileTopLevel(File file) throws Exception {
        ret.delete(0, ret.length());
        currentNamespace = null;
        currentMethod = null;
        namespaces.clear();
        constants.clear();


        long start = System.currentTimeMillis();
        init();
        String code = Files.readString(file.toPath());

        CLexer lexer = new CLexer(CharStreams.fromString(code));
        CParser parser = new CParser(new CommonTokenStream(lexer));

        parser.addErrorListener(new BaseErrorListener() {
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                throw new IllegalStateException("failed to parse at line " + line + " due to " + msg, e);
            }
        });

        ParseTree tree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        Compiler listener = new Compiler();

        walker.walk(listener, tree);
        end();

        long end = System.currentTimeMillis();
        long time = end - start;
        System.out.println("Compiled in " + (((double) time) / 1000) + " seconds");
        return Assembler.assemble(getOutput());
    }

    public static void init() {
        appendLine("jmp\n%ENTRY%");
    }
    public static void end() {
        appendLine(":ENTRY");
        Namespace mainNamespace = null;

        for (Namespace namespace : namespaces.values()) {
            if (namespace.isSystemLibrary)
                continue;
            appendLine("jts\n%" + namespace.getName() + "%");

            if (namespace.hasMethod("main") && namespace.getMethod("main").isPublic())
                mainNamespace = namespace;
        }
        if (mainNamespace == null)
            throw new LanguageException("main function not found, try defining one with 'public func main(){}'");
        appendLine("jts\n%" + mainNamespace.getName() + "_main%\ndone");
    }

    static String parseString(String s) {
        String tmp = StringEscapeUtils.unescapeJava(s).substring(1);
        return tmp.substring(0, tmp.length() - 1);
    }

    public static void appendLine(Object line){
        ret.append('\n').append(line);
    }

    static void addExpressionToList(CParser.ExpressionContext expression, List<ValueOrOperatorOrID> ret) {
        if (expression.OPERATOR() != null) {
            addExpressionToList(expression.expression(0), ret);
            ret.add(new ValueOrOperatorOrID(null, expression.OPERATOR().getText()));
            addExpressionToList(expression.expression(1), ret);
        } else if (expression.value() != null)
            ret.add(new ValueOrOperatorOrID(expression.value(), null));
        else {
            ret.add(new ValueOrOperatorOrID(null, "("));
            addExpressionToList(expression.expression(0), ret);
            ret.add(new ValueOrOperatorOrID(null, ")"));
        }
    }

    static List<ValueOrOperatorOrID> convertInfixToPostfix(CParser.ExpressionContext expression) {
        List<ValueOrOperatorOrID> infix = new ArrayList<>();
        addExpressionToList(expression, infix);

        return InfixToPostfix.infixToPostfix(infix);
    }

    static void evaluateValue(CParser.ValueContext ctx) {
        if (ctx.offset() != null) {
            evaluateExpression(ctx.offset().expression());
            appendLine("storeAtVar\ntempOffset");
        }

        if (ctx.STRING() != null)
            appendLine("ldi\n" + parseString(ctx.STRING().getText()));
        else if (ctx.INT() != null)
            appendLine("ldi\n" + ctx.INT().getText());
        else if (ctx.HEX() != null)
            appendLine("ldi\n" + Integer.parseInt(ctx.HEX().getText().substring(2), 16));
        else if (ctx.BIN() != null)
            appendLine("ldi\n" + Integer.parseInt(ctx.BIN().getText().substring(2), 2));
        else if (ctx.methodCall() != null) {
            Method method = evaluateMethodCall(ctx.methodCall());

            if (ctx.offset() != null)
                appendLine("loadAtVarWithOffset\n" + method.getReturnVariableName() + "\ntempOffset");
            else
                appendLine("loadAtVar\n" + method.getReturnVariableName());
        } else if (ctx.sizeof == null){
            CParser.VariableContext var = ctx.variable();
            if (var.variable() != null) {
                String namespaceName = var.ID().getText();
                String varName = var.variable().ID().getText();

                if (ctx.offset() != null)
                    appendLine("loadAtVarWithOffset\n" + namespaceName + "_" + varName + "\ntempOffset");
                else
                    appendLine("loadAtVar\n" + namespaceName + "_" + varName);
            } else if (currentMethod != null && (currentMethod.hasArgument(var.ID().getText()) || currentMethod.hasVariable(var.ID().getText()))) {
                if (currentMethod.hasArgument(var.ID().getText())) {
                    if (ctx.offset() != null)
                        appendLine("loadAtVarWithOffset\n" + currentMethod.getArgumentName(var.ID().getText()) + "\ntempOffset");
                    else
                        appendLine("loadAtVar\n" + currentMethod.getArgumentName(var.ID().getText()));
                } else if (ctx.offset() != null)
                    appendLine("loadAtVarWithOffset\n" + currentNamespace.getName() + "_" + currentMethod.getName() + "_" + var.ID().getText() + "\ntempOffset");
                else
                    appendLine("loadAtVar\n" + currentNamespace.getName() + "_" + currentMethod.getName() + "_" + var.ID().getText());
            } else {
                if (currentNamespace.hasVariable(var.ID().getText())) {
                    if (ctx.offset() != null)
                        appendLine("loadAtVarWithOffset\n" + currentNamespace.getName() + "_" + var.ID().getText() + "\ntempOffset");
                    else
                        appendLine("loadAtVar\n" + currentNamespace.getName() + "_" + var.ID().getText());
                } else {
                    if (!constants.containsKey(var.ID().getText()))
                        throw new LanguageException("Unknown variable '" + var.ID().getText() + "'");
                    appendLine("ldi\n" + constants.get(var.ID().getText()));
                }
            }
        } else {
            CParser.VariableContext var = ctx.variable();
            if (var.variable() != null) {
                String namespaceName = var.ID().getText();
                String varName = var.variable().ID().getText();

                appendLine("arraySize\n" + namespaceName + "_" + varName);
            } else if (currentMethod != null && (currentMethod.hasArgument(var.ID().getText()) || currentMethod.hasVariable(var.ID().getText()))) {
                if (currentMethod.hasArgument(var.ID().getText()))
                    appendLine("arraySize\n" + currentMethod.getArgumentName(var.ID().getText()));
                else
                    appendLine("arraySize\n" + currentNamespace.getName() + "_" + currentMethod.getName() + "_" + var.ID().getText());
            } else {
                if (!currentNamespace.hasVariable(var.ID().getText()))
                    throw new LanguageException("Unknown variable '" + var.ID().getText() + "'");
                appendLine("arraySize\n" + currentNamespace.getName() + "_" + var.ID().getText());
            }
        }
    }

    static Method evaluateMethodCall(CParser.MethodCallContext ctx) {
        List<CParser.ExpressionContext> arguments = evaluateArgumentArray(ctx.argumentArray());

        if (ctx.variable().variable() != null) {
            String namespaceName = ctx.variable().ID().getText();
            String methodName = ctx.variable().variable().ID().getText();

            if (!namespaces.containsKey(namespaceName))
                throw new LanguageException("Unknown namespace '" + namespaceName + "'");
            if (!namespaces.get(namespaceName).hasMethod(methodName))
                throw new LanguageException(namespaceName + " does not have a function '" + methodName + "'");

            namespaces.get(namespaceName).getMethod(methodName).call(arguments);
            return namespaces.get(namespaceName).getMethod(methodName);
        }
        if (currentMethod.getName().equals(ctx.variable().ID().getText())) {
            currentMethod.call(arguments);
            return currentMethod;
        }
        if (!currentNamespace.hasMethod(ctx.variable().ID().getText()))
            throw new LanguageException("Unknown function '" + ctx.variable().ID().getText() + "'");

        currentNamespace.getMethod(ctx.variable().ID().getText()).call(arguments);
        return currentNamespace.getMethod(ctx.variable().ID().getText());
    }

    static List<CParser.ExpressionContext> evaluateArgumentArray(CParser.ArgumentArrayContext ctx) {
        CParser.ArgumentArrayContext cur = ctx;
        List<CParser.ExpressionContext> ret = new ArrayList<>();

        while (cur != null) {
            ret.add(cur.expression());
            cur = cur.argumentArray();
        }
        return ret;
    }
    private static int tmpCount = 0;

    static void evaluatePostfix(List<ValueOrOperatorOrID> postfix) {

        Stack<ValueOrOperatorOrID> stack = new Stack<>();
        StringBuilder visualPostfix = new StringBuilder();

        for (ValueOrOperatorOrID post : postfix) {
            if (post.operator() != null)
                visualPostfix.append(" ").append(post.operator()).append(" ");
            else
                visualPostfix.append(" ").append(post.value().getText()).append(" ");
        }
        log("Evaluating postfix '" + visualPostfix.substring(1, visualPostfix.length() - 1) + "'");

        for (ValueOrOperatorOrID x : postfix) {
            if (x.value() != null || x.getId() != null) {
                stack.push(x);
            } else {
                ValueOrOperatorOrID b = stack.pop();
                ValueOrOperatorOrID a = stack.pop();
                String op = x.operator();

                if (a.value() == null)
                    appendLine("loadAtVar\n" + a.getId());
                else
                    evaluateValue(a.value());

                appendLine("storeAtVar\na");
                if (b.value() == null)
                    appendLine("loadAtVar\n" + b.getId());
                else
                    evaluateValue(b.value());
                appendLine("storeAtVar\nb");
                appendLine("loadAtVar\na");

                String prefix = switch (op) {
                    case "+" -> "add";
                    case "-" -> "sub";
                    case "*" -> "mul";
                    case "/" -> "div";
                    case ">>" -> "bitwiseRsf";
                    case "<<" -> "bitwiseLsf";
                    case "&" -> "bitwiseAnd";
                    case "|" -> "bitwiseOr";
                    case "&&" -> "boolAnd";
                    case "||" -> "boolOr";
                    case "==" -> "boolEqual";
                    case "!=" -> "boolNotEqual";
                    case "<" -> "smallerThan";
                    case ">" -> "largerThan";
                    case "%" -> "mod";
                    case ">=" -> "largerThanOrEqual";
                    case "<=" -> "smallerThanOrEqual";
                    default -> throw new IllegalStateException("Unexpected operator: " + op);
                };

                appendLine(prefix + "WithVar\nb");
                appendLine("storeAtVar\ntmp" + tmpCount);
                ValueOrOperatorOrID tmp = new ValueOrOperatorOrID(null, null);
                tmp.setId("tmp" + tmpCount);
                tmpCount++;
                stack.push(tmp);
            }
        }
        ValueOrOperatorOrID lastValue = stack.pop();

        if (lastValue.value() != null)
            evaluateValue(lastValue.value());
        else
            appendLine("loadAtVar\n" + lastValue.getId());

        if (!stack.isEmpty())
            throw new RuntimeException("Postfix was not evaluated correctly, stack still has " + stack.size() + " items.");
    }

    public static String getOutput(){
        if (ret.length() == 0)
            return "";
        return Assembler.assemble(ret.substring(1));
    }
    public static String getRawOutput(){
        if (ret.length() == 0)
            return "";
        return ret.substring(1);
    }

    @Override
    public void enterProgram(CParser.ProgramContext ctx) {

    }

    @Override
    public void exitProgram(CParser.ProgramContext ctx) {

    }

    @Override
    public void enterStatement(CParser.StatementContext ctx) {

    }

    @Override
    public void exitStatement(CParser.StatementContext ctx) {

    }

    @Override
    public void enterCompilerFunction(CParser.CompilerFunctionContext ctx) {

    }

    @Override
    public void exitCompilerFunction(CParser.CompilerFunctionContext ctx) {
        switch (ctx.ID().getText()) {
            case "include" -> {
                if (currentNamespace != null || currentMethod != null)
                    throw new LanguageException("'include' directive must be called at top-level");
                if (ctx.compilerFunctionValue().size() != 1)
                    throw new LanguageException("'include' directive takes 1 argument, not " + ctx.compilerFunctionValue().size());
                if (ctx.compilerFunctionValue(0).LIBRARY() == null && ctx.compilerFunctionValue(0).STRING() == null)
                    throw new LanguageException("File to include must be a file or a internal library path");
                boolean tmp0 = false;

                boolean logBackup = showLogs && !tmp0;
                showLogs = false;

                if (ctx.compilerFunctionValue(0).LIBRARY() != null) {
                    String tmp = ctx.compilerFunctionValue(0).LIBRARY().getText().substring(1);
                    tmp = tmp.substring(0, tmp.length() - 1);

                    try {

                        try (InputStream in = getClass().getResourceAsStream("/" + tmp + ".sc"); BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
                            StringBuilder contents = new StringBuilder();
                            reader.lines().forEach(contents.append("\n")::append);
                            compile(contents.substring(1));
                        }
                    } catch (NullPointerException | IOException e) {
                        throw new LanguageException("Cannot find library <" + tmp + ">");
                    } catch (Exception e) {
                        throw new LanguageException("Cannot compile library <" + tmp + ">\n" + e.getMessage());
                    }
                }
                else {
                    try {
                        compile(Files.readString(Path.of(parseString(ctx.compilerFunctionValue(0).STRING().getText()))));
                    } catch (Exception e) {
                        throw new LanguageException("Cannot compile library " + ctx.compilerFunctionValue(0).getText());
                    }
                }
                showLogs = logBackup;
            }
            case "define" -> {
                if (ctx.compilerFunctionValue().size() != 2)
                    throw new LanguageException("'define' directive takes 2 arguments, not " + ctx.compilerFunctionValue().size());
                if (ctx.compilerFunctionValue(0).ID() == null)
                    throw new LanguageException("Name of constant must be an ID");

                if (ctx.compilerFunctionValue(1).INT() != null)
                    constants.put(ctx.compilerFunctionValue(0).ID().getText(), ctx.compilerFunctionValue(1).INT().getText());
                else if (ctx.compilerFunctionValue(1).HEX() != null)
                    constants.put(ctx.compilerFunctionValue(0).getText(), Integer.parseInt(ctx.compilerFunctionValue(1).HEX().getText().substring(2), 16) + "");
                else if (ctx.compilerFunctionValue(1).BIN() != null)
                    constants.put(ctx.compilerFunctionValue(0).getText(), Integer.parseInt(ctx.compilerFunctionValue(1).BIN().getText().substring(2), 2) + "");
                else
                    throw new LanguageException("Value of constant must be of type Integer, Hex, or Binary");
            }
        }
        log("Handled directive '" + ctx.ID().getText() + "'");
    }

    private static int conditionCount = 0;
    private static final Stack<Integer> conditionCounts = new Stack<>();

    @Override
    public void enterIfStatement(CParser.IfStatementContext ctx) {
        evaluateExpression(ctx.condition().expression());

        appendLine("jf\n%c" + conditionCount + "%");
        conditionCounts.push(conditionCount);
        conditionCount++;
    }

    @Override
    public void exitIfStatement(CParser.IfStatementContext ctx) {
        appendLine(":c" + conditionCounts.pop());
    }

    @Override
    public void enterWhileStatement(CParser.WhileStatementContext ctx) {
        evaluateExpression(ctx.condition().expression());

        appendLine("jf\n%c" + conditionCount + "%");
        conditionCounts.push(conditionCount);
        conditionCount++;

        appendLine(":c" + conditionCount);
        conditionCounts.push(conditionCount);
        conditionCount++;
    }

    @Override
    public void exitWhileStatement(CParser.WhileStatementContext ctx) {
        evaluateExpression(ctx.condition().expression());

        appendLine("jt\n%c" + conditionCounts.pop() + "%");
        appendLine(":c" + conditionCounts.pop());
    }

    @Override
    public void enterForStatement(CParser.ForStatementContext ctx) {
        String idxName = ctx.ID().getText();
        CParser.ExpressionContext lowValue = ctx.expression(0);
        CParser.ExpressionContext highValue = ctx.expression(1);


        if (currentMethod == null)
            throw new LanguageException("Cannot use 'for' keyword outside of function scope");
        if (currentMethod.hasVariable(idxName))
            throw new LanguageException("Duplicate variable '" + idxName + "'");
        String varName = currentNamespace.getName() + "_" + currentMethod.getName() + "_" + idxName;
        currentMethod.addVariable(idxName, varName);

        evaluateExpression(lowValue);
        appendLine("storeAtVar\n" + varName);

        if (ctx.by != null) {
            evaluateExpression(ctx.expression(2));
            appendLine("storeAtVar\nincrement" + conditionCount);
            conditionCounts.push(conditionCount);
            conditionCount++;
        }

        evaluateExpression(highValue);
        appendLine("storeAtVar\nhighValue" + conditionCount);
        conditionCount++;

        appendLine(":boundsCheck" + conditionCount);
        conditionCounts.push(conditionCount);
        conditionCount++;

        appendLine("loadAtVar\n" + varName);
        appendLine("largerThanOrEqualWithVar\nhighValue" + (conditionCount - 2));
        appendLine("jt\n%forEnd" + conditionCount + "%");
        conditionCounts.push(conditionCount);
        conditionCount++;
    }

    @Override
    public void exitForStatement(CParser.ForStatementContext ctx) {
        int forEndIdx = conditionCounts.pop();
        int boundsCheckIdx = conditionCounts.pop();

        if (ctx.by != null) {
            appendLine("loadAtVar\nincrement" + conditionCounts.pop());
            appendLine("addWithVar\n" + currentMethod.getVariable(ctx.ID().getText()));
            appendLine("storeAtVar\n" + currentMethod.getVariable(ctx.ID().getText()));
        } else
            appendLine("inc\n" + currentMethod.getVariable(ctx.ID().getText()));
        appendLine("jmp\n%boundsCheck" + boundsCheckIdx + "%");
        appendLine(":forEnd" + forEndIdx);

        currentMethod.removeVariable(ctx.ID().getText());
    }

    @Override
    public void enterSwitchStatement(CParser.SwitchStatementContext ctx) {
        evaluateExpression(ctx.expression());
        appendLine("storeAtVar\nswitchExpr" + conditionCount);
        conditionCounts.push(conditionCount);
        conditionCount++;


    }

    @Override
    public void exitSwitchStatement(CParser.SwitchStatementContext ctx) {

    }

    @Override
    public void enterCaseBlock(CParser.CaseBlockContext ctx) {

    }

    @Override
    public void exitCaseBlock(CParser.CaseBlockContext ctx) {

    }

    @Override
    public void enterDefaultBlock(CParser.DefaultBlockContext ctx) {

    }

    @Override
    public void exitDefaultBlock(CParser.DefaultBlockContext ctx) {

    }

    @Override
    public void enterMethodDefinition(CParser.MethodDefinitionContext ctx) {
        if (currentMethod != null)
            throw new LanguageException("Cannot define method in method.");
        if (currentNamespace == null)
            throw new LanguageException("Cannot define method at top-level.");

        String name = ctx.ID().getText();
        List<String> args = new ArrayList<>();
        CParser.MethodArgumentArrayContext cur = ctx.methodArgumentArray();

        while (cur != null) {
            args.add(cur.ID().getText());
            cur = cur.methodArgumentArray();
        }
        appendLine("jmp\n%" + currentNamespace.getName() + "_" + name + "_end%");
        appendLine(":" + currentNamespace.getName() + "_" + name);

        log("Entered method '" + name + "'");

        if (currentNamespace.hasMethod(name))
            throw new LanguageException("Duplicate method '" + name + "'");
        currentMethod = new Method(true, ctx.pub != null, name, args, currentNamespace.getName() + "_");
        //appendLine(";" + name);
    }

    @Override
    public void exitMethodDefinition(CParser.MethodDefinitionContext ctx) {
        currentNamespace.addMethod(currentMethod.getName(), currentMethod);
        appendLine("ret");
        appendLine(":" + currentNamespace.getName() + "_" + currentMethod.getName() + "_end");
        log("Exited method '" + currentMethod.getName() + "'");
        currentMethod = null;
    }

    @Override
    public void enterNamespaceDefinition(CParser.NamespaceDefinitionContext ctx) {
        if (currentNamespace != null)
            throw new LanguageException("Cannot create namespace when in namespace");
        currentNamespace = new Namespace(ctx.ID().getText());
        Builtins.addAll(currentNamespace);

        log("Entered namespace '" + ctx.ID().getText() + "'");
        appendLine(":" + currentNamespace.getName());
    }

    @Override
    public void exitNamespaceDefinition(CParser.NamespaceDefinitionContext ctx) {
        if (currentNamespace == null)
            throw new LanguageException("Cannot end namespace when not in namespace");
        namespaces.put(currentNamespace.getName(), currentNamespace);
        currentNamespace = null;

        log("Exited current namespace");
        appendLine("ret");
    }

    @Override
    public void exitReturnStatement(CParser.ReturnStatementContext ctx) {
        if (currentMethod == null)
            throw new LanguageException("Cannot return when not in method.");
        if (ctx.expression() != null) {
            if (!currentMethod.returnsVariable())
                throw new LanguageException(currentMethod.getName() + " does not return a value.");

            evaluateExpression(ctx.expression());
            appendLine("storeAtVar\n" + currentMethod.getReturnVariableName());
        }
        appendLine("ret");
    }

    @Override
    public void exitVariableArrayDefinition(CParser.VariableArrayDefinitionContext ctx) {
        String name = ctx.ID().getText();

        if (currentNamespace == null)
            throw new LanguageException("Variables cannot be defined in top-level");
        if (currentMethod != null && ctx.pub != null)
            throw new LanguageException(ctx.pub.getText() + " modifier cannot be used inside method declaration");

        if (currentMethod != null) {
            if (currentMethod.hasVariable(name) || currentMethod.hasArgument(name))
                throw new LanguageException("Duplicate variable '" + name + "'");

            String var = currentNamespace.getName() + "_" + currentMethod.getName() + "_" + name;
            if (ctx.offset() != null) {
                evaluateExpression(ctx.offset().expression());
                appendLine("storeAtVar\narraySize");
                appendLine("createArray\n" + var + "\narraySize");
            } else {
                List<CParser.ExpressionContext> items = evaluateArgumentArray(ctx.argumentArray());

                appendLine("ldi\n" + items.size());
                appendLine("storeAtVar\narraySize");
                appendLine("createArray\n" + var + "\narraySize");

                int idx = 0;
                for (CParser.ExpressionContext item : items) {
                    appendLine("ldi\n" + idx);
                    appendLine("storeAtVar\ntmpItemOffset");
                    evaluateExpression(item);
                    appendLine("storeAtVarWithOffset\n" + var + "\ntmpItemOffset");

                    idx++;
                }
            }

            currentMethod.addVariable(name, var);
        } else {
            if (currentNamespace.hasVariable(name))
                throw new LanguageException("Duplicate variable '" + name + "'");

            String var = currentNamespace.getName() + "_" + name;

            if (ctx.offset() != null) {
                evaluateExpression(ctx.offset().expression());
                appendLine("storeAtVar\narraySize");
                appendLine("createArray\n" + var + "\narraySize");
            } else {
                List<CParser.ExpressionContext> items = evaluateArgumentArray(ctx.argumentArray());

                appendLine("ldi\n" + items.size());
                appendLine("storeAtVar\narraySize");
                appendLine("createArray\n" + var + "\narraySize");

                int idx = 0;
                for (CParser.ExpressionContext item : items) {
                    appendLine("ldi\n" + idx);
                    appendLine("storeAtVar\ntmpItemOffset");
                    evaluateExpression(item);
                    appendLine("storeAtVarWithOffset\n" + var + "\ntmpItemOffset");

                    idx++;
                }
            }

            currentNamespace.addVariable(name, new Variable(var, ctx.pub != null));
        }
        log("Defined array '" + name + "'");
    }

    @Override
    public void enterVariableDefinition(CParser.VariableDefinitionContext ctx) {

    }

    @Override
    public void exitVariableDefinition(CParser.VariableDefinitionContext ctx) {
        if (currentNamespace == null)
            throw new LanguageException("Variables cannot be defined in top-level");
        if (currentMethod != null && ctx.pub != null)
            throw new LanguageException(ctx.pub.getText() + " modifier cannot be used inside method declaration");
        String name = ctx.ID().getText();

        if (currentMethod != null) {
            if (currentMethod.hasVariable(name) || currentMethod.hasArgument(name))
                throw new LanguageException("Duplicate variable '" + name + "'");

            String var = currentNamespace.getName() + "_" + currentMethod.getName() + "_" + name;
            evaluateExpression(ctx.expression());
            appendLine("storeAtVar\n" + var);

            currentMethod.addVariable(name, var);
        } else {
            if (currentNamespace.hasVariable(name))
                throw new LanguageException("Duplicate variable '" + name + "'");

            String var = currentNamespace.getName() + "_" + name;
            evaluateExpression(ctx.expression());
            appendLine("storeAtVar\n" + var);

            currentNamespace.addVariable(name, new Variable(var, ctx.pub != null));
        }
        log("Defined variable '" + name + "'");
    }

    @Override
    public void enterVariableValueChange(CParser.VariableValueChangeContext ctx) {

    }

    @Override
    public void exitVariableValueChange(CParser.VariableValueChangeContext ctx) {
        String varName;
        if (ctx.offset() != null) {
            evaluateExpression(ctx.offset().expression());
            appendLine("storeAtVar\ntempOffset");
        }

        if (ctx.variable().variable() != null) {
            String namespace = ctx.variable().ID().getText();
            String name = ctx.variable().variable().ID().getText();

            if (!namespaces.containsKey(namespace))
                throw new LanguageException("Unknown namespace '" + namespace + "'");
            if (!namespaces.get(namespace).hasVariable(name))
                throw new LanguageException("'" + namespace + "' does not have variable '" + name + "'");

            varName = ctx.variable().ID().getText() + "_" + ctx.variable().variable().ID().getText();
        } else {
            //TODO: Add access to method arguments
            if (currentMethod != null && currentMethod.hasVariable(ctx.variable().ID().getText()))
                varName = currentNamespace.getName() + "_" + currentMethod.getName() + "_" + ctx.variable().ID().getText();
            else
                varName = currentNamespace.getName() + "_" + ctx.variable().ID().getText();
        }

        if (ctx.VARIABLE_SINGLE_MODIFIER() != null) {
            if (ctx.VARIABLE_SINGLE_MODIFIER().getText().equals("++")) {
                if (ctx.offset() != null) {
                    appendLine("loadAtVarWithOffset\n" + varName + "\ntempOffset");
                    appendLine("storeAtVar\ntempOffsetVar");
                    appendLine("ldi\n1\naddWithVar\ntempOffsetVar");
                    appendLine("storeAtVarWithOffset\n" + varName + "\ntempOffset");
                } else {
                    appendLine("ldi\n1\naddWithVar\n" + varName);
                    appendLine("storeAtVar\n" + varName);
                }
            } else {
                if (ctx.offset() != null) {
                    appendLine("loadAtVarWithOffset\n" + varName + "\ntempOffset");
                    appendLine("storeAtVar\ntempOffsetVar");
                    appendLine("ldi\n1\nsubWithVar\ntempOffsetVar");
                    appendLine("storeAtVarWithOffset\n" + varName + "\ntempOffset");
                } else {
                    appendLine("ldi\n1\nsubWithVar\n" + varName);
                    appendLine("storeAtVar\n" + varName);
                }
            }
            return;
        } //variable modifier == null

        evaluateExpression(ctx.expression());
        if (ctx.offset() != null) {
            appendLine("storeAtVar\ntmpExpression");
            evaluateExpression(ctx.offset().expression());
            appendLine("storeAtVar\ntempOffset");
            appendLine("loadAtVar\ntmpExpression");
        }
        if (ctx.VARIABLE_MODIFIER() != null) {
            if (ctx.offset() != null) {
                appendLine("loadAtVarWithOffset\n" + varName + "\ntempOffset");
                appendLine("storeAtVar\ntempOffsetVar");

                switch (ctx.VARIABLE_MODIFIER().getText()) {
                    case "+=" -> appendLine("addWithVar\ntempOffsetVar");
                    case "-=" -> appendLine("subWithVar\ntempOffsetVar");
                    case "*=" -> appendLine("mulWithVar\ntempOffsetVar");
                    case "/=" -> appendLine("divWithVar\ntempOffsetVar");
                    case "%=" -> appendLine("modWithVar\ntempOffsetVar");
                    default -> throw new LanguageException("'=' expected");
                }
            } else {
                switch (ctx.VARIABLE_MODIFIER().getText()) {
                    case "+=" -> appendLine("addWithVar\n" + varName);
                    case "-=" -> appendLine("subWithVar\n" + varName);
                    case "*=" -> appendLine("mulWithVar\n" + varName);
                    case "/=" -> appendLine("divWithVar\n" + varName);
                    case "%=" -> appendLine("modWithVar\n" + varName);
                    default -> throw new LanguageException("'=' expected");
                }
            }
        }
        if (ctx.offset() != null)
            appendLine("storeAtVarWithOffset\n" + varName + "\ntempOffset");
        else
            appendLine("storeAtVar\n" + varName);
    }

    @Override
    public void enterMethodCall(CParser.MethodCallContext ctx) {

    }

    @Override
    public void exitMethodCall(CParser.MethodCallContext ctx) {
        if (currentMethod == null)
            throw new LanguageException("Cannot call method from outside of method.");

        //System.out.println("calling method '" + ctx.variable().getText() + "'");
        if (!(ctx.parent instanceof CParser.ValueContext))
            evaluateMethodCall(ctx);
    }

    @Override
    public void visitTerminal(TerminalNode terminalNode) {

    }

    @Override
    public void visitErrorNode(ErrorNode errorNode) {

    }

    @Override
    public void enterEveryRule(ParserRuleContext parserRuleContext) {
        line = parserRuleContext.getStart().getLine();
        col = parserRuleContext.getStart().getCharPositionInLine();
    }

    @Override
    public void exitEveryRule(ParserRuleContext parserRuleContext) {

    }
}
