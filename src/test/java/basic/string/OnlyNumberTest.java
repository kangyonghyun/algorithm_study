package basic.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OnlyNumberTest {

    @Test
    void solution() {
        String text = "g0en2T0s8eSoft";
        assertThat(extractOnlyNumber1(text)).isEqualTo(208);
    }

    private int extractOnlyNumber(String text) {
        String number = "";
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                number += c;
            }
        }
        return Integer.parseInt(number);
    }

    private int extractOnlyNumber1(String text) {
        int number = 0;
        for (char c : text.toCharArray()) {
            if ('0' <= c && c <= '9') {
                number = number * 10 + Character.getNumericValue(c);
            }
        }
        return number;
    }

}