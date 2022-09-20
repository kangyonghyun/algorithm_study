package leetcode.array;

public class MaximumSubArray {
    private int maxSubArray(int nums[]) {
        int max = nums[0];
        int sum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], sum + nums[i]);
            max = Math.max(max, sum);
        }

        return max;
    }
}
