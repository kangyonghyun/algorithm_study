package leetcode;

import java.util.Stack;

public class ValidParentheses {
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
