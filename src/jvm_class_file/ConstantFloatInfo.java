package jvm_class_file;

import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantFloatInfo extends ConstantPoolEntry {

    private float floatValue;

    protected ConstantFloatInfo(JvmClassFile jvmClassFile, short index, float floatValue) {

        super(jvmClassFile, index);

        this.floatValue = floatValue;
    }

    @Override
    public void write(DataOutputStream dos) throws IOException {

        dos.writeByte(4); // Write tag (always 4 for CONSTANT_Float_info)
        dos.writeFloat(this.floatValue); // Write bytes
    }
}
