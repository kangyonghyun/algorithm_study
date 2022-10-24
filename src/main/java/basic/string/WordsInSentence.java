package basic.string;

import java.util.Scanner;

public class WordsInSentence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        System.out.println(getLongestWord(sentence));
    }

    private static String getLongestWord(String sentence) {
        String longestWord = "";
        String[] words = sentence.split(" ");
        for (String word : words) {
            if (longestWord.length() < word.length()) {
                longestWord = word;
            }
        }
        return longestWord;
    }
}
