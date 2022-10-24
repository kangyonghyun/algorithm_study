package basic.string;

import java.util.Scanner;

public class ReverseSpecificWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        System.out.println(getReversedSpecificWord(word));
    }

    private static String getReversedSpecificWord(String word) {
        int lt = 0;
        int rt = word.length() - 1;
        char[] chars = word.toCharArray();
        while (lt < rt) {
            if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt--;
            } else {
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(chars);
    }
}
