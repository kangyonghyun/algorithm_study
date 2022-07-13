package hashmap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class AllAnagramTest {

    @ParameterizedTest
    @MethodSource("provideWordForIsAnagram")
    void allAnagram(String word1, String word2, int expected) {
        assertThat(findCountOfAnagram(word1, word2)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideWordForIsAnagram() {
        return Stream.of(
                Arguments.of("bacaAacba", "abc", 3),
                Arguments.of("bacaAacbaa", "abca", 3),
                Arguments.of("YYZZZ", "Y", 2),
                Arguments.of("YYZZZ", "y", 0),
                Arguments.of("YYZZZ", "x", 0),
                Arguments.of("YYZZZ", "ZY", 1)
        );
    }
    @ParameterizedTest
    @CsvSource({"aa, aa", "abc, bac"})
    void equalsMap(String word1,String word2) {
        Map<Character, Integer> map1 = makeFullAnaMap(word1);
        Map<Character, Integer> map2 = makeFullAnaMap(word2);
        assertThat(map1).isEqualTo(map2);
    }

    @ParameterizedTest
    @CsvSource({"aa, aaa", "abc,bc"})
    void notEqualsMap(String word1, String word2) {
        Map<Character, Integer> map1 = makeFullAnaMap(word1);
        Map<Character, Integer> map2 = makeFullAnaMap(word2);
        assertThat(map1).isNotEqualTo(map2);
    }

    private int findCountOfAnagram(String word1, String word2) {
        Map<Character, Integer> fullAnaMap = makeFullAnaMap(word2);
        Map<Character, Integer> anaMap = new HashMap<>();
        char[] chars = word1.toCharArray();
        for (int i = 0; i < word2.length() - 1; i++) {
            char c =  word1.toCharArray()[i];
            anaMap.put(c, anaMap.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        int lt = 0;
        for (int rt = word2.length() - 1; rt < word1.length(); rt++) {
            putRightCharacter(anaMap, chars[rt]);
            if (anaMap.equals(fullAnaMap)) {
                count++;
            }
            removeLeftCharacter(anaMap, chars[lt++]);
        }
        return count;
    }

    private Map<Character, Integer> makeFullAnaMap(String word) {
        Map<Character, Integer> anaMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            anaMap.put(c, anaMap.getOrDefault(c, 0) + 1);
        }
        return anaMap;
    }

    private void putRightCharacter(Map<Character, Integer> anaMap, char c) {
        anaMap.put(c, anaMap.getOrDefault(c, 0) + 1);
    }

    private void removeLeftCharacter(Map<Character, Integer> anaMap, char c) {
        if (anaMap.get(c) != 0) {
            anaMap.put(c, anaMap.get(c) - 1);
        }
        if (anaMap.get(c) == 0) {
            anaMap.remove(c);
        }
    }

}