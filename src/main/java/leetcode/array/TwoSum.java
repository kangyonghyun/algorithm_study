package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] doubleForTwoSum(int[] nums, int target) {
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

    public int[] mapTwoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int match = target - current;
            if (map.containsKey(current)) {
                return new int[]{map.get(current), i};
            }
            map.put(match, i);
        }
        return new int[]{};
    }
}
