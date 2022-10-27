package basic.string;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ShortestDistanceCharTest {

    @Test
    void solution() {
        String word = "teachermode";
        char target = 'e';
        assertThat(getShortestDistance1(word, target)).containsExactly(1, 0, 1, 2, 1, 0, 1, 2, 2, 1, 0);
    }

    private int[] getShortestDistance(String word, char target) {
        int[] distance = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == target) {
                for (int j = 0; j < chars.length; j++) {
                    distance[j] = Math.min(distance[j], Math.abs(j - i));
                }
            }
        }
        return distance;
    }

    private int[] getShortestDistance1(String word, char target) {
        int[] distance = new int[word.length()];
        int dist = 1000;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == target) {
                dist = 0;
            } else {
                dist++;
                distance[i] = dist;
            }
        }
        for (int i = word.length() - 1; i >= 0; i--) {
            if (word.charAt(i) == target) {
                dist = 0;
            } else {
                dist++;
                distance[i] = Math.min(distance[i], dist);
            }
        }
        return distance;
    }

}