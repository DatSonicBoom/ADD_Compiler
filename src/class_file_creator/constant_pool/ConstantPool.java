package class_file_creator.constant_pool;

import class_file_creator.JvmClassFile;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConstantPool {

    private final JvmClassFile jvmClassFile;
    private int currentIndex = 1;

    private final SortedSet<ConstantPoolEntry> allConstantPoolEntries = new TreeSet<>();

    private final Map<String, ConstantUtf8Info> constantUtf8InfoMap = new HashMap<>();

    public ConstantPool(JvmClassFile jvmClassFile) {
        this.jvmClassFile = jvmClassFile;
    }

    public ConstantUtf8Info constantUtf8Info(String string) {

        ConstantUtf8Info constantUtf8Info = this.constantUtf8InfoMap.get(string);

        if (constantUtf8Info != null)
            return constantUtf8Info;

        constantUtf8Info = new ConstantUtf8Info(this.jvmClassFile, this.currentIndex++, string);
        this.constantUtf8InfoMap.put(string, constantUtf8Info);

        this.allConstantPoolEntries.add(constantUtf8Info);

        return constantUtf8Info;
    }
}
