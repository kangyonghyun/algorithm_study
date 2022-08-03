package stack;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

class IronStickTest {

    @Test
    void cut() {
        String bracket = "()(((()())(())()))(())";
        Assertions.assertThat(getTotalStick(bracket)).isEqualTo(17);
    }

    private int getTotalStick(String bracket) {
        Stack<Character> brackets = new Stack<>();
        int count = 0;
        for (char c : bracket.toCharArray()) {
            if (c == '(') {
                brackets.push(c);
            } else {
                brackets.pop();
                if (brackets.peek() == '(') {
                    count += brackets.size();
                } else {
                    count++;
                }
            }
        }
        return count;
    }

}