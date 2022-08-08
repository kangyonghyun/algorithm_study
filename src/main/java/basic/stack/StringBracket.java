package basic.stack;

import java.util.Scanner;
import java.util.Stack;

public class StringBracket {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBracket stringBracket = new StringBracket();
        System.out.println(stringBracket.printString(sc.next()));
    }

    private String printString(String value) {
        String result = "";
        Stack<Character> strings = new Stack<>();
        for (char s : value.toCharArray()) {
            if (s == '(') {
                strings.push(s);
            } else if (s == ')'){
                if (!strings.isEmpty()) {
                    strings.pop();
                }
            } else {
                if (strings.isEmpty()) {
                    result += s;
                }
            }
        }
        return result;
    }
}
