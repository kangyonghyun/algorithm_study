package basic.array;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MentoringTest {

    @Test
    void solution() {
        int numberOfStudent = 4;
        int countOfTest = 3;
        int[][] results = {
                {3, 4, 1, 2},
                {4, 3, 2, 1},
                {3, 1, 4, 2}
        };
        assertThat(getNumberOfCase(numberOfStudent, countOfTest, results)).isEqualTo(3);
    }

    private int getNumberOfCase(int numberOfStudent, int countOfTest, int[][] results) {
        int numberOfCase = 0;
        int rank = numberOfStudent;
        // 학생의 번호
        for (int i = 1; i <= numberOfStudent; i++) {
            //학생의 번호
            for (int j = 1; j <= numberOfStudent; j++) {
                int count = 0;
                // 테스트의 수
                for (int k = 0; k < countOfTest; k++) {
                    int pi = 0;
                    int pj = 0;
                    // 등수
                    for (int l = 0; l < rank; l++) {
                        // 해당 테스트의 몇 등?
                        if (results[k][l] == i) {
                            pi = l;
                        }
                        if (results[k][l] == j) {
                            pj = l;
                        }
                    }
                    if (pi < pj) {
                        count++;
                    }
                }
                if (count == countOfTest) {
                    numberOfCase++;
                }
            }
        }
        return numberOfCase;
    }

}