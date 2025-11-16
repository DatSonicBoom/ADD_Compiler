package class_file_creator.constant_pool;

import java.util.Map;
import java.util.TreeMap;

public class ConstantPool {

    private int slot = 1;

    Map<String, ConstantUtf8Info> constantUtf8InfoSet = new TreeMap<>();

    public ConstantUtf8Info makeConstantUtf8Info(String string) {

        ConstantUtf8Info value = this.constantUtf8InfoSet.get(string);

        if (value != null)
            return value;

        value = new ConstantUtf8Info(this, slot++, string);
        this.constantUtf8InfoSet.put(string, value);

        return value;
    }
}
