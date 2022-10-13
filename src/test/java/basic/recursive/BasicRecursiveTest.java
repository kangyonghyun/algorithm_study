package basic.recursive;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BasicRecursiveTest {

    @ParameterizedTest
    @ValueSource(ints = 3)
    void recursive(int n) {
        assertThat(solution(n)).containsExactly(1, 2, 3);
        assertThat(solution1(n)).containsExactly(1, 2, 3);
    }

    /**
     * 재귀함수를 돌려서 List 객체에 담기
     */
    public List<Integer> solution(int n) {
        List<Integer> results = new ArrayList<>();
        recursiveFunction(n, results);
        return results;
    }

    private void recursiveFunction(int n, List<Integer> result) {
        if (n == 0) {
            return;
        }
        recursiveFunction(n - 1, result);
        result.add(n);
    }

    /**
     * 객체 생성해서 배열에 담기
     */
    public int[] solution1(int n) {
        Recursive recursive = new Recursive(n);
        recursive.getAllNumbersWithRec(n);

        return recursive.numbers;
    }

    static class Recursive {
        int[] numbers;
        public Recursive(int n) {
            this.numbers = new int[n];
        }
        public void getAllNumbersWithRec(int n) {
            if (n == 0) {
                return;
            }
            getAllNumbersWithRec(n - 1);
            numbers[n - 1] = n;
        }
    }

}