package basic.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ReversePrimeNumberTest {

    @Test
    void solution() {
        int n = 9;
        int[] arr = {32, 55, 62, 20, 250, 370, 200, 30, 100};
        assertThat(getReversePrimeNumbers1(arr)).containsExactly(23, 2, 73, 2, 3);
    }

    private List<Integer> getReversePrimeNumbers(int[] arr) {
        List<Integer> reversePrimeNumbers = new ArrayList<>();
        for (int number : arr) {
            int reverseNumber = Integer.parseInt(new StringBuffer(String.valueOf(number)).reverse().toString());
            if (isPrimeNumber(reverseNumber)) {
                reversePrimeNumbers.add(reverseNumber);
            }
        }
        return reversePrimeNumbers;
    }

    private boolean isPrimeNumber(int number) {
        if (number == 1) {
            return false;
        }
        int[] check = new int[number + 1];
        for (int i = 2; i < number; i++) {
            if (check[i] == 0) {
                for (int j = i; j <= number; j += i) {
                    if (j == number) {
                        return false;
                    }
                    check[j] = 1;
                }
            }
        }
        return check[number] == 0;
    }

    private List<Integer> getReversePrimeNumbers1(int[] arr) {
        List<Integer> reversePrimeNumbers = new ArrayList<>();
        for (int number : arr) {
            int reverseNumber = 0;
            while (number > 0) {
                int t = number % 10;
                reverseNumber = reverseNumber * 10 + t;
                number = number / 10;
            }
            if (isPrime(reverseNumber)) {
                reversePrimeNumbers.add(reverseNumber);
            }
        }
        return reversePrimeNumbers;
    }

    private boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}