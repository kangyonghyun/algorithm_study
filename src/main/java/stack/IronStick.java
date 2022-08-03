package stack;

import java.util.Scanner;
import java.util.Stack;

public class IronStick {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IronStick ironStick = new IronStick();
        System.out.println(ironStick.getCountOfStick(sc.next()));
    }

    private int getCountOfStick(String input) {
        Stack<Character> bracket = new Stack<>();
        int countOfStick = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                bracket.push('(');
            } else {
                bracket.pop();
                if (input.charAt(i - 1) == '(') {
                    countOfStick += bracket.size();
                } else {
                    countOfStick++;
                }
            }
        }
        return countOfStick;
    }

}
