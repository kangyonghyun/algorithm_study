package leetcode.string;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubStringTest {

    @ParameterizedTest
    @CsvSource({"abcabcbb, 3", "bbbbb, 1", "pwwkew, 3", "aab, 2", "dvdf, 3", "ckilbkd, 5", "au, 2"})
    void solution(String input, int expected) {
        assertThat(lengthOfLongestSubstring(input)).isEqualTo(expected);
    }

    private int lengthOfLongestSubstring(String s) {
        return 0;
    }

    /**
     * List 사용
     * Runtime : 12 - 15ms, 40-45%
     */
    private int findMaxLengthWithoutRepeat(String s) {
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

    /**
     * Set 사용
     * Runtime : 15 - 18ms, 35-40%
     */
    private int findMaxLengthWithoutRepeat1(String s) {
        int maxLength = 0;
        Set<Character> set = new HashSet<>();
        int j = 0;
        for (char c : s.toCharArray()) {
            while (set.contains(c)) {
                set.remove(s.charAt(j));
                j++;
            }
            set.add(c);
            maxLength = Math.max(maxLength, set.size());
        }
        return maxLength;
    }
}