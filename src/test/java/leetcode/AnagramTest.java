package leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Anagram
 * 1. HashMap 이용
 * 2. 1번이 2번보다 빠름
 */
class AnagramTest {
    @Test
    void ana() {
        assertThat(isAnagram1("anagram", "nagaram")).isTrue();
        assertThat(isAnagram1("rat", "car")).isFalse();
        assertThat(isAnagram1("ab", "a")).isFalse();
        assertThat(isAnagram1("aa", "a")).isFalse();
    }

    public boolean isAnagram1(String word1, String word2) {
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

    public boolean isAnagram2(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();

        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();

        for (int i = 0; i < word1.length(); i++) {
            char c = arr1[i];
            char d = arr2[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
            map.put(d, map.getOrDefault(d, 0) - 1);
        }
        for (int value : map.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }


}