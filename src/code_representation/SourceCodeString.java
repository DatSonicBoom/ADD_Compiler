package code_representation;

public class SourceCodeString implements SourceCode {

    private final String sourceCode;

    public SourceCodeString(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Override
    public String sourceCode() {
        return this.sourceCode;
    }
}
