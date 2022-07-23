package backjun.basicmath.step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SnailTest {

    @ParameterizedTest
    @MethodSource("provideValue")
    void high(int up, int down, int top, int expectedDays) {
        assertThat(findDaysToTop(up, down, top)).isEqualTo(expectedDays);
        assertThat(findDaysToTop2(up, down, top)).isEqualTo(expectedDays);
    }

    private static Stream<Arguments> provideValue() {
        return Stream.of(
                Arguments.of(2, 1, 5, 4),
                Arguments.of(100, 99, 1000000000, 999999901),
                Arguments.of(4, 1, 7, 2),
                Arguments.of(10, 5, 30, 5),
                Arguments.of(4, 2, 7, 3)
        );
    }

    private int findDaysToTop(int up, int down, int top) {
        int go = up - down;
        if ((top - down) % go == 0) {
            return (top - down) / go;
        } else {
            return (top - down) / go + 1;
        }
    }

    private int findDaysToTop2(int up, int down, int top) {
        int go = up - down;
        int distance = up;
        int days = 1;
        while (distance < top) {
            distance += go;
            days++;
        }
        return days;
    }

}