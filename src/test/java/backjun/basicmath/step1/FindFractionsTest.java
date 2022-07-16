package backjun.basicmath.step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class FindFractionsTest {

    @ParameterizedTest
    @MethodSource("provideXthForFindFraction")
    void fraction(int x, String expected) {
        assertThat(solution(x)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideXthForFindFraction() {
        return Stream.of(
                Arguments.of(1, "1/1"),
                Arguments.of(2, "1/2"),
                Arguments.of(3, "2/1"),
                Arguments.of(4, "3/1"),
                Arguments.of(5, "2/2"),
                Arguments.of(6, "1/3"),
                Arguments.of(7, "1/4"),
                Arguments.of(8, "2/3"),
                Arguments.of(9, "3/2"),
                Arguments.of(14, "2/4")
        );
    }

    private String solution(int num) {
        int result = 0;
        int up = 0;
        int down = 0;
        String txt = "";

        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
               if (i % 2 != 0){
                   //홀수
                   down = j + 1;
                   up = i - j;
               } else {
                   //짝수
                   up = j + 1;
                   down = i - j;
               }
               result++;
               if (result == num) {
                   return up + "/" + down;
               }
            }
        }
        return txt;
    }

}