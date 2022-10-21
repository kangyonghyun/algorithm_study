package basic.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LetterCaseTest {

    @Test
    void solution() {
        String text = "StuDY";
        assertThat(transformText1(text)).isEqualTo("sTUdy");
    }

    private String transformText(String text) {
        String result = "";
        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result += Character.toUpperCase(c);
            } else {
                result += Character.toLowerCase(c);
            }
        }
        return result;
    }

    private String transformText1(String text) {
        String result = "";
        for (char c : text.toCharArray()) {
            if ('a' <= c && c <= 'z') {
                result += Character.toUpperCase(c);
            } else {
                result += Character.toLowerCase(c);
            }
        }
        return result;
    }


}