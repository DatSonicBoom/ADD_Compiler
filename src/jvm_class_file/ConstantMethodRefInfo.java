package jvm_class_file;

import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantMethodRefInfo extends ConstantPoolEntry {

    private final ConstantClassInfo classInfo;
    private final ConstantNameAndTypeInfo nameAndType;

    protected ConstantMethodRefInfo(
            JvmClassFile jvmClassFile, short index, ConstantClassInfo classInfo, ConstantNameAndTypeInfo nameAndType
    ) throws IllegalArgumentException {

        super(jvmClassFile, index);

        if (classInfo == null)
            throw new IllegalArgumentException("classInfo cannot be null");

        if (nameAndType == null)
            throw new IllegalArgumentException("nameAndType cannot be null");

        if ((classInfo.jvmClassFile != this.jvmClassFile) || (nameAndType.jvmClassFile != this.jvmClassFile))
            throw new IllegalArgumentException(JvmClassFile.DIFFERENT_FILE_ERROR);

        this.classInfo = classInfo;
        this.nameAndType = nameAndType;
    }

    @Override
    protected void write(DataOutputStream dos) throws IOException {

        dos.writeByte(10); // Write tag (always 10 for CONSTANT_MethodRef_info)
        dos.writeShort(this.classInfo.index); // Write class_index
        dos.writeShort(this.nameAndType.index); // Write name_and_type_index
    }
}
