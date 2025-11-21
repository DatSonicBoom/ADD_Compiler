package jvm_class_file;

import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantClassInfo extends ConstantPoolEntry {

    private final ConstantUtf8Info name;

    protected ConstantClassInfo(
            JvmClassFile jvmClassFile, short index, ConstantUtf8Info name
    ) throws IllegalArgumentException {
        super(jvmClassFile, index);

        if (name == null)
            throw new IllegalArgumentException("name cannot be null");

        if (name.jvmClassFile != this.jvmClassFile)
            throw new IllegalArgumentException(JvmClassFile.DIFFERENT_FILE_ERROR);

        this.name = name;
    }

    @Override
    protected void write(DataOutputStream dos) throws IOException {

        dos.writeByte(7); // Write tag (always 7 for CONSTANT_Class_info)
        dos.writeShort(this.name.index); // Write name_index
    }
}
