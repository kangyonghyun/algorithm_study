package basic.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CompressedStringTest {

    @Test
    void solution() {
        assertThat(compressString2("KKHSSSSSSSE")).isEqualTo("K2HS7E");
        assertThat(compressString2("KSTTTSEEKFKKKDJJGG")).isEqualTo("KST3SE2KFK3DJ2G2");
    }

    private String compressString(String word) {
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

    private String compressString2(String word) {
        String compressed = "";
        word = word + " ";
        String temp = "";
        int count = 1;
        for (char c : word.toCharArray()) {
            if (temp.contains(c + "")) {
                count++;
            } else {
                if (count > 1) {
                    compressed += count;
                    count = 1;
                }
                if (c != ' ') {
                    compressed += c;
                }
                temp = c + "";
            }
        }
        return compressed;
    }

    private String compressString1(String word) {
        String compressed = "";
        word = word + " ";
        int count = 1;
        for (int i = 0; i < word.length() - 1; i++) {
            if (word.charAt(i) == word.charAt(i + 1)) {
                count++;
            } else {
                compressed += word.charAt(i);
                if (count > 1) {
                    compressed += count;
                    count = 1;
                }
            }
        }
        return compressed;
    }

}