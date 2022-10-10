package basic.twopointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TwoArrayMergeTest {

    @Test
    void solution() {
        int n = 3;
        int[] arr = {1, 3, 5};
        int m = 5;
        int[] arr1 = {2, 3, 6, 7, 9};

        assertThat(mergeSortArray(n, arr, m, arr1)).containsExactly(1, 2, 3, 3, 5, 6, 7, 9);
    }

    private List<Integer> mergeSortArray1(int n, int[] arr, int m, int[] arr1) {
        List<Integer> results = new ArrayList<>();
        for (int i : arr) {
            results.add(i);
        }
        for (int i : arr1) {
            results.add(i);
        }
        Collections.sort(results);
        return results;
    }

    private List<Integer> mergeSortArray(int n, int[] arr, int m, int[] arr1) {
        List<Integer> results = new ArrayList<>();

        int p1 = 0;
        int p2 = 0;

        while (p1 < n && p2 < m) {
            if (arr[p1] < arr1[p2]) {
                results.add(arr[p1++]);
            } else {
                results.add(arr1[p2++]);
            }
        }
        while (p1 < n) {
            results.add(arr[p1++]);
        }
        while (p2 < m) {
            results.add(arr1[p2++]);
        }
        return results;
    }


}