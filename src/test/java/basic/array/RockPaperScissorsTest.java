package basic.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RockPaperScissorsTest {

    @Test
    void solution() {
        int n = 5;
        int[] a = {2, 3, 3, 1, 3};
        int[] b = {1, 1, 2, 2, 3};
        assertThat(getWinners(n, a, b)).containsExactly('A', 'B', 'A', 'B', 'D');
    }

    private List<Character> getWinners(int n, int[] a, int[] b) {
        List<Character> results = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int play = a[i] - b[i];
            if (play == -2 || play == 1) {
                results.add('A');
            } else if (play == -1 || play == 2) {
                results.add('B');
            } else {
                results.add('D');
            }
        }
        return results;
    }

}