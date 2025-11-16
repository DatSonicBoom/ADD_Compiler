package class_file_creator.constant_pool;

public abstract class ConstantPoolItem {

    protected final ConstantPool constantPool;
    protected final int slot;

    protected ConstantPoolItem(ConstantPool constantPool, int slot) throws IllegalArgumentException {

        if (constantPool == null)
            throw new IllegalArgumentException("constantPool cannot be null");

        this.constantPool = constantPool;
        this.slot = slot;
    }

    public abstract byte[] byteStream();
}
