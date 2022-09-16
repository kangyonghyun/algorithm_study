package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        List<Character> list = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (list.contains(c)) {
                list.subList(0, list.indexOf(c) + 1).clear();
            }
            list.add(c);
            maxLength = Math.max(maxLength, list.size());
        }
        return maxLength;
    }
}
