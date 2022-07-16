package backjun.basicmath.step1;

import java.util.Scanner;

public class FindFractions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        FindFractions findFractions = new FindFractions();
        System.out.println(findFractions.solution(num));
    }

    private String solution(int num) {
        int result = 0;
        int up = 0;
        int down = 0;
        String txt = "";

        for (int i = 1; i <= num; i++) {
            for (int j = 0; j < i; j++) {
                if (i % 2 != 0){
                    down = j + 1;
                    up = i - j;
                } else {
                    up = j + 1;
                    down = i - j;
                }
                result++;
                if (result == num) {
                    txt = up + "/" + down;
                    return txt;
                }
            }
        }
        return txt;
    }

}
