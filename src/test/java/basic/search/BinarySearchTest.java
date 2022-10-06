package basic.search;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class BinarySearchTest {

    @Test
    void solution() {
        int size = 8;
        int target = 32;
        int[] arr = {23, 87, 65, 12, 57, 32, 99, 81};
        assertThat(searchPosition(size, target, arr)).isEqualTo(3);
    }

    private int searchPosition(int size, int target, int[] arr) {
        Arrays.sort(arr);
        int position = 0;

        int right = size - 1;
        int left = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                position = mid + 1;
                break;
            }
            if (target < arr[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return position;
    }
}