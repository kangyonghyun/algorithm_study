package basic.recursive;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryNumberTest {
    @Test
    void solution1() {
        int decimal = 11;
        assertThat(solution1(decimal)).containsExactly(1, 0, 1, 1);
    }

    public List<Integer> solution1(int decimal) {
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

    @Test
    void solution2() {
        int decimal = 11;
        assertThat(solution2(decimal)).containsExactly(1, 0, 1, 1);
    }

    public List<Integer> solution2(int decimal) {
        Recursive recursive = new Recursive();
        recursive.decimalToBinary(decimal);
        return recursive.binaryNumbers;
    }

    static class Recursive {
        List<Integer> binaryNumbers;
        public Recursive() {
            binaryNumbers = new ArrayList<>();
        }

        public void decimalToBinary(int decimal) {
            if (decimal == 0) {
                return;
            }
            decimalToBinary(decimal / 2);
            this.binaryNumbers.add(decimal % 2);
        }
    }

}