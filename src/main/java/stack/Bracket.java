package stack;

import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Bracket bracket = new Bracket();
        System.out.println( bracket.isProperBracket(sc.next()));
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
