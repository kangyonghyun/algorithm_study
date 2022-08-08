package basic.recursive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RecursiveFunctionTest {

    @ParameterizedTest
    @ValueSource(ints = 3)
    void recursive(int n) {
        assertThat(solution(n)).containsExactly(1, 2, 3);
    }

    public List<Integer> solution(int n) {
        List<Integer> results = new ArrayList<>();
        recursiveFunction(n, results);
        return results;
    }

    private void recursiveFunction(int n, List<Integer> result) {
        if (n > 0) {
            recursiveFunction(n - 1, result);
            result.add(n);
        }
    }

}