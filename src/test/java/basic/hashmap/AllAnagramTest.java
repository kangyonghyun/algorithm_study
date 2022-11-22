package basic.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class AllAnagramTest {

    /**
     * 타겟 문자열에 대해 특정 단어가 아나그램인 부분집합 개수 구하기
     * 주어진 단어에 대해 타겟 문자열의 수 - 1 만큼 맵에 차례대로 먼저 넣는다.
     * 타겟 문자 넣는 맵을 만든다.
     * for 문을 돌린다. (특정 단어의 문자수만큼 )
     * 마지막 문자를 넣어주고 타켓 문자를 넣어준 맵과 일치하는지 비교
     * 일치하면 부분집합의 개수 카운트+
     * 맨 앞열 문자 -카운트 만약, 0이면 삭제
     * 슬라이딩 윈도우 방식, 맵끼리 일치하는지 비교
     */
    @ParameterizedTest
    @MethodSource("provideWordForIsAnagram")
    void allAnagram(String word1, String target, int expected) {
        assertThat(findCountOfAnagram(word1, target)).isEqualTo(expected);
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
    void equalsMap(String word1, String word2) {
        Map<Character, Integer> map1 = makeTargetAnaMap(word1);
        Map<Character, Integer> map2 = makeTargetAnaMap(word2);
        assertThat(map1).isEqualTo(map2);
    }

    @ParameterizedTest
    @CsvSource({"aa, aaa", "abc,bc"})
    void notEqualsMap(String word1, String word2) {
        Map<Character, Integer> map1 = makeTargetAnaMap(word1);
        Map<Character, Integer> map2 = makeTargetAnaMap(word2);
        assertThat(map1).isNotEqualTo(map2);
    }

    private int findCountOfAnagram(String word, String target) {
        Map<Character, Integer> slidingAnaMap = initSlidingAnaMap(word, target);
        int count = 0;
        int lt = 0;
        Map<Character, Integer> fullAnaMap = makeTargetAnaMap(target);
        for (int rt = target.length() - 1; rt < word.length(); rt++) {
            putRightCharacter(slidingAnaMap, word.charAt(rt));
            count = calCount(slidingAnaMap, count, fullAnaMap);
            removeLeftCharacter(slidingAnaMap, word.charAt(lt++));
        }
        return count;
    }

    private static int calCount(Map<Character, Integer> slidingAnaMap, int count, Map<Character, Integer> fullAnaMap) {
        if (slidingAnaMap.equals(fullAnaMap)) {
            count++;
        }
        return count;
    }

    private Map<Character, Integer> initSlidingAnaMap(String word, String target) {
        Map<Character, Integer> anaMap = new HashMap<>();
        for (int i = 0; i < target.length() - 1; i++) {
            char c =  word.charAt(i);
            anaMap.put(c, anaMap.getOrDefault(c, 0) + 1);
        }
        return anaMap;
    }

    private Map<Character, Integer> makeTargetAnaMap(String word) {
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
        anaMap.put(c, anaMap.get(c) - 1);
        if (anaMap.get(c) == 0) {
            anaMap.remove(c);
        }
    }

}