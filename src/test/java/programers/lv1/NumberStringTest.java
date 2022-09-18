package programers.lv1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class NumberStringTest {

    @Test
    void test() {
        assertThat(solution("one4seveneight")).isEqualTo(1478);
        assertThat(solution("1478")).isEqualTo(1478);
    }

    @Test
    void test1() {
        assertThat(solution1("one4seveneight")).isEqualTo(1478);
        assertThat(solution1("1478")).isEqualTo(1478);
    }

    private int solution(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine" ,"9");

        String result = "";
        String temp = "";

        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                temp += c;
                if (map.get(temp) != null) {
                    result += map.get(temp);
                    temp = "";
                }
            } else {
                result += c;
            }
        }
        return Integer.parseInt(result);
    }

    public int solution1(String s) {
        Map<String, String> map = new HashMap<>();
        map.put("zero", "0");
        map.put("one", "1");
        map.put("two", "2");
        map.put("three", "3");
        map.put("four", "4");
        map.put("five", "5");
        map.put("six", "6");
        map.put("seven", "7");
        map.put("eight", "8");
        map.put("nine" ,"9");

        for (String key : map.keySet()) {
            s = s.replace(key, map.get(key));
        }
        return Integer.parseInt(s);
    }

}