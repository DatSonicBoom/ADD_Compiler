package code_representation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.StringBuilder;

public class SourceCodeFile implements SourceCode {

    private final String sourceCode;

    public SourceCodeFile(File sourceCodeFile) throws IllegalArgumentException {

        if (sourceCodeFile == null)
            throw new IllegalArgumentException("sourceCodeFile cannot be null");

        try (BufferedReader bf = new BufferedReader(new FileReader(sourceCodeFile))) {

            this.sourceCode = bf.lines()
                    .collect(
                            StringBuilder::new,
                            (b, s) -> b.append(s).append('\n'),
                            StringBuilder::append
                    )
                    .toString();
        }

        catch (FileNotFoundException e) {

            throw new IllegalArgumentException(
                    "File " + sourceCodeFile.getPath() + " could not be found", e
            );
        }

        catch (Exception e) {

            throw new IllegalArgumentException(
                    "Error when attempting to read file " + sourceCodeFile.getPath(), e
            );
        }
    }

    public SourceCodeFile(String sourceCodeFilepath) {
        this(new File(sourceCodeFilepath));
    }

    @Override
    public String sourceCode() {
        return this.sourceCode;
    }
}
