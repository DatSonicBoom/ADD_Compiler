package class_file_creator.constant_pool;

import java.nio.charset.StandardCharsets;

public class ConstantUtf8Info extends ConstantPoolItem implements Comparable<ConstantUtf8Info> {

    private final String string;

    protected ConstantUtf8Info(ConstantPool constantPool, int slot, String string) throws IllegalArgumentException {
        super(constantPool, slot);

        if (string == null)
            throw new IllegalArgumentException("string cannot be null");

        this.string = string;
    }

    @Override
    public byte[] byteStream() {

        byte[] stringBytes = this.string.getBytes(StandardCharsets.UTF_8);
        byte[] output = new byte[stringBytes.length + 1];
        output[0] = 0x01;
        System.arraycopy(stringBytes, 0, output, 1, stringBytes.length);

        return output;
    }

    @Override
    public boolean equals(Object o) {

        if (o instanceof ConstantUtf8Info c)
            return c.string.equals(this.string);

        return false;
    }

    @Override
    public int compareTo(ConstantUtf8Info c) {

        return this.string.compareTo(c.string);
    }
}
