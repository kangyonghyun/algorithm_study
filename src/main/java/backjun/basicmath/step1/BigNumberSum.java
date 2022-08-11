package backjun.basicmath.step1;

import java.math.BigDecimal;
import java.util.Scanner;

public class BigNumberSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigNumberSum bigNumberSum = new BigNumberSum();
        System.out.println(bigNumberSum.sum(sc.next(), sc.next()));
    }

    private String sum(String a, String b) {
        BigDecimal num1 = new BigDecimal(a);
        BigDecimal num2 = new BigDecimal(b);
        return num1.add(num2).toString();
    }
}
