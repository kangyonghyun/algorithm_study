package basic.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class IronStickTest {

    @ParameterizedTest
    @CsvSource({"()(((()())(())()))(()), 17", "(((()(()()))(())()))(()()), 24"})
    void cut(String bracket, int expected) {
        assertThat(getCountOfStick(bracket)).isEqualTo(expected);
    }

    private int getCountOfStick(String input) {
        Stack<Character> bracket = new Stack<>();
        int countOfStick = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                bracket.push('(');
            } else {
                bracket.pop();
                if (input.charAt(i - 1) == '(') {
                    countOfStick += bracket.size();
                } else {
                    countOfStick++;
                }
            }
        }
        return countOfStick;
    }

}