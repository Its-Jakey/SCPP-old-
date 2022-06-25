package compiler;

import antlr.CParser;
import java.util.List;

import static compiler.Compiler.*;

public class Builtins {
    public static void addAll(Namespace namespace) {
        namespace.addMethod("println", new println());
        namespace.addMethod("print", new print());
        namespace.addMethod("_asm_", new _asm_());
        namespace.addMethod("_valueOfA_", new _valueOfA_());
        namespace.addMethod("malloc", new malloc());
        namespace.addMethod("exit", new exit());
        namespace.addMethod("concat", new concat());
    }
    public static class println extends Method {
        public println() {
            super(false, true, "println", List.of(), "__builtins__");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            for (int i = 0; i < args.size(); i++) {
                CParser.ExpressionContext expr = args.get(i);
                evaluateExpression(expr);
                appendLine("print");

                if (i + 1 < args.size()) {
                    appendLine("ldi\n ");
                    appendLine("print");
                }
            }
            appendLine("ldi\n");
            appendLine("println");
        }
    }

    public static class print extends Method {
        public print() {
            super(false, true, "print", List.of(), "");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            for (int i = 0; i < args.size(); i++) {
                CParser.ExpressionContext arg = args.get(i);
                evaluateExpression(arg);
                appendLine("print");

                if (i + 1 < args.size()) {
                    appendLine("ldi\n ");
                    appendLine("print");
                }
            }
        }
    }

    public static class _asm_ extends Method {
        public _asm_() {
            super(false, true, "_asm_", List.of("asm"), "__builtins__");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            if (args.size() < 1)
                throw new LanguageException("_asm_ takes 1 or more arguments, but 0 was given.");

            StringBuilder asm = new StringBuilder(parseString(args.get(0).getText()));
            for (int i = 1; i < args.size(); i++) {
                evaluateExpression(args.get(i));
                appendLine("storeAtVar\nasmExpression" + i);

                asm.append("\nasmExpression").append(i);
            }

            appendLine(asm);
        }
    }

    public static class _valueOfA_ extends Method {
        public _valueOfA_() {
            super(true, true, "valueOfA", List.of(), "__builtins__");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);
            appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }

    public static class malloc extends Method {
        public malloc() {
            super(true, true, "malloc", List.of("words"), "__builtins__");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\nmallocWords");
            Compiler.appendLine("malloc\nmallocWords");
            Compiler.appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }

    public static class exit extends Method {
        public exit() {
            super(false, true, "exit", List.of(), "__builtins__");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);
            appendLine("done");
        }
    }

    public static class concat extends Method {
        public concat() {
            super(true, true, "concat", List.of(), "__builtins__");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            if (args.size() < 2)
                throw new LanguageException("concat takes at least 2 arguments, but " + args.size() + " were given.");
            appendLine("ldi\n");
            appendLine("storeAtVar\n" + super.getReturnVariableName());

            for (CParser.ExpressionContext arg : args) {
                evaluateExpression(arg);
                appendLine("join\n" + super.getReturnVariableName());
                appendLine("storeAtVar\n" + super.getReturnVariableName());
            }
        }
    }
}
