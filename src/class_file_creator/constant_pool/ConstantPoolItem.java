package class_file_creator.constant_pool;

public abstract class ConstantPoolItem {

    protected final ConstantPool constantPool;
    protected final int slot;

    protected ConstantPoolItem(ConstantPool constantPool, int slot) {
        this.constantPool = constantPool;
        this.slot = slot;
    }
}
