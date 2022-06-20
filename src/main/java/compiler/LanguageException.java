package compiler;

public class LanguageException extends RuntimeException {
    public LanguageException(String msg) {
        super(Compiler.line + ":" + Compiler.col + "\t" + msg);
    }
}
