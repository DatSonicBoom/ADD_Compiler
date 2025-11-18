package jvm_class_file;

import java.io.File;

public class JvmClassFile {

    protected static final String DIFFERENT_FILE_ERROR =
            "ConstantPoolEntry dependencies must belong to the same JvmClassFile";

    private final File file;

    private final ConstantPool constantPool = new ConstantPool(this);

    public JvmClassFile(File file) throws IllegalArgumentException {

        if (file == null)
            throw new IllegalArgumentException("file cannot be null");

        this.file = file;
    }

    public ConstantPool constantPool() {
        return this.constantPool;
    }
}
