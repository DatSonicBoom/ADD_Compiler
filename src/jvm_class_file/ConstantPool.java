package jvm_class_file;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConstantPool {

    private final JvmClassFile jvmClassFile;
    private short currentIndex = 1;

    private final SortedSet<ConstantPoolEntry> allConstantPoolEntries = new TreeSet<>();

    private final Map<String, ConstantUtf8Info> constantUtf8InfoMap = new HashMap<>();
    private final Map<Integer, ConstantNameAndTypeInfo> constantNameAndTypeInfoMap = new HashMap<>();

    protected ConstantPool(JvmClassFile jvmClassFile) {
        this.jvmClassFile = jvmClassFile;
    }

    public ConstantUtf8Info constantUtf8Info(String string) throws IllegalArgumentException {

        if (string == null)
            throw new IllegalArgumentException("string cannot be null");

        ConstantUtf8Info constantUtf8Info = this.constantUtf8InfoMap.get(string);

        if (constantUtf8Info != null)
            return constantUtf8Info;

        constantUtf8Info = new ConstantUtf8Info(this.jvmClassFile, this.currentIndex++, string);
        this.constantUtf8InfoMap.put(string, constantUtf8Info);

        this.allConstantPoolEntries.add(constantUtf8Info);

        return constantUtf8Info;
    }

    public ConstantNameAndTypeInfo constantNameAndTypeInfo(
            ConstantUtf8Info name, ConstantUtf8Info descriptor
    ) throws IllegalArgumentException {

        if (name == null)
            throw new IllegalArgumentException("name cannot be null");

        if (descriptor == null)
            throw new IllegalArgumentException("descriptor cannot be null");

        if ((name.jvmClassFile != this.jvmClassFile) || (descriptor.jvmClassFile != this.jvmClassFile))
            throw new IllegalArgumentException(JvmClassFile.DIFFERENT_FILE_ERROR);

        final int key = (name.index << 2) | descriptor.index;

        ConstantNameAndTypeInfo constantNameAndTypeInfo = this.constantNameAndTypeInfoMap.get(key);

        if (constantNameAndTypeInfo != null)
            return constantNameAndTypeInfo;

        constantNameAndTypeInfo = new ConstantNameAndTypeInfo(this.jvmClassFile, this.currentIndex++, name, descriptor);
        this.constantNameAndTypeInfoMap.put(key, constantNameAndTypeInfo);

        this.allConstantPoolEntries.add(constantNameAndTypeInfo);

        return constantNameAndTypeInfo;
    }
}
