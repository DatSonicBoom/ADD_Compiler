package jvm_class_file;

import java.io.DataOutputStream;
import java.io.IOException;

public class ConstantNameAndTypeInfo extends ConstantPoolEntry {

    private final ConstantUtf8Info name;
    private final ConstantUtf8Info descriptor;

    protected ConstantNameAndTypeInfo(
            JvmClassFile jvmClassFile, short index, ConstantUtf8Info name, ConstantUtf8Info descriptor
    ) throws IllegalArgumentException {
        super(jvmClassFile, index);

        if (name == null)
            throw new IllegalArgumentException("name cannot be null");

        if (descriptor == null)
            throw new IllegalArgumentException("descriptor cannot be null");

        if (name.jvmClassFile != this.jvmClassFile || descriptor.jvmClassFile != this.jvmClassFile)
            throw new IllegalArgumentException(JvmClassFile.DIFFERENT_FILE_ERROR);

        this.name = name;
        this.descriptor = descriptor;
    }

    @Override
    protected void write(DataOutputStream dos) throws IOException {

        dos.writeByte(12); // Write tag (always 12 for CONSTANT_NameAndType_info)
        dos.writeShort(this.name.index()); // Write name_index
        dos.writeShort(this.descriptor.index()); // Write descriptor_index
    }

    @Override
    public int hashCode() {
        return (this.name.index << 2) | this.descriptor.index;
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof ConstantNameAndTypeInfo c) {

            if (this.jvmClassFile != c.jvmClassFile)
                return false;

            if (!this.name.equals(c.name))
                return false;

            return this.descriptor.equals(c.descriptor);
        }

        return false;
    }
}
