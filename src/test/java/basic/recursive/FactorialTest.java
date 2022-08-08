package basic.recursive;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FactorialTest {

    @Test
    void factorial() {
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

}