package backjun.basicmath.step1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class BigNumberSumTest {

    @Test
    void sumTest() {
        String A = "9223372036854775807";
        String B = "9223372036854775808";

        Assertions.assertThat(sum(A, B)).isEqualTo("18446744073709551615");
    }

    private String sum(String a, String b) {
        BigDecimal num1 = new BigDecimal(a);
        BigDecimal num2 = new BigDecimal(b);
        return num1.add(num2).toString();
    }

}