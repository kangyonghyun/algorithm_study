package basic.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BubbleSortTest {

    @Test
    void solution() {
        int n = 6;
        int[] arr = {13, 5, 11, 7, 23, 15};
        assertThat(sort(n, arr)).containsExactly(5, 7, 11, 13, 15, 23);
    }

    public int[] sort(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        return arr;
    }

}