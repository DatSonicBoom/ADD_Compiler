package jvm_class_file;

import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantStringInfo extends ConstantPoolEntry {

    private final ConstantUtf8Info utf8;

    protected ConstantStringInfo(
            JvmClassFile jvmClassFile, short index, ConstantUtf8Info utf8
    ) throws IllegalArgumentException {

        super(jvmClassFile, index);

        if (utf8 == null)
            throw new IllegalArgumentException("utf8 cannot be null");

        if (utf8.jvmClassFile != this.jvmClassFile)
            throw new IllegalArgumentException(JvmClassFile.DIFFERENT_FILE_ERROR);

        this.utf8 = utf8;
    }

    @Override
    protected void write(DataOutputStream dos) throws IOException {

        dos.writeByte(8); // Write tag (always 8 for CONSTANT_String_info)
        dos.writeShort(this.utf8.index); // Write string_index
    }
}
