package class_file_creator.constant_pool;

import class_file_creator.JvmClassFile;

public abstract class ConstantPoolEntry {

    protected final JvmClassFile jvmClassFile;
    protected final int index;

    protected ConstantPoolEntry(JvmClassFile jvmClassFile, int index) throws IllegalArgumentException {

        if (jvmClassFile == null)
            throw new IllegalArgumentException("jvmClassFile cannot be null");

        this.jvmClassFile = jvmClassFile;
        this.index = index;
    }

    public abstract byte[] byteStream();
}
