package basic.recursive;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Factorial factorial = new Factorial();
        System.out.println(factorial.getFactorial(sc.nextInt()));
    }

    private int getFactorial(int n) {
        int result = 0;
        if (n > 0) {
            result= getFactorial(n - 1) * n;
        } else {
            return 1;
        }
        return result;
    }
}
