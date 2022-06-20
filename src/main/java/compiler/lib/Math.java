package compiler.lib;

import antlr.CParser;
import compiler.Compiler;
import compiler.Method;

import java.util.List;

public class Math {
    public static class round extends Method {
        public round() {
            super(true, true, "round", List.of("x"), "math_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\nroundX");
            Compiler.appendLine("round\nroundX");
            Compiler.appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }
    public static class sin extends Method {
        public sin() {
            super(true, true, "sin", List.of("x"), "math_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\nsinX");
            Compiler.appendLine("sin\nsinX");
            Compiler.appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }
    public static class cos extends Method {
        public cos() {
            super(true, true, "cos", List.of("x"), "math_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\ncosX");
            Compiler.appendLine("cos\ncosX");
            Compiler.appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }
}
