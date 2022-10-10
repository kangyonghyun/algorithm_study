package basic.twopointers;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CommonElementsTest {

    @Test
    void solution() {
        int n = 5;
        int[] arr1 = {1, 3, 9, 5, 2};
        int m = 5;
        int[] arr2 = {3, 2, 5, 7, 8};
        assertThat(getSortCommonElements(n, arr1, m, arr2)).containsExactly(2, 3, 5);
    }

    private List<Integer> getSortCommonElements(int n, int[] arr1, int m, int[] arr2) {
        List<Integer> elements = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        while (p1 < n && p2 < m) {
            if (arr1[p1] == arr2[p2]) {
                elements.add(arr1[p1]);
                p2++;
            } else if(arr1[p1] < arr2[p2]) {
                p1++;
            } else {
                p2++;
            }
        }

        return elements;
    }

}