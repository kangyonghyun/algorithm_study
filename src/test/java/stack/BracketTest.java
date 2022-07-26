package stack;

import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class BracketTest {

    @Test
    void bracket() {
        assertThat(isProperBracket("(()(()))(()")).isEqualTo("NO");
    }

    private String isProperBracket(String bracket) {
        Stack<Character> brackets = new Stack<>();
        try {
            for (char c : bracket.toCharArray()) {
                if (c == '(') {
                    brackets.add(c);
                } else {
                    brackets.pop();
                }
            }
        } catch (EmptyStackException e) {
            return "NO";
        }
        if (brackets.size() == 0) {
            return "YES";
        }
        return "NO";
    }

}