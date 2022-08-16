package backjun.basicmath.step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class HoneycombTest {

    @ParameterizedTest
    @CsvSource({"13, 3", "58, 5"})
    void honey(int rooNumber, int expected) {
        assertThat(getFloor(rooNumber)).isEqualTo(expected);
    }

    private int getFloor(int room) {
        int totalRoom = 1;
        int floor = 1;
        while (room > totalRoom) {
            totalRoom += (floor * 6);
            floor++;
        }
        return floor;
    }

}