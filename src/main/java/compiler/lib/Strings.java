package compiler.lib;

import antlr.CParser;
import compiler.Compiler;
import compiler.Method;

import java.util.List;

public class Strings {
    public static class charAt extends Method {
        public charAt() {
            super(true, true, "charAt", List.of("string", "idx"), "strings_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\ncharAtString");
            Compiler.evaluateExpression(args.get(1));
            Compiler.appendLine("storeAtVar\ncharAtIndex");

            Compiler.appendLine("charAt\ncharAtString\ncharAtIndex");
            Compiler.appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }

    public static class sizeOf extends Method {
        public sizeOf() {
            super(true, true, "sizeOf", List.of("string"), "strings_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\nsizeOfString");
            Compiler.appendLine("sizeOf\nsizeOfString");
            Compiler.appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }

    public static class contains extends Method {
        public contains() {
            super(true, true, "contains", List.of("a", "b"), "strings_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\ncontainsA");
            Compiler.evaluateExpression(args.get(1));
            Compiler.appendLine("storeAtVar\ncontainsB");

            Compiler.appendLine("contains\ncontainsA\ncontainsB");
            Compiler.appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }

    public static class join extends Method {
        public join() {
            super(true, true, "join", List.of("a", "b"), "strings_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\njoinA");

            Compiler.evaluateExpression(args.get(1));
            Compiler.appendLine("storeAtVar\njoinB");

            Compiler.appendLine("join\njoinA\njoinB");
            Compiler.appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }
}
