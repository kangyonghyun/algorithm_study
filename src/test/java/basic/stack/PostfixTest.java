package basic.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixTest {

    /**
     * 후위식 연산 결과 출력
     * 후위식 연산 : 피연산자가 먼저 쓰이고, 그 뒤로 연산자가 나옴
     * Stack 에 숫자이면 넣고 숫자가 아닐 경우(연산자) 2개의 숫자를 뽑는다.
     * 먼저 뽑힌는 숫자는 right, 그다음 숫자는 left
     * 연산자(+,-,*,/) 에 따라 연산을 진행하고 Stack 에 넣는다.
     * 마지막 Stack 에 남아있는 숫자가 후위연산 결과가 됨
     * -, / 연산 일 경우, left, right 가 중요함
     */

    @Test
    void postfix() {
        String expression = "352+*9-";
        assertThat(CalculatePostfix(expression)).isEqualTo(12);
    }

    private int CalculatePostfix(String expression) {
        Stack<Integer> repository = new Stack<>();
        for (char c : expression.toCharArray()) {
            int left = 0;
            int right = 0;
            if (Character.isDigit(c)) {
                repository.push(c - '0');
            } else {
                if (!repository.isEmpty()) {
                    right = repository.pop();
                    left = repository.pop();
                }
            }
            calculate(repository, c, left, right);
        }
        return repository.pop();
    }

    private static void calculate(Stack<Integer> repository, char c, int left, int right) {
        if (c == '+') {
            repository.push(left + right);
        }
        if (c == '-') {
            repository.push(left - right);
        }
        if (c == '*') {
            repository.push(left * right);
        }
        if (c == '/') {
            repository.push(left - right);
        }
    }

}