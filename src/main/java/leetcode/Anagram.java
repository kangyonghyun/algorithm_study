package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public boolean isAnagram(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        for (char c : word1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : word2.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }
}
