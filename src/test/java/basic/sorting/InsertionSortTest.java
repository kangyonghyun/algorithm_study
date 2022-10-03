package basic.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void solution() {
        int n = 6;
        int[] arr = {11, 7, 5, 6, 10, 9};

        assertThat(sort(n, arr)).containsExactly(5, 6, 7, 9, 10, 11);
    }

    private int[] sort(int n, int[] arr) {
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
        }
        return arr;
    }

}