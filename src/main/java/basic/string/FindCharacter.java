package basic.string;

import java.util.Scanner;

public class FindCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.next();
        char c = sc.next().charAt(0);
        System.out.println(getNumberOfMatch(text, c));
    }

    private static int getNumberOfMatch(String text, char target) {
        int count = 0;
        String textToLower = text.toLowerCase();
        char targetToLower = Character.toLowerCase(target);
        for (char c : textToLower.toCharArray()) {
            if (c == targetToLower) {
                count++;
            }
        }
        return count;
    }
}
