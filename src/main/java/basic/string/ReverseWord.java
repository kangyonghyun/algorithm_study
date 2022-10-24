package basic.string;

import java.util.Scanner;

public class ReverseWord {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }
        for (String reversedWord : getReverseWords(n, words)) {
            System.out.println(reversedWord);
        }
    }

    private static String[] getReverseWords(int n, String[] words) {
        String[] reversedWords = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder(words[i]);
            reversedWords[i] = builder.reverse().toString();
        }
        return reversedWords;
    }

}
