package basic.string;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindCharacterTest {

    @Test
    void solution() {
        String string = "ComputercoolerCc";
        char target = 'c';
        assertThat(getNumberOfMatch(string, target)).isEqualTo(4);
    }

    private int getNumberOfMatch(String text, char target) {
        int count = 0;
        String textToLower = text.toLowerCase();
        char targetToLower = Character.toLowerCase(target);
        for (char c : textToLower.toCharArray()) {
            if (c == targetToLower) {
                count++;
            }
        }
        return count;
    }

}