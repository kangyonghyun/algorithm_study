package basic.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class StringBracketTest {

    @ParameterizedTest
    @CsvSource({"(A(BC)D)EF(G(H)(IJ)K)LM(N), EFLM"})
    void bracket(String value, String expected) {
        assertThat(printString(value)).isEqualTo(expected);
    }

    private String printString(String value) {
        String result = "";
        Stack<Character> strings = new Stack<>();
        for (char s : value.toCharArray()) {
            if (s == '(') {
                strings.push(s);
            } else if (s == ')'){
                if (!strings.isEmpty()) {
                    strings.pop();
                }
            } else {
                if (strings.isEmpty()) {
                    result += s;
                }
            }
        }
        return result;
    }

}