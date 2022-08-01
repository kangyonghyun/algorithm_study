package stack;

import java.util.Scanner;
import java.util.Stack;

public class Postfix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Postfix postfix = new Postfix();
        System.out.println(postfix.CalculatePostfix(sc.next()));
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
        return repository.pop();
    }

}
