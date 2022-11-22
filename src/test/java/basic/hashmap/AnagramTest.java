package basic.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AnagramTest {

    /**
     * 주어진 두 단어가 Anagram 인지 확인하는 문제
     * 단어 한개를 map 에 저장
     * 다른 단어를 같은 map 에 저장하면서 동일한 문자의 갯수를 뺴준다.
     * 만약, 같은 단어가 없거나 (새로운 단어), 갯수가 0 이라면(많음) 아나그램이 아니다.
     */

    @ParameterizedTest
    @CsvSource({
            "AbaAeCe, baeeACA",
            "zyzzY, Yzzzy"})
    void anagram_true(String word1, String word2) {
        assertThat(isAnagram(word1, word2)).isEqualTo("YES");
    }

    @ParameterizedTest
    @CsvSource({
            "abaCC, Caaab",
            "zzZyY, ZZzyy",
            "aaabb, aaabbB"})
    void anagram_false(String word1, String word2) {
        assertThat(isAnagram(word1, word2)).isEqualTo("NO");
    }

    private String isAnagram(String word1, String word2) {
        Map<Character, Integer> wordMap = new HashMap<>();
        putWordToMap(word1, wordMap);
        return getResult(word2, wordMap);
    }

    private static String getResult(String word2, Map<Character, Integer> wordMap) {
        for (char c : word2.toCharArray()) {
            if (!wordMap.containsKey(c) || wordMap.get(c) == 0) {
                return "NO";
            }
            wordMap.put(c, wordMap.get(c) - 1);
        }
        return "YES";
    }

    private static void putWordToMap(String word1, Map<Character, Integer> wordMap) {
        for (char c : word1.toCharArray()) {
            wordMap.put(c, wordMap.getOrDefault(c, 0) + 1);
        }
    }


}