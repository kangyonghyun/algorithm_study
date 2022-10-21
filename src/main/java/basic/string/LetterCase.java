package basic.string;

import java.util.Scanner;

public class LetterCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(transformText(sc.next()));
    }

    private static String transformText(String text) {
        String result = "";
        for (char c : text.toCharArray()) {
            if (Character.isLowerCase(c)) {
                result += Character.toUpperCase(c);
            } else {
                result += Character.toLowerCase(c);
            }
        }
        return result;
    }
}
