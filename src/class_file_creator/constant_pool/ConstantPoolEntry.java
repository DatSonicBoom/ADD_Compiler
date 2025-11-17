package class_file_creator.constant_pool;

import class_file_creator.JvmClassFile;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class ConstantPoolEntry implements Comparable<ConstantPoolEntry> {

    protected final JvmClassFile jvmClassFile;
    protected final short index;

    protected ConstantPoolEntry(JvmClassFile jvmClassFile, short index) throws IllegalArgumentException {

        if (jvmClassFile == null)
            throw new IllegalArgumentException("jvmClassFile cannot be null");

        this.jvmClassFile = jvmClassFile;
        this.index = index;
    }

    public short index() {
        return this.index;
    }

    @Override
    public int compareTo(ConstantPoolEntry c) {
        return this.index - c.index;
    }

    public abstract void write(DataOutputStream dos) throws IOException;
}
