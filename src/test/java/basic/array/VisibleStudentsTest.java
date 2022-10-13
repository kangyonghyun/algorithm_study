package basic.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VisibleStudentsTest {

    @Test
    void solution() {
        int n = 8;
        int[] students = {130, 135, 148, 140, 145, 150, 150, 153};
        assertThat(getVisibleNumberOfStudent1(n, students)).isEqualTo(5);
    }

    private int getVisibleNumberOfStudent(int n, int[] students) {
        int numberOfStudent = 1;
        int idx = 0;
        for (int i = 1; i < n; i++) {
            if (students[idx] < students[i]) {
                numberOfStudent++;
                idx = i;
            }
        }
        return numberOfStudent;
    }

    private int getVisibleNumberOfStudent1(int n, int[] students) {
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