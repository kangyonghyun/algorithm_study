package basic.array;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculationTest {

    @Test
    void solution() {
        int n = 10;
        int[] results = {1, 0, 1, 1, 1, 0, 0, 1, 1, 0};
        assertThat(calculateScore(n, results)).isEqualTo(10);
    }

    private int calculateScore(int n, int[] results) {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (results[i] == 1) {
                count++;
                sum += count;
            } else {
                count = 0;
            }
        }
        return sum;
    }

    private int calculateScore1(int n, int[] results) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (results[i] == 1) {
                sum += 1;
                int ssum = 0;
                for (int j = i + 1; j < n; j++) {
                    if (results[j] == 1) {
                        sum += 1;
                        ssum += 1;
                        i = j;
                    } else {
                        i = j;
                        break;
                    }
                    sum += ssum;
                }
            }
        }
        return sum;
    }

    private int calculateScore2(int n, int[] results) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (results[i] == 1) {
                sum += 1;
                int idx = i + 1;
                int ssum = 0;
                while (results[idx] == 1) {
                    sum += 1;
                    ssum += 1;
                    sum += ssum;
                    idx++;
                    i = idx;
                }
            }
        }
        return sum;
    }

}