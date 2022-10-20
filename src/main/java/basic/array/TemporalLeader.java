package basic.array;

import java.util.Scanner;

public class TemporalLeader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] school = new int[n][5];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                school[i][j] = sc.nextInt();
            }
        }
        System.out.println(getTemporalLeader(n, school));
    }

    private static int getTemporalLeader(int n, int[][] school) {
        int leader = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 5; k++) {
                    if (school[i][k] == school[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if (max < count) {
                max = count;
                leader = i + 1;
            }
        }
        return leader;
    }

}
