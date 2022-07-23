package backjun.basicmath.step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SugarDeliveryTest {

    @ParameterizedTest
    @CsvSource({
            "18, 4",
            "4, -1",
            "6, 2",
            "9, 3",
            "11, 3",
            "16, 4",
            "17, 5",
            "3, 1",
            "5, 1",
            "21, 5",
            "33, 7",
            "41, 9",
            "42, 10",
            "43, 9",
            "44, 10",
            "46, 10",
            "48, 10",
            "7, -1",
            "5000, 1000"
    })
    void sugar(int sugar, int expected) {
        assertThat(findNumberOfBags2(sugar)).isEqualTo(expected);
    }

    private int findNumberOfBags1(int sugar) {
        if (sugar % 5 == 0) {
            return sugar / 5;
        } else if (sugar / 5 > 1) {
            int n = sugar / 5;
            while ((sugar - 5*n) % 3 != 0) {
                n--;
            }
            return n + (sugar - 5*n) / 3;
        } else if (sugar % 3 == 0) {
            return sugar / 3;
        }
        return -1;
    }

    // (n/5) + (n%5)
    private int findNumberOfBags2(int sugar) {
        if (sugar == 4 || sugar == 7) {
            return -1;
        }
        if (sugar % 5 == 0) {
            return sugar / 5;
        }
        if (sugar % 5 == 1 || sugar % 5 == 3) {
            return sugar / 5 + 1;
        }
        if (sugar % 5 == 2 || sugar % 5 == 4) {
            return sugar / 5 + 2;
        }
        return -1;
    }

}