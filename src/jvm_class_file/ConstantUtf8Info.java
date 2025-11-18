package jvm_class_file;

import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantUtf8Info extends ConstantPoolEntry {

    private final String string;

    protected ConstantUtf8Info(JvmClassFile jvmClassFile, short index, String string) throws IllegalArgumentException {
        super(jvmClassFile, index);

        if (string == null)
            throw new IllegalArgumentException("string cannot be null");

        this.string = string;
    }

    @Override
    protected void write(DataOutputStream dos) throws IOException {

        dos.writeByte(1); // Write tag (always 1 for Constant_Utf-8_info)
        dos.writeUTF(this.string); // Write length and bytes
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof ConstantUtf8Info c) {

            if (this.jvmClassFile != c.jvmClassFile)
                return false;

            return this.string.equals(c.string);
        }

        return false;
    }
}
