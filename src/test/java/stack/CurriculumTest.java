package stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class CurriculumTest {

    @ParameterizedTest
    @CsvSource({"CBA, CBDAGE, YES", "CBA, DCEAGB, NO", "ABCDEG, ABCDEG, YES"})
    void plan(String priority, String curriculums, String expected) {
        assertThat(planCurriculum(priority, curriculums)).isEqualTo(expected);
    }

    private String planCurriculum(String priority, String curriculums) {
        Queue<Character> check = new LinkedList<>();
        for (Character ranking : priority.toCharArray()) {
            check.offer(ranking);
        }
        for (Character curriculum : curriculums.toCharArray()) {
            if (check.contains(curriculum)) {
                if (check.poll() != curriculum) {
                    return "NO";
                }
            }
        }
        if (!check.isEmpty()) {
            return "NO";
        }
        return "YES";
    }

}