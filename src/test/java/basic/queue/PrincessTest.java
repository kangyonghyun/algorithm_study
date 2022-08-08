package basic.queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class PrincessTest {

    @ParameterizedTest
    @CsvSource({"8, 3, 7"})
    void save(int total, int except, int expected) {
        assertThat(getPrinceForSavePrincess(total, except)).isEqualTo(expected);
    }

    private int getPrinceForSavePrincess(int total, int except) {
        Queue<Integer> princes = new LinkedList<>();
        for (int i = 1; i <= total; i++) {
            princes.add(i);
        }
        int prince = 0;
        while (!princes.isEmpty()) {
            for (int i = 0; i < except - 1; i++) {
                princes.add(princes.poll());
            }
            if (!princes.isEmpty()) {
                prince = princes.poll();
            }
        }
        return prince;
    }

}