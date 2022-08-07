package queue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class EmergencyRoomTest {

    @ParameterizedTest
    @MethodSource("provideRisksForTreatment")
    void priority(int numberOfPatient, int order, Integer[] risks, int expected) {
        assertThat(getTreatmentOrder(numberOfPatient, order, risks)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideRisksForTreatment() {
        return Stream.of(
                Arguments.of(5, 2, new Integer[]{60, 50, 70, 80, 90}, 3),
                Arguments.of(6, 3, new Integer[]{70, 60, 90, 60, 60, 60}, 4)
        );
    }

    private int getTreatmentOrder(int numberOfPatient, int order, Integer[] risks) {
        Queue<Patient> patients = new LinkedList<>();
        for (int i = 0; i < numberOfPatient; i++) {
            patients.offer(new Patient(risks[i], i));
        }
        int count = 0;
        Arrays.sort(risks, Comparator.reverseOrder());
        for (int risk : risks) {
            while (numberOfPatient == patients.size()) {
                Patient patient = patients.poll();
                if (patient.getRisk() == risk && patient.getOrder() == order) {
                    return ++count;
                } else if (patient.getRisk() == risk) {
                    numberOfPatient--;
                    count++;
                    break;
                } else {
                    patients.offer(patient);
                }
            }
        }
        return count;
    }

    static class Patient {
        int risk;
        int order;

        public Patient(int risk, int order) {
            this.risk = risk;
            this.order = order;
        }

        public int getRisk() {
            return risk;
        }

        public int getOrder() {
            return order;
        }
    }


}