package basic.array;

import java.util.Scanner;

public class VisibleStudents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = sc.nextInt();
        }
        System.out.println(getVisibleNumberOfStudent(n, students));
    }

    private static int getVisibleNumberOfStudent(int n, int[] students) {
        int numberOfStudent = 1;
        int max = students[0];
        for (int i = 1; i < n; i++) {
            if (max < students[i]) {
                numberOfStudent++;
                max = students[i];
            }
        }
        return numberOfStudent;
    }
}
