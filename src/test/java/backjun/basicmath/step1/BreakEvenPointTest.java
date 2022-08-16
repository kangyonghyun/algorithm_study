package backjun.basicmath.step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class BreakEvenPointTest {

    @ParameterizedTest
    @CsvSource({"1000,70,170,11", "3,2,1,-1", "2100000000,9,10,2100000001"})
    void break_even_point(long A, long B, long C, long expected) {
        assertThat(getBreakEvenPoint(A, B, C)).isEqualTo(expected);
    }

    private long getBreakEvenPoint(long A, long B, long C) {
        long temp = C - B;
        if (temp > 0) {
            return A / temp + 1;
        }
        return -1;
    }

}