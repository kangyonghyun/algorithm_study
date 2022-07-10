package hashmap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PresidentTest {

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
            if (resultMap.get(key) >= max) {
                max = resultMap.get(key);
                result = key;
            }
        }
        return result;
    }

}