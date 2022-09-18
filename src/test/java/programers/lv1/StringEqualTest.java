package programers.lv1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StringEqualTest {

    @Test
    void solution1() {
        assertThat(isEqualLength("pPoooyY")).isTrue();
        assertThat(isEqualLength("Pyy")).isFalse();
        assertThat(isEqualLength("sksk")).isTrue();
        assertThat(isEqualLength("spPy")).isFalse();
    }

    @Test
    void solution() {
        assertThat(solution("pPoooyY")).isTrue();
        assertThat(solution("Pyy")).isFalse();
        assertThat(solution("sksk")).isTrue();
        assertThat(solution("spPy")).isFalse();
    }

    private boolean isEqualLength(String s) {
        Map<Character, Integer> map = new HashMap<>();
        s = s.toLowerCase();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int pCount = 0;
        int yCount = 0;
        if (map.containsKey('y')) {
            yCount = map.get('y');
        }
        if (map.containsKey('p')) {
            pCount = map.get('p');
        }
        return pCount == yCount;
    }

    public boolean solution(String s) {
        s = s.toUpperCase();
        return s.chars().filter(e -> 'P' == e).count() == s.chars().filter(e -> 'Y' == e).count();
    }

}