package hashmap;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

class PresidentTest {

    @Test
    void president() {
        int numberOfStudent = 15;
        String votes = "BACBACCACCBDEDE";
        assertThat(solution(votes)).isEqualTo('C');
    }

    private char solution(String votes) {
        HashMap<Character, Integer> resultMap = new HashMap<>();
        for (char vote : votes.toCharArray()) {
            resultMap.put(vote, resultMap.getOrDefault(vote, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        char result = '\u0000';
        for (char key : resultMap.keySet()) {
            if (resultMap.get(key) >= max) {
                max = resultMap.get(key);
                result = key;
            }
        }
        return result;
    }

}