package compiler.lib;

import antlr.CParser;
import compiler.Compiler;
import compiler.Method;
import compiler.Namespace;

import java.util.List;

public class Graphics extends Namespace {
    public Graphics() {
        super("graphics");

        super.addMethod("putPixel", new putPixel());
        super.addMethod("drawLine", new drawLine());
        super.addMethod("fillRect", new fillRect());
        super.addMethod("setColor", new setColor());
        super.addMethod("setStrokeWidth", new setStrokeWidth());
        super.addMethod("clear", new clear());
        super.addMethod("drawString", new drawString());
        super.addMethod("createColor", new createColor());
        super.addMethod("flip", new flip());
        super.addMethod("newLine", new newLine());


        super.isSystemLibrary = true;
    }

    private static class putPixel extends Method {

        public putPixel() {
            super(false, true, "putPixel", List.of("x", "y"), "graphics_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> arguments) {
            super.checkArgumentCount(arguments);

            Compiler.evaluateExpression(arguments.get(0));
            Compiler.appendLine("storeAtVar\nputPixelX");
            Compiler.evaluateExpression(arguments.get(1));
            Compiler.appendLine("storeAtVar\nputPixelY");
            Compiler.appendLine("putPixel\nputPixelX\nputPixelY");
        }
    }
    private static class drawLine extends Method {

        public drawLine() {
            super(false, true, "drawLine", List.of("x0", "y0", "x1", "y1"), "graphics_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> arguments) {
            super.checkArgumentCount(arguments);

            Compiler.evaluateExpression(arguments.get(0));
            Compiler.appendLine("storeAtVar\nputLineX0");
            Compiler.evaluateExpression(arguments.get(1));
            Compiler.appendLine("storeAtVar\nputLineY0");
            Compiler.evaluateExpression(arguments.get(2));
            Compiler.appendLine("storeAtVar\nputLineX1");
            Compiler.evaluateExpression(arguments.get(3));
            Compiler.appendLine("storeAtVar\nputLineY1");
            Compiler.appendLine("putLine\nputLineX0\nputLineY0\nputLineX1\nputLineY1");
        }
    }
    private static class fillRect extends Method {

        public fillRect() {
            super(false, true, "fillRect", List.of("x", "y", "width", "height"), "graphics_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> arguments) {
            super.checkArgumentCount(arguments);

            Compiler.evaluateExpression(arguments.get(0));
            Compiler.appendLine("storeAtVar\nputRectX");
            Compiler.evaluateExpression(arguments.get(1));
            Compiler.appendLine("storeAtVar\nputRectY");
            Compiler.evaluateExpression(arguments.get(2));
            Compiler.appendLine("storeAtVar\nputRectWidth");
            Compiler.evaluateExpression(arguments.get(3));
            Compiler.appendLine("storeAtVar\nputRectHeight");
            Compiler.appendLine("putRect\nputRectX\nputRectY\nputRectWidth\nputRectHeight");
        }
    }
    private static class setColor extends Method {

        public setColor() {
            super(false, true, "setColor", List.of("color"), "graphics_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> arguments) {
            super.checkArgumentCount(arguments);

            Compiler.evaluateExpression(arguments.get(0));
            Compiler.appendLine("storeAtVar\nsetColorColor");
            Compiler.appendLine("setColor\nsetColorColor");
        }
    }

    private static class setStrokeWidth extends Method {

        public setStrokeWidth() {
            super(false, true, "setStrokeWidth", List.of("width"), "graphics_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> arguments) {
            super.checkArgumentCount(arguments);

            Compiler.evaluateExpression(arguments.get(0));
            Compiler.appendLine("storeAtVar\nsetStrokeWidthWidth");
            Compiler.appendLine("setStrokeWidth\nsetStrokeWidthWidth");
        }
    }

    private static class clear extends Method {

        public clear() {
            super(false, true, "clear", List.of(), "graphics_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);
            Compiler.appendLine("clg");
        }
    }

    private static class drawString extends Method {

        public drawString() {
            super(false, true, "drawString", List.of("text"), "graphics_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\ndrawStringText");
            Compiler.appendLine("drawText\ndrawStringText");
        }
    }

    private static class createColor extends Method {
        public createColor() {
            super(true, true, "createColor", List.of("r", "g", "b"), "graphics_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\ncreateColorR");
            Compiler.evaluateExpression(args.get(1));
            Compiler.appendLine("storeAtVar\ncreateColorG");
            Compiler.evaluateExpression(args.get(2));
            Compiler.appendLine("storeAtVar\ncreateColorB");

            Compiler.appendLine("createColor\ncreateColorR\ncreateColorG\ncreateColorB");
            Compiler.appendLine("storeAtVar\n" + super.getReturnVariableName());
        }
    }

    private static class flip extends Method {
        public flip() {
            super(false, true, "flip", List.of(), "graphics_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.appendLine("graphicsFlip");
        }
    }

    private static class newLine extends Method {
        public newLine() {
            super(false, true, "newLine", List.of(), "graphics_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.appendLine("newLine");
        }
    }
}
