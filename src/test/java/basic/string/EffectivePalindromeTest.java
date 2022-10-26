package basic.string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class EffectivePalindromeTest {

    @Test
    void solution() {
        String text = "found7, time: study; Yduts; emit, 7Dnuof";
        assertThat(isPalindrome2(text)).isEqualTo("YES");
    }

    private String isPalindrome(String text) {
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

    private String isPalindrome1(String text) {
        String t = text.toLowerCase();
        List<Character> chars = new ArrayList<>();
        for (char c : t.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                chars.add(c);
            }
        }
        String temp = "";
        for (Character aChar : chars) {
            temp += aChar;
        }
        StringBuilder builder = new StringBuilder(temp);
        if (temp.equals(builder.reverse().toString())) {
            return "YES";
        }
        return "NO";
    }

    private String isPalindrome2(String text) {
        text = text.toLowerCase().replaceAll("[^A-Z]", "");
        if (text.equals(new StringBuilder(text).reverse().toString())) {
            return "YES";
        }
        return "NO";
    }

}