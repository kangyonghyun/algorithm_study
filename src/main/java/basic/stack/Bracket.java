package basic.stack;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bracket bracket = new Bracket();
        System.out.println( bracket.isProperBracket2(sc.next()));
    }

    private String isProperBracket1(String bracket) {
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

    private String isProperBracket2(String bracket) {
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
