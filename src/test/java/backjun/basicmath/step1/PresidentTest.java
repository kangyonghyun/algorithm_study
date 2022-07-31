package backjun.basicmath.step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PresidentTest {

    @ParameterizedTest
    @CsvSource({"1, 3, 6", "2, 3, 10"})
    void president(int floor, int n, int expected) {
        assertThat(calculateNumberOfPeople(floor, n)).isEqualTo(expected);
    }

    private int calculateNumberOfPeople(int floor, int n) {
        int[][] apart = new int[floor + 1][n];
        for (int i = 0; i < n; i++) {
            apart[0][i] = i + 1;
        }
        for (int i = 1; i <= floor; i++) {
            apart[i][0] = 1;
            for (int j = 1; j < n; j++) {
                apart[i][j] = apart[i - 1][j] + apart[i][j - 1];
            }
        }
        return apart[floor][n - 1];
    }

}