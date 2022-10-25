package basic.string;

import java.util.Scanner;

public class DuplicateCharRemoval {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        System.out.println(removeDuplicate(word));
    }

    private static String removeDuplicate(String word) {
        String result = "";
        String[] split = word.split("");
        for (String s : split) {
            if (!result.contains(s)) {
                result += s;
            }
        }
        return result;
    }
}
