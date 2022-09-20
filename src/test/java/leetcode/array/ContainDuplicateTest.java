package leetcode.array;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class ContainDuplicateTest {

    @Test
    void solution1() {
        assertThat(containDuplicate1(new int[]{1, 2, 3, 1})).isTrue();
        assertThat(containDuplicate1(new int[]{1, 2, 3, 4})).isFalse();
        assertThat(containDuplicate1(new int[]{1,1,1,3,3,4,3,2,4,2})).isTrue();
    }

    @Test
    void solution2() {
        assertThat(containDuplicate2(new int[]{1, 2, 3, 1})).isTrue();
        assertThat(containDuplicate2(new int[]{1, 2, 3, 4})).isFalse();
        assertThat(containDuplicate2(new int[]{1,1,1,3,3,4,3,2,4,2})).isTrue();
    }

    @Test
    void solution3() {
        assertThat(containDuplicate3(new int[]{1, 2, 3, 1})).isTrue();
        assertThat(containDuplicate3(new int[]{1, 2, 3, 4})).isFalse();
        assertThat(containDuplicate3(new int[]{1,1,1,3,3,4,3,2,4,2})).isTrue();
    }

    /**
     * set 이용
     * 4-10 ms, 80-100%
     */
    public boolean containDuplicate1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 정렬 이용
     * 20-50 ms, 5-40%
     */
    public boolean containDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Map 사용
     * 20-33ms 20-40%
     */
    public boolean containDuplicate3(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                return true;
            }
            map.put(num, 0);
        }
        return false;
    }
}