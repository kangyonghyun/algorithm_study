package basic.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseSpecificWordTest {

    @Test
    void solution() {
        String word = "a#b!GE*T@S";
        assertThat(getReversedSpecificWord1(word)).isEqualTo("S#T!EG*b@a");
    }

    private String getReversedSpecificWord(String word) {
        int lt = 0;
        int rt = word.length() - 1;
        char[] chars = word.toCharArray();
        while (lt < rt) {
            if (Character.isAlphabetic(chars[lt])) {
                while (!Character.isAlphabetic(chars[rt])) {
                    rt--;
                }
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
            }
            lt++;
            rt--;
        }
        return String.valueOf(chars);
    }

    private String getReversedSpecificWord1(String word) {
        int lt = 0;
        int rt = word.length() - 1;
        char[] chars = word.toCharArray();
        while (lt < rt) {
            if (Character.isAlphabetic(chars[lt]) && Character.isAlphabetic(chars[rt])) {
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
            }
            lt++;
            rt--;
        }
        return String.valueOf(chars);
    }

    private String getReversedSpecificWord2(String word) {
        int lt = 0;
        int rt = word.length() - 1;
        char[] chars = word.toCharArray();
        while (lt < rt) {
            if (!Character.isAlphabetic(chars[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(chars[rt])) {
                rt--;
            } else {
                char temp = chars[lt];
                chars[lt] = chars[rt];
                chars[rt] = temp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(chars);
    }

}