package jvm_class_file;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConstantPool {

    private final JvmClassFile jvmClassFile;
    private short currentIndex = 1;

    private final SortedSet<ConstantPoolEntry> allConstantPoolEntries
            = new TreeSet<>((x, y) -> x.index - y.index);

    private final Map<Short, ConstantClassInfo> constantClassMap = new HashMap<>();
    private final Map<Integer, ConstantFieldRefInfo> constantFieldRefInfoMap = new HashMap<>();
    private final Map<Float, ConstantFloatInfo> constantFloatInfoMap = new HashMap<>();
    private final Map<Integer, ConstantIntegerInfo> constantIntegerInfoMap = new HashMap<>();
    private final Map<Integer, ConstantInterfaceMethodRefInfo> constantInterfaceMethodRefInfoMap = new HashMap<>();
    private final Map<Long, ConstantLongInfo> constantLongInfoMap = new HashMap<>();
    private final Map<Integer, ConstantMethodRefInfo> constantMethodRefInfoMap = new HashMap<>();
    private final Map<Integer, ConstantNameAndTypeInfo> constantNameAndTypeInfoMap = new HashMap<>();
    private final Map<Short, ConstantStringInfo> constantStringInfoMap = new HashMap<>();
    private final Map<String, ConstantUtf8Info> constantUtf8InfoMap = new HashMap<>();

    protected ConstantPool(JvmClassFile jvmClassFile) {
        this.jvmClassFile = jvmClassFile;
    }

    public ConstantClassInfo constantClass(ConstantUtf8Info name) throws IllegalArgumentException {

        if (name == null)
            throw new IllegalArgumentException("name cannot be null");

        if (name.jvmClassFile != this.jvmClassFile)
            throw new IllegalArgumentException(JvmClassFile.DIFFERENT_FILE_ERROR);

        ConstantClassInfo constantClassInfo = this.constantClassMap.get(name.index);

        if (constantClassInfo != null)
            return constantClassInfo;

        constantClassInfo = new ConstantClassInfo(this.jvmClassFile, this.currentIndex++, name);
        this.constantClassMap.put(name.index, constantClassInfo);

        this.allConstantPoolEntries.add(constantClassInfo);

        return constantClassInfo;
    }

    public ConstantFieldRefInfo constantFieldRefInfo(
            ConstantClassInfo classInfo, ConstantNameAndTypeInfo nameAndType
    ) throws IllegalArgumentException {

        if (classInfo == null)
            throw new IllegalArgumentException("classInfo cannot be null");

        if (nameAndType == null)
            throw new IllegalArgumentException("nameAndType cannot be null");

        if ((classInfo.jvmClassFile != this.jvmClassFile) || (nameAndType.jvmClassFile != this.jvmClassFile))
            throw new IllegalArgumentException(JvmClassFile.DIFFERENT_FILE_ERROR);

        final int key = (classInfo.index << 2) | nameAndType.index;

        ConstantFieldRefInfo constantFieldRefInfo = this.constantFieldRefInfoMap.get(key);

        if (constantFieldRefInfo != null)
            return constantFieldRefInfo;

        constantFieldRefInfo = new ConstantFieldRefInfo(this.jvmClassFile, this.currentIndex++, classInfo, nameAndType);
        this.constantFieldRefInfoMap.put(key, constantFieldRefInfo);

        this.allConstantPoolEntries.add(constantFieldRefInfo);

        return constantFieldRefInfo;
    }

    public ConstantFloatInfo constantFloatInfo(float floatValue) {

        ConstantFloatInfo constantFloatInfo = this.constantFloatInfoMap.get(floatValue);

        if (constantFloatInfo != null)
            return constantFloatInfo;

        constantFloatInfo = new ConstantFloatInfo(this.jvmClassFile, this.currentIndex++, floatValue);
        this.constantFloatInfoMap.put(floatValue, constantFloatInfo);

        this.allConstantPoolEntries.add(constantFloatInfo);

        return constantFloatInfo;
    }

    public ConstantIntegerInfo constantIntegerInfo(int integer) {

        ConstantIntegerInfo constantIntegerInfo = this.constantIntegerInfoMap.get(integer);

        if (constantIntegerInfo != null)
            return constantIntegerInfo;

        constantIntegerInfo = new ConstantIntegerInfo(this.jvmClassFile, this.currentIndex++, integer);
        this.constantIntegerInfoMap.put(integer, constantIntegerInfo);

        this.allConstantPoolEntries.add(constantIntegerInfo);

        return constantIntegerInfo;
    }

    public ConstantInterfaceMethodRefInfo constantInterfaceMethodRefInfo(
            ConstantClassInfo classInfo, ConstantNameAndTypeInfo nameAndType
    ) throws IllegalArgumentException {

        if (classInfo == null)
            throw new IllegalArgumentException("classInfo cannot be null");

        if (nameAndType == null)
            throw new IllegalArgumentException("nameAndType cannot be null");

        if ((classInfo.jvmClassFile != this.jvmClassFile) || (nameAndType.jvmClassFile != this.jvmClassFile))
            throw new IllegalArgumentException(JvmClassFile.DIFFERENT_FILE_ERROR);

        final int key = (classInfo.index << 2) | nameAndType.index;

        ConstantInterfaceMethodRefInfo constantInterfaceMethodRefInfo = this.constantInterfaceMethodRefInfoMap.get(key);

        if (constantInterfaceMethodRefInfo != null)
            return constantInterfaceMethodRefInfo;

        constantInterfaceMethodRefInfo =
                new ConstantInterfaceMethodRefInfo(this.jvmClassFile, this.currentIndex++, classInfo, nameAndType);
        this.constantInterfaceMethodRefInfoMap.put(key, constantInterfaceMethodRefInfo);

        this.allConstantPoolEntries.add(constantInterfaceMethodRefInfo);

        return constantInterfaceMethodRefInfo;
    }

    public ConstantLongInfo constantLongInfo(long longValue) {

        ConstantLongInfo constantLongInfo = this.constantLongInfoMap.get(longValue);

        if (constantLongInfo != null)
            return constantLongInfo;

        constantLongInfo = new ConstantLongInfo(this.jvmClassFile, this.currentIndex++, longValue);
        this.constantLongInfoMap.put(longValue, constantLongInfo);

        this.allConstantPoolEntries.add(constantLongInfo);

        return constantLongInfo;
    }

    public ConstantMethodRefInfo constantMethodRefInfo(
            ConstantClassInfo classInfo, ConstantNameAndTypeInfo nameAndType
    ) throws IllegalArgumentException {

        if (classInfo == null)
            throw new IllegalArgumentException("classInfo cannot be null");

        if (nameAndType == null)
            throw new IllegalArgumentException("nameAndType cannot be null");

        if ((classInfo.jvmClassFile != this.jvmClassFile) || (nameAndType.jvmClassFile != this.jvmClassFile))
            throw new IllegalArgumentException(JvmClassFile.DIFFERENT_FILE_ERROR);

        final int key = (classInfo.index << 2) | nameAndType.index;

        ConstantMethodRefInfo constantMethodRefInfo = this.constantMethodRefInfoMap.get(key);

        if (constantMethodRefInfo != null)
            return constantMethodRefInfo;

        constantMethodRefInfo =
                new ConstantMethodRefInfo(this.jvmClassFile, this.currentIndex++, classInfo, nameAndType);
        this.constantMethodRefInfoMap.put(key, constantMethodRefInfo);

        this.allConstantPoolEntries.add(constantMethodRefInfo);

        return constantMethodRefInfo;
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

    public ConstantStringInfo constantStringInfo(ConstantUtf8Info utf8) throws IllegalArgumentException {

        if (utf8 == null)
            throw new IllegalArgumentException("utf8 cannot be null");

        if (utf8.jvmClassFile != this.jvmClassFile)
            throw new IllegalArgumentException(JvmClassFile.DIFFERENT_FILE_ERROR);

        ConstantStringInfo constantStringInfo = this.constantStringInfoMap.get(utf8.index);

        if (constantStringInfo != null)
            return constantStringInfo;

        constantStringInfo = new ConstantStringInfo(this.jvmClassFile, this.currentIndex++, utf8);
        this.constantStringInfoMap.put(utf8.index, constantStringInfo);

        this.allConstantPoolEntries.add(constantStringInfo);

        return constantStringInfo;
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
}
