package basic.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SelectionSortTest {

    @Test
    void solution() {
        int n = 6;
        int[] arr = {13, 5, 11, 7, 23, 15};

        assertThat(sort(arr)).containsExactly(5, 7, 11, 13, 15, 23);
        assertThat(sortIndex(n, arr)).containsExactly(5, 7, 11, 13, 15, 23);
    }

    public int[] sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * Index 를 활용
     */
    public int[] sortIndex(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[idx] > arr[j]) {
                    idx = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }
}