package compiler.lib;

import antlr.CParser;
import compiler.Compiler;
import compiler.Method;
import compiler.Namespace;

import java.util.List;

public class Input extends Namespace {
    public Input() {
        super("input");

        super.addMethod("mouseX", new mouseX());
        super.addMethod("mouseY", new mouseY());
        super.addMethod("isMouseDown", new isMouseDown());
        super.addMethod("isKeyPressed", new isKeyPressed());
        super.addMethod("ask", new ask());

        super.isSystemLibrary = true;
    }

    private static class mouseX extends Method {
        public mouseX() {
            super(false, true, "mouseX", List.of(), "input_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);
            Compiler.appendLine("mouseX\nstoreAtVar\n" + super.getReturnVariableName());
        }
    }
    private static class mouseY extends Method {
        public mouseY() {
            super(false, true, "mouseY", List.of(), "input_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);
            Compiler.appendLine("mouseY\nstoreAtVar\n" + super.getReturnVariableName());
        }
    }

    private static class isMouseDown extends Method {
        public isMouseDown() {
            super(false, true, "isMouseDown", List.of(), "input_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);
            Compiler.appendLine("mouseDown\nstoreAtVar\n" + super.getReturnVariableName());
        }
    }

    private static class isKeyPressed extends Method {

        public isKeyPressed() {
            super(true, true, "isKeyPressed", List.of("key"), "input_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\nisKeyPressedKey");
            Compiler.appendLine("isKeyPressed\nisKeyPressedKey");
            Compiler.appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }

    private static class ask extends Method {

        public ask() {
            super(true, true, "ask", List.of("question"), "input_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\naskQuestion");
            Compiler.appendLine("ask\naskQuestion");
            Compiler.appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }
}
