package basic.hashmap;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PresidentTest {

    /**
     * HashMap 이용 문제
     * key : 학급 회장 기호 / value : 몇번 불렸는지 횟수 저장
     * map 에서 가장 많은 횟수가 나온 학급 회장 기호 출력 (가장 높은 value 값은 어떤 키 ?)
     */

    @ParameterizedTest
    @MethodSource("provideStringsForIsCharacter")
    void president(String votes, char expected) {
        assertThat(solution(votes)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideStringsForIsCharacter() {
        return Stream.of(
                Arguments.of("BACBACCACCBDEDE", 'C'),
                Arguments.of("CCCAAABBABDEQAD", 'A'),
                Arguments.of("YYZZZ", 'Z')
        );
    }

    private char solution(String votes) {
        HashMap<Character, Integer> resultMap = new HashMap<>();
        for (char vote : votes.toCharArray()) {
            resultMap.put(vote, resultMap.getOrDefault(vote, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        char result = '\u0000';
        for (char key : resultMap.keySet()) {
            int count = resultMap.get(key);
            if (count >= max) {
                max = count;
                result = key;
            }
        }
        return result;
    }

}