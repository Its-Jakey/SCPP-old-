package compiler;

import antlr.CParser;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Method {
    private final LinkedHashMap<String, String> variables = new LinkedHashMap<>();
    private final boolean returnsString, isPublic;
    private final String returnVariableName, name, variablePrefix;
    private final LinkedHashMap<String, String> argumentNames = new LinkedHashMap<>();
    private static int returns = 0;

    public Method(boolean returnsVariable, boolean isPublic, String name, List<String> args, String variablePrefix) {
        this.returnsString = returnsVariable;
        this.isPublic = isPublic;
        this.name = name;
        this.variablePrefix = variablePrefix;

        for (String arg : args)
            argumentNames.put(arg, name + "_" + variablePrefix + arg);

        if (returnsVariable)
            returnVariableName = name + "_" + variablePrefix + "r_" + returns++;
        else
            returnVariableName = null;
    }

    public void checkArgumentCount(List<CParser.ExpressionContext> args) {
        if (args.size() != argumentNames.size())
            throw new LanguageException(name + " takes " + argumentNames.size() + " arguments, but " + args.size() + " were given.");
    }

    public void call(List<CParser.ExpressionContext> arguments) {
        checkArgumentCount(arguments);
        List<Map.Entry<String, String>> argumentNames = this.argumentNames.entrySet().stream().toList();

        for (int i = 0; i < argumentNames.size(); i++) {
            Map.Entry<String, String> argumentName = argumentNames.get(i);
            Compiler.evaluateExpression(arguments.get(i));
            Compiler.appendLine("storeAtVar\n" + argumentName.getValue());
        }

        Compiler.appendLine("jts\n%" + variablePrefix + name + "%");
    }

    public void returnValue(CParser.ExpressionContext expression) {
        if (!returnsString)
            throw new LanguageException("Cannot return value for methods of type void");

        Compiler.evaluateExpression(expression);
        Compiler.appendLine("storeAtVar\n" + returnVariableName);
    }

    public String getArgumentName(String arg) {
        return argumentNames.get(arg);
    }

    public boolean hasArgument(String arg) {
        return argumentNames.containsKey(arg);
    }

    public void addVariable(String name, String variable) {
        variables.put(name, variable);
    }

    public boolean hasVariable(String name) {
        return variables.containsKey(name);
    }

    public void removeVariable(String name) {
        variables.remove(name);
    }

    public String getVariable(String name) {
        return variables.get(name);
    }

    public boolean returnsVariable(){
        return returnsString;
    }

    public String getReturnVariableName(){
        return returnVariableName;
    }

    public boolean isPublic(){
        return isPublic;
    }

    public String getName() {
        return name;
    }
}
