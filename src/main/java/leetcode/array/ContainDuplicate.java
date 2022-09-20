package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class ContainDuplicate {
    public boolean containDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }
}
