package basic.string;

import java.util.Scanner;

public class CompressedString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        System.out.println(compressString(word));
    }

    private static String compressString(String word) {
        String compressed = word.charAt(0) + "";
        String temp = word.charAt(0) + "";
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (temp.contains(word.charAt(i) + "")) {
                count++;
            } else {
                if (count > 1) {
                    compressed += count;
                }
                compressed += word.charAt(i);
                temp = word.charAt(i) + "";
                count = 1;
            }
            if (count > 1 && i == word.length() - 1) {
                compressed += count;
            }
        }
        return compressed;
    }
}
