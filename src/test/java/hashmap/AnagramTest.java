package hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AnagramTest {

    // 알파벳 이 똑같다
    // 알파뱃 갯수가 똑같다

    @ParameterizedTest
    @CsvSource({
            "AbaAeCe, baeeACA",
            "zyzzY, Yzzzy"})
    void anagram_true(String word1, String word2) {
        assertThat(solution(word1, word2)).isEqualTo("YES");
    }

    @ParameterizedTest
    @CsvSource({
            "abaCC, Caaab",
            "zzZyY, ZZzyy",
            "aaabb, aaabbB"})
    void anagram_false(String word1, String word2) {
        assertThat(solution(word1, word2)).isEqualTo("NO");
    }

    private String solution(String word1, String word2) {
        Map<Character, Integer> word1Map = new HashMap<>();
        for (char c : word1.toCharArray()) {
            word1Map.put(c, word1Map.getOrDefault(c, 0) + 1);
        }

        for (char c : word2.toCharArray()) {
            if (!word1Map.containsKey(c) || word1Map.get(c) == 0) {
                return "NO";
            }
            word1Map.put(c, word1Map.get(c) - 1);
        }
        return "YES";
    }


}