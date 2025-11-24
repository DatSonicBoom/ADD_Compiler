package jvm_class_file;

import java.io.DataOutputStream;
import java.io.IOException;

public abstract class ConstantPoolEntry {

    protected final JvmClassFile jvmClassFile;
    protected final short index;

    protected ConstantPoolEntry(JvmClassFile jvmClassFile, short index) throws IllegalArgumentException {

        if (jvmClassFile == null)
            throw new IllegalArgumentException("jvmClassFile cannot be null");

        this.jvmClassFile = jvmClassFile;
        this.index = index;
    }

    protected abstract void write(DataOutputStream dos) throws IOException;
}
