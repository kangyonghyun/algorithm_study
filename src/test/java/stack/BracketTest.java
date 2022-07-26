package stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class BracketTest {

    @ParameterizedTest
    @CsvSource(
            {"(()(()))((), NO",
            "(((())))(), YES",
            "(())))), NO",
            "(((()), NO"}
    )
    void bracket(String bracket, String expected) {
        assertThat(isProperBracket(bracket)).isEqualTo(expected);
    }

    private String isProperBracket(String bracket) {
        String result = "YES";
        Stack<Character> brackets = new Stack<>();
        for (char c : bracket.toCharArray()) {
            if (c == '(') {
                brackets.push(c);
            } else {
                if (brackets.isEmpty()) {
                    return "NO";
                }
                brackets.pop();
            }
        }
        if (!brackets.isEmpty()) {
            result = "NO";
        }
        return result;
    }

}