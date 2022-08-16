package backjun.basicmath.step1;

import java.util.Scanner;

public class BreakEvenPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BreakEvenPoint breakEvenPoint = new BreakEvenPoint();
        System.out.println(breakEvenPoint.getBreakEvenPoint(sc.nextLong(), sc.nextLong(), sc.nextLong()));
    }

    private long getBreakEvenPoint(long A, long B, long C) {
        // A + Bn < Cn
        // A / (C - B) < n
        // 고정비용 / (1대 가격 - 1대 가변)
        long temp = C - B;
        if (temp > 0) {
            return A / temp + 1;
        }
        return -1;
    }
}
