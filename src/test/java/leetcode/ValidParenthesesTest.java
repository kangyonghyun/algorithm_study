package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Stack;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ValidParenthesesTest {

    @ParameterizedTest
    @MethodSource("provideValueForIsValid")
    void valid(String input, boolean expected) {
        assertThat(isValid(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideValueForIsValid() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("]", false),
                Arguments.of("(])", false)
        );
    }

    public boolean isValid(String input) {
        Stack<Character> values = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                values.push(c);
            } else {
                if (values.isEmpty()) {
                    return false;
                }
                char pop = values.pop();
                if (pop == '(' && c == ')') {
                    continue;
                } else if (pop == '{' && c == '}') {
                    continue;
                } else if (pop == '[' && c == ']') {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return values.isEmpty();
    }

}