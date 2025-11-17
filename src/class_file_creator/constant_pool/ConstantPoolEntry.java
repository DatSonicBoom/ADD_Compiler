package class_file_creator.constant_pool;

import class_file_creator.JvmClassFile;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class ConstantPoolEntry implements Comparable<ConstantPoolEntry> {

    protected final JvmClassFile jvmClassFile;
    protected final int index;

    protected ConstantPoolEntry(JvmClassFile jvmClassFile, int index) throws IllegalArgumentException {

        if (jvmClassFile == null)
            throw new IllegalArgumentException("jvmClassFile cannot be null");

        this.jvmClassFile = jvmClassFile;
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    @Override
    public int compareTo(ConstantPoolEntry c) {
        return this.index - c.index;
    }

    public abstract void write(DataOutputStream dos) throws IOException;
}
