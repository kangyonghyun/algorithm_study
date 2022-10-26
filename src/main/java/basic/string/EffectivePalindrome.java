package basic.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EffectivePalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println(isPalindrome(text));
    }

    private static String isPalindrome(String text) {
        String t = text.toLowerCase();
        List<Character> chars = new ArrayList<>();
        for (char c : t.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                chars.add(c);
            }
        }
        for (int i = 0; i < chars.size() / 2; i++) {
            if (chars.get(i) != chars.get(chars.size() - 1 - i)) {
                return "NO";
            }
        }
        return "YES";
    }

}
