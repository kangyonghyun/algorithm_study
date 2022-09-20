package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MaximumSubArrayTest {

    @Test
    void solution1() {
        assertThat(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})).isEqualTo(6);
        assertThat(maxSubArray(new int[]{1})).isEqualTo(1);
        assertThat(maxSubArray(new int[]{5, 4, -1, 7, 8})).isEqualTo(23);
        assertThat(maxSubArray(new int[]{-2, 1})).isEqualTo(1);
        assertThat(maxSubArray(new int[]{-2, -1})).isEqualTo(-1);
        assertThat(maxSubArray(new int[]{-1, -2})).isEqualTo(-1);
    }

    /**
     * DP - 카데인알고리즘
     * 3ms, 26%
     */
    private int maxSubArray(int nums[]) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }

    /**
     * 이중 for문 사용
     * Timeout
     */
    private int maxSubArray1(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i];
            max = Math.max(max, sum);
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}