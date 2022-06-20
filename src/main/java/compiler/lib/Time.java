package compiler.lib;

import antlr.CParser;
import compiler.Compiler;
import compiler.Method;
import compiler.Namespace;

import java.util.List;

public class Time extends Namespace {
    public Time() {
        super("time");

        super.addMethod("sleep", new sleep());
        super.addMethod("getRuntimeMillis", new getRuntimeMillis());

        super.isSystemLibrary = true;
    }

    private static class sleep extends Method {
        public sleep() {
            super(false, true, "sleep", List.of("millis"), "time_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.evaluateExpression(args.get(0));
            Compiler.appendLine("storeAtVar\ncallMillis");
            Compiler.appendLine("sleep\ncallMillis");
        }
    }

    private static class getRuntimeMillis extends Method {
        public getRuntimeMillis() {
            super(true, true, "getRuntimeMillis", List.of(), "time_");
        }

        @Override
        public void call(List<CParser.ExpressionContext> args) {
            super.checkArgumentCount(args);

            Compiler.appendLine("runtimeMillis\nstoreAtVar\n" + super.getReturnVariableName());
        }
    }
}
