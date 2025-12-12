package jvm_class_file;

import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantLongInfo extends ConstantPoolEntry {

    private long longValue;

    protected ConstantLongInfo(JvmClassFile jvmClassFile, short index, long longValue) {

        super(jvmClassFile, index);

        this.longValue = longValue;
    }

    @Override
    protected void write(DataOutputStream dos) throws IOException {

        dos.writeByte(5); // Write tag (always 5 for CONSTANT_Long_info)
        dos.writeLong(this.longValue); // Write high_bytes and low_bytes
    }
}
