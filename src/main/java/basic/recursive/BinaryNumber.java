package basic.recursive;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BinaryNumber binaryNumber = new BinaryNumber();

        for (int binary : binaryNumber.getBinaryNumbers(sc.nextInt())) {
            System.out.print(binary);
        }
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
