package basic.string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseWordTest {

    @Test
    void solution() {
        int n = 3;
        String[] words = {"good", "Time", "Big"};
        assertThat(getReverseWords2(n, words)).contains("doog", "emiT", "giB");
    }

    private String[] getReverseWords(int n, String[] words) {
        String[] reversedWords = new String[n];
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder(words[i]);
            reversedWords[i] = builder.reverse().toString();
        }
        return reversedWords;
    }

    private String[] getReverseWords1(int n, String[] words) {
        String[] reversedWords = new String[n];
        for (int i = 0; i < n; i++) {
            String reversed = "";
            char[] temp = words[i].toCharArray();
            for (int j = temp.length - 1; j >= 0; j--) {
                reversed += temp[j];
            }
            reversedWords[i] = reversed;
        }
        return reversedWords;
    }

    private List<String> getReverseWords2(int n, String[] words) {
        List<String> reversedWords = new ArrayList<>();
        for (String word : words) {
            char[] chars = word.toCharArray();
            int lt = 0;
            int rt = chars.length - 1;
            while (lt < rt) {
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                lt++;
                rt--;
            }
            reversedWords.add(String.valueOf(chars));
        }
        return reversedWords;
    }

}