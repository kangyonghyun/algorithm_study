package backjun.basicmath.step1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class President {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        List<Integer> results = new ArrayList<>();
        President president = new President();
        while (T > 0) {
            T--;
            int floor = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            results.add(president.calculateNumberOfPeople(floor, n));
        }
        for (Integer numberOfPeople : results) {
            System.out.println(numberOfPeople);
        }
        br.close();
    }

    private int calculateNumberOfPeople(int floor, int n) {
        int[][] apart = new int[floor + 1][n];
        for (int i = 0; i < n; i++) {
            apart[0][i] = i + 1;
        }
        for (int i = 1; i <= floor; i++) {
            apart[i][0] = 1;
            for (int j = 1; j < n; j++) {
                apart[i][j] = apart[i - 1][j] + apart[i][j - 1];
            }
        }
        return apart[floor][n - 1];
    }
}
