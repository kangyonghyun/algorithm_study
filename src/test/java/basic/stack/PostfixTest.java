package basic.stack;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class PostfixTest {

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
        return repository.pop();
    }

}