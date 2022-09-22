package leetcode.array;

public class ProductArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] results = new int[length];
        results[0] = 1;
        for (int i = 1; i < length; i++) {
            results[i] = results[i - 1] * nums[i - 1];
        }
        int product = 1;
        for (int i = length - 2; i >= 0 ; i--) {
            product *= nums[i + 1];
            results[i] = results[i] * product;
        }

        return results;
    }
}
