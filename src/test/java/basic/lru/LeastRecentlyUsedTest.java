package basic.lru;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LeastRecentlyUsedTest {

    @Test
    void solution() {
        int s = 5;
        int n = 9;
        int[] input = {1, 2, 3, 2, 6, 2, 3, 5, 7};

        assertThat(getCacheMemory(s, input)).containsExactly(7, 5, 3, 2, 6);
    }

    private int[] getCacheMemory(int s, int[] arr) {
        int[] cache = new int[s];

        for (int a : arr) {
            int pos = -1;
            for (int i = 0; i < s; i++) {
                if (arr[i] == a) {
                    pos = i;
                }
            }
            if (pos == -1) {
                for (int i = s - 1; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            } else {
                for (int i = pos; i > 0; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = a;
        }
        return cache;
    }

}