package basic.string;

import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        System.out.println(isPalindrome(word));
    }

    private static String isPalindrome(String word) {
        String w = word.toLowerCase();
        char[] chars = w.toCharArray();

        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            if (chars[left] != chars[right]) {
                return "NO";
            }
            left++;
            right--;
        }
        return "YES";
    }
}
