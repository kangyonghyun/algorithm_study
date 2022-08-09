package basic.recursive;

import org.junit.jupiter.api.Test;

class SubsetTest {

    @Test
    void subsetTest() {
        int number = 3;
        Subset subset = new Subset(number);
        subset.recursive(1);
    }

    static class Subset {
        int[] arr;
        int number;

        public Subset(int number) {
            this.arr = new int[number + 1];
            this.number = number;
        }

        private void recursive(int depth) {
            if (depth == number + 1) {
                for (int i = 1; i <= number; i++) {
                    if (arr[i] == 1) {
                        System.out.print(i + " ");
                    }
                }
                System.out.println();
            } else {
                arr[depth] = 1;
                recursive(depth + 1);
                arr[depth] = 0;
                recursive(depth + 1);
            }
        }
    }

}