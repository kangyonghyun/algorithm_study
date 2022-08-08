package basic.recursive;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryNumberTest {
    @Test
    void binary() {
        int decimal = 11;
        assertThat(getBinaryNumbers(decimal)).containsExactly(1, 0, 1, 1);
    }

    public List<Integer> getBinaryNumbers(int decimal) {
        List<Integer> binaryNumbers = new ArrayList<>();
        recursive(decimal, binaryNumbers);
        return binaryNumbers;
    }

    private void recursive(int decimal, List<Integer> binaryNumbers) {
        if (decimal > 0) {
            recursive(decimal / 2, binaryNumbers);
            binaryNumbers.add(decimal % 2);
        }
    }

}