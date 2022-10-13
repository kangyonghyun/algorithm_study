package basic.recursive;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactorialTest {

    @Test
    void solution1() {
        int n = 5;
        assertThat(getFactorial(n)).isEqualTo(120);
    }

    private int getFactorial(int n) {
        int result = 0;
        if (n > 0) {
            result= getFactorial(n - 1) * n;
        } else {
            return 1;
        }
        return result;
    }

    @Test
    void solution2() {
        int n = 5;
        assertThat(solution2(n)).isEqualTo(120);
    }

    public int solution2(int n) {
        Recursive recursive = new Recursive();
        return recursive.getFactorialResult(n);
    }

    static class Recursive {
        public int getFactorialResult(int n) {
            if (n == 1) {
                return 1;
            }
            return n * getFactorialResult(n - 1);
        }
    }

}