package leetcode.array;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {
    @ParameterizedTest
    @MethodSource("provideNumForTwoSum")
    void solution(int[] nums, int target, int[] expected) {
        assertThat(doubleForTwoSum(nums, target)).containsExactly(expected);
        assertThat(mapTwoSum(nums, target)).containsExactly(expected);
    }

    private static Stream<Arguments> provideNumForTwoSum() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{0, 1}),
                Arguments.of(new int[]{3, 2, 4}, 6, new int[]{1, 2}),
                Arguments.of(new int[]{3, 3}, 6, new int[]{0, 1})
        );
    }

    /**
     * 이중 for 문
     * 빅오 : O(n2)
     * 70ms, 37.29%
     */
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


    /**
     * Map 활용
     * 빅오 : O(n)
     * 9ms, 52.13%
     */
    private int[] mapTwoSum(int[] nums, int target) {
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