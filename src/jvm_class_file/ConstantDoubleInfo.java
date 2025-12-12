package jvm_class_file;

import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantDoubleInfo extends ConstantPoolEntry {

    private double doubleValue;

    protected ConstantDoubleInfo(JvmClassFile jvmClassFile, short index, double doubleValue) {

        super(jvmClassFile, index);

        this.doubleValue = doubleValue;
    }

    @Override
    protected void write(DataOutputStream dos) throws IOException {

        dos.writeByte(6); // Write tag (always 6 for CONSTANT_Double_info)
        dos.writeDouble(this.doubleValue); // Write high_bytes and low_bytes
    }
}
