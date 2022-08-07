package stack;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

class CurriculumTest {

    @ParameterizedTest
    @CsvSource({"CBA, CBDAGE, YES", "CBA, DCEAGB, NO"})
    void plan(String priority, String curriculums, String expected) {
        assertThat(planCurriculum(priority, curriculums)).isEqualTo(expected);
    }

    private String planCurriculum(String priority, String curriculums) {
        Queue<Character> check = new LinkedList<>();
        for (Character ranking : priority.toCharArray()) {
            check.add(ranking);
        }
        for (Character curriculum : curriculums.toCharArray()) {
            if (curriculum == check.peek()) {
                check.poll();
            }
            if (check.isEmpty()) {
                return "YES";
            }
        }
        return "NO";
    }

}