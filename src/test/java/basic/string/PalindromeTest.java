package basic.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PalindromeTest {

    @Test
    void solution() {
        assertThat(isPalindrome1("gooG")).isEqualTo("YES");
        assertThat(isPalindrome1("goosG")).isEqualTo("NO");
        assertThat(isPalindrome1("Level")).isEqualTo("YES");
    }

    private String isPalindrome(String word) {
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

    private String isPalindrome1(String word) {
        String w = word.toLowerCase();
        int length = w.length();
        for (int i = 0; i < length / 2; i++) {
            if (w.charAt(i) != w.charAt(length - 1 - i)) {
                return "NO";
            }
        }
        return "YES";
    }

}