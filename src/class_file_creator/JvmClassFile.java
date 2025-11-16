package class_file_creator;

import class_file_creator.constant_pool.ConstantPool;

public class JvmClassFile {

    public final ConstantPool constantPool;

    public JvmClassFile() {
        this.constantPool = new ConstantPool(this);
    }
}
