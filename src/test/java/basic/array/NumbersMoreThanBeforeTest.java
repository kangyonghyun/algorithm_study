package basic.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersMoreThanBeforeTest {

    @Test
    void solution() {
        int n = 6;
        int[] arr = {7, 3, 9, 5, 6, 12};
        assertThat(getNumbersMoreThanBefore(n, arr)).containsExactly(7, 9, 6, 12);
    }

    private List<Integer> getNumbersMoreThanBefore(int n, int[] arr) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                numbers.add(arr[i]);
            }
        }
        return numbers;
    }

}