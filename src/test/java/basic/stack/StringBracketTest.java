package basic.stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class StringBracketTest {

    /**
     * 괄호와 괄호 안에 있는 문자를 제외한 문자 출력
     * 특정 문자가 여는 괄호가 나오면 stack 에 넣음
     * 특정 문자가 닫는 괄화가 나오면 stack 에서 뺴줌
     * 특정 문자가 그외 문자가 나오면 stack 이 비어있을 경우, 문자를 result 에 저장
     * stack 이 비어있지 않다면 괄호안에 있는 문자이기 때문에 비어있을 경우만 저장
     */

    @ParameterizedTest
    @CsvSource({"(A(BC)D)EF(G(H)(IJ)K)LM(N), EFLM"})
    void bracket(String value, String expected) {
        assertThat(printString(value)).isEqualTo(expected);
    }

    private String printString(String value) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        for (char c : value.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')'){
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                if (stack.isEmpty()) {
                    result += c;
                }
            }
        }
        return result;
    }

}