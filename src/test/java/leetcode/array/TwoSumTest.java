package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {
    @Test
    void solution() {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        assertThat(calTwoSum(arr, target)).containsExactly(0, 1);

        int[] arr1 = {0, 4, 3, 0};

        assertThat(calTwoSum(arr1, 0)).containsExactly(0, 3);
    }

    private int[] calTwoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }

        return result;
    }
}