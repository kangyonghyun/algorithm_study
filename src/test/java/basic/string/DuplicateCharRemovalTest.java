package basic.string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicateCharRemovalTest {

    @Test
    void solution() {
        String word = "ksekkset";
        assertThat(removeDuplicate2(word)).isEqualTo("kset");
    }

    private String removeDuplicate(String word) {
        List<Character> list = new ArrayList<>();
        String result = "";
        for (char c : word.toCharArray()) {
            if (!list.contains(c)) {
                list.add(c);
                result += c;
            }
        }
        return result;
    }

    private String removeDuplicate1(String word) {
        String result = "";
        String[] split = word.split("");
        for (String s : split) {
            if (!result.contains(s)) {
                result += s;
            }
        }
        return result;
    }

    private String removeDuplicate2(String word) {
        String result = "";
        for (int i = 0; i < word.length(); i++) {
            if (word.indexOf(word.charAt(i)) == i) {
                result += word.charAt(i);
            }
        }
        return result;
    }

}