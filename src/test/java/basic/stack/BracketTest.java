package basic.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class BracketTest {

    /**
     *  올바른 괄호인지 확인하는 문제
     *  stack 의 특성을 이용 (후입선출)
     *  stack 에 여는 괄호는 넣음
     *  닫는 괄호 일 경우 stack 에 있는 여는 괄호를 뻄 (짝이 맞는 괄호)
     *  만약, stack 이 비어 있다면 -> 닫는 괄호가 부족
     *  모든 괄호를 살행하고, stack 이 비어있지 않다면 -> 여는 괄호가 부족 (올바른x)
     *  stack 이 비어있으면 올바른 괄호 이다.
     */

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
            return "NO";
        }
        return "YES";
    }

}