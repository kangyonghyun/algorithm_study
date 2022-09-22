package leetcode.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ProductArrayExceptSelfTest {

    @Test
    void solution1() {
        assertThat(productExceptSelf12(new int[]{1, 2, 3, 4})).containsExactly(24, 12, 8, 6);
        assertThat(productExceptSelf12(new int[]{-1, 1, 0, -3, 3})).containsExactly(0, 0, 9, 0, 0);
        assertThat(productExceptSelf12(new int[]{0, 0})).containsExactly(0, 0);
    }

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
    public int[] productExceptSelf12(int[] nums) {
        int length = nums.length;
        int[] results = new int[length];
        int[] rt = new int[length];
        int[] lt = new int[length];
        rt[0] = 1;
        lt[length - 1] = 1;

        for (int i = 1; i < length; i++) {
            rt[i] = rt[i - 1] * nums[i - 1];
        }

        for (int i = length - 2; i >= 0; i--) {
            lt[i] = lt[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < length; i++) {
            results[i] = rt[i] * lt[i];
        }

        return results;
    }

    /**
     * 이중 for 문
     * Timeout
     */
    public int[] productExceptSelf11(int[] nums) {
        int[] results = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = 0; j < results.length; j++) {
                if (i == j) {
                    continue;
                }
                product = product * nums[j];
            }
            results[i] = product;
        }
        return results;
    }
}