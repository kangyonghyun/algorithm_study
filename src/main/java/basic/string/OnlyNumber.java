package basic.string;

import java.util.Scanner;

public class OnlyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        System.out.println(extractOnlyNumber(text));
    }

    private static int extractOnlyNumber(String text) {
        String number = "";
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                number += c;
            }
        }
        return Integer.parseInt(number);
    }
}
