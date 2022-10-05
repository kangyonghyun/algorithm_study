package basic.sorting;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuickSortTest {

    /**
     * 로무토 분할법 (가장자리) , 호어 분할법 (왼오,오왼 번갈아진행)
     * 로무트 분할법 사용
     */
    @Test
    void solution() {
        int n = 6;
        int[] arr = {2, 7, 5, 1, 3, 8, 7, 4, 9, 6};
        assertThat(sort(arr)).containsExactly(1, 2, 3, 4, 5, 6, 7, 7, 8, 9);
    }

    private int[] sort(int[] arr) {
        quickSortRecursive(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSortRecursive(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition(arr, left, right);

        quickSortRecursive(arr, left, pivotPos - 1);
        quickSortRecursive(arr, pivotPos + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                ++i;
            }
        }
        int pivotPos = i;
        swap(arr, pivotPos, right);
        return pivotPos;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}