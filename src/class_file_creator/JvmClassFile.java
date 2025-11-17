package class_file_creator;

import class_file_creator.constant_pool.ConstantPool;

import java.io.File;

public class JvmClassFile {

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
