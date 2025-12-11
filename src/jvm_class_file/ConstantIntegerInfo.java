package jvm_class_file;

import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantIntegerInfo extends ConstantPoolEntry {

    private final int integer;

    protected ConstantIntegerInfo(JvmClassFile jvmClassFile, short index, int integer) throws IllegalArgumentException {

        super(jvmClassFile, index);

        this.integer = integer;
    }

    @Override
    protected void write(DataOutputStream dos) throws IOException {

        dos.writeByte(3); // Write tag (always 3 for CONSTANT_Integer_info)
        dos.writeInt(this.integer); // Write bytes
    }
}
