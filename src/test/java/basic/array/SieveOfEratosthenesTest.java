package basic.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SieveOfEratosthenesTest {

    @Test
    void solution() {
        int n = 20;
        assertThat(getCountOfPrimeNumberUntilTarget(n)).isEqualTo(8);
    }

    private int getCountOfPrimeNumberUntilTarget(int n) {
        int count = 0;
        int[] check = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            if (check[i] == 0) {
                count++;
                for (int j = i; j <= n; j = j + i) {
                    check[j] = 1;
                }
            }
        }
        return count;
    }

}