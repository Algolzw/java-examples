package algo.study.java.base.IOExample.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * 配合textFile类,对一个文件中所有出现过的字符计数
 */
public class CharacterCounter {

    private static Map<Character, Integer> charMap = new HashMap<>();

    public CharacterCounter() {
    }

    public CharacterCounter(String filename) {
        TextFile textFile = new TextFile(filename, "");
        for (String s : textFile) {
            char c = s.charAt(0);
            if (charMap.containsKey(c)) {
                int v = charMap.get(c);
                charMap.put(c, ++v);
                continue;
            }
            charMap.put(c, 1);
        }
    }

    public Map<Character, Integer> getMap() {
        return charMap;
    }

    public int count(char c) {
        return charMap.getOrDefault(c, 0);
    }

    public static void main(String[] args) {
        CharacterCounter counter = new CharacterCounter("./src/output/BasicFileOutput.out");
        Map<Character, Integer> map = counter.getMap();
        map.keySet().forEach(k -> System.out.println(k + " : " + counter.count(k)));
    }

}
