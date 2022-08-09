package basic.recursive;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciTest {

    @Test
    void fibonacci() {
        int n = 10;
        assertThat(getFibonacci(n)).containsExactly(1, 1, 2, 3, 5, 8, 13, 21, 34, 55);
    }

    private List<Integer> getFibonacci(int n) {
        List<Integer> results = new ArrayList<>();
//        recursive1(n, results);
//        return results;
        for (int i = 1; i <= n; i++) {
            recursive2(i);
        }
        return results;
    }

    private int recursive2(int i) {
        List<Integer> results = new ArrayList<>();
        int result = 0;
        if (i == 1 || i == 2) {
            return 1;
        } else {
            result = recursive2(i - 2) + recursive2(i - 1);
            results.add(result);
            return result;
        }
    }

    private void recursive1(int n, List<Integer> results) {
        for (int i = 0; i < n; i++) {
            if (i == 0 || i == 1) {
                results.add(1);
            } else {
                results.add(results.get(i - 2) + results.get(i - 1));
            }
        }
    }

}