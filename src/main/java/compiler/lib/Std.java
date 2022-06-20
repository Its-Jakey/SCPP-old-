package compiler.lib;

import antlr.CParser;
import compiler.Compiler;
import compiler.Method;
import compiler.Namespace;

import java.util.List;

public class Std extends Namespace {
    public Std() {
        super("std");
        super.addMethod("malloc", new malloc());
        super.isSystemLibrary = true;
    }

    private static class malloc extends Method {
        public malloc() {
            super(false, true, "malloc", List.of("words"), "std_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\nmallocWords");
            Compiler.appendLine("malloc\nmallocWords");
        }
    }
}
