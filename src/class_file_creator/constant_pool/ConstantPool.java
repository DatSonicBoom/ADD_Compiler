package class_file_creator.constant_pool;

import class_file_creator.JvmClassFile;

import java.util.HashMap;
import java.util.Map;

public class ConstantPool {

    private final JvmClassFile jvmClassFile;
    private int currentIndex = 1;

    Map<String, ConstantUtf8Info> constantUtf8InfoMap = new HashMap<>();

    public ConstantPool(JvmClassFile jvmClassFile) {
        this.jvmClassFile = jvmClassFile;
    }

    public ConstantUtf8Info makeConstantUtf8Info(String string) {

        ConstantUtf8Info value = this.constantUtf8InfoMap.get(string);

        if (value != null)
            return value;

        value = new ConstantUtf8Info(this.jvmClassFile, this.currentIndex++, string);
        this.constantUtf8InfoMap.put(string, value);

        return value;
    }
}
