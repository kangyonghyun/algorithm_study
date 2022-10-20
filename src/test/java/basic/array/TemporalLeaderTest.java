package basic.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TemporalLeaderTest {

    @Test
    void solution() {
        int n = 5;
        int[][] school = {
                {2, 3, 1, 7, 3},
                {4, 1, 9, 6, 8},
                {5, 5, 2, 4, 4},
                {6, 5, 2, 6, 7},
                {8, 4, 2, 2, 2}
        };

        assertThat(getTemporalLeader(n, school)).isEqualTo(4);
    }

    private int getTemporalLeader(int n, int[][] school) {
        int leader = 0;
        int max = 0;

        // 학생 번호
        for (int i = 0; i < n; i++) {
            int count = 0;
            // 학생 번호
            for (int j = 0; j < n ; j++) {
                // 학년
                for (int k = 0; k < 5; k++) {
                    if (school[i][k] == school[j][k]) {
                        count++;
                        break;
                    }
                }
            }
            if (count > max) {
                max = count;
                leader = i + 1;
            }
        }
        
        return leader;
    }

}