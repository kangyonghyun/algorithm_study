package basic.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicateCheckTest {

    @Test
    void solution() {
        int n = 8;
        int[] arr = {20, 25, 52, 30, 39, 33, 43, 33};
        assertThat(checkDuplicate(n, arr)).isEqualTo("D");
        assertThat(checkDuplicateForMap(n, arr)).isEqualTo("D");
    }

    private String checkDuplicate(int n, int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return "D";
            }
        }
        return "U";
    }

    private String checkDuplicateForMap(int n, int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.getOrDefault(map.get(a), 1) + 1);
            } else {
                map.put(a, 1);
            }
        }
        for (int value : map.values()) {
            if (value >= 2) {
                return "D";
            }
        }
        return "U";
    }

}
