package basic.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciForTest {

    @Test
    void solution() {
        int n = 10;
        assertThat(getPibonacciFor(n)).containsExactly(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
    }

    private int[] getPibonacciFor(int n) {
        int[] numbers = new int[n];
        numbers[0] = 1;
        numbers[1] = 1;
        for (int i = 2; i < n; i++) {
            numbers[i] = numbers[i - 2] + numbers[i - 1];
        }
        return numbers;
    }

    @Test
    void solution1() {
        int n = 10;
        assertThat(recursive(n)).containsExactly(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
    }

    private List<Integer> recursive(int n) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(getPibonacci(i));
        }
        return numbers;
    }

    private int getPibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return getPibonacci(n - 2) + getPibonacci(n - 1);
        }
    }

}