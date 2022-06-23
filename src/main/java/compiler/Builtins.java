package compiler;

import antlr.CParser;
import java.util.List;

import static compiler.Compiler.*;

public class Builtins {
    public static void addAll(Namespace namespace) {
        namespace.addMethod("println", new println());
        namespace.addMethod("_asm_", new _asm_());
        namespace.addMethod("_valueOfA_", new _valueOfA_());
        namespace.addMethod("malloc", new malloc());
        namespace.addMethod("exit", new exit());
    }
    public static class println extends Method {
        public println() {
            super(false, true, "println", List.of(), "println_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            for (CParser.ExpressionContext expr : args) {
                evaluateExpression(expr);
                appendLine("println");
            }
        }
    }

    public static class _asm_ extends Method {
        public _asm_() {
            super(false, true, "_asm_", List.of("asm"), "_asm__");
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
            super(true, true, "valueOfA", List.of(), "1valueOfA_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);
            appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }

    public static class malloc extends Method {
        public malloc() {
            super(true, true, "malloc", List.of("words"), "std_");
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
            super(false, true, "exit", List.of(), "exit_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);
            appendLine("done");
        }
    }
}
