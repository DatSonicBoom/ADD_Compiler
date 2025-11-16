package class_file_creator.constant_pool;

import class_file_creator.JvmClassFile;

import java.util.Map;
import java.util.TreeMap;

public class ConstantPool {

    private final JvmClassFile jvmClassFile;
    private int currentIndex = 1;

    Map<String, ConstantUtf8Info> constantUtf8InfoSet = new TreeMap<>();

    public ConstantPool(JvmClassFile jvmClassFile) {
        this.jvmClassFile = jvmClassFile;
    }

    public ConstantUtf8Info makeConstantUtf8Info(String string) {

        ConstantUtf8Info value = this.constantUtf8InfoSet.get(string);

        if (value != null)
            return value;

        value = new ConstantUtf8Info(this.jvmClassFile, this.currentIndex++, string);
        this.constantUtf8InfoSet.put(string, value);

        return value;
    }
}
