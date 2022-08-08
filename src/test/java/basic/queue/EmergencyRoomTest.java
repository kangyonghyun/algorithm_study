package basic.queue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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
        assertThat(getTreatmentOrder1(numberOfPatient, order, risks)).isEqualTo(expected);
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
        for (int maxRisk : risks) {
            while (!patients.isEmpty()) {
                Patient patient = patients.poll();
                if (patient.isMaxRisk(maxRisk) && patient.isOrder(order)) {
                    return ++count;
                } else if (patient.isMaxRisk(maxRisk)) {
                    count++;
                    break;
                } else {
                    patients.offer(patient);
                }
            }
        }
        return count;
    }

    private int getTreatmentOrder1(int numberOfPatient, int order, Integer[] risks) {
        Queue<Patient> patients = new LinkedList<>();
        for (int i = 0; i < numberOfPatient; i++) {
            patients.offer(new Patient(risks[i], i));
        }
        int count = 0;
        while (!patients.isEmpty()) {
            Patient findPatient = patients.poll();
            for (Patient patient : patients) {
                if (patient.isLessThanRisk(findPatient)) {
                    patients.offer(findPatient);
                    findPatient = null;
                    break;
                }
            }
            if (findPatient != null) {
                count++;
                if (findPatient.isOrder(order)) {
                    return count;
                }
            }
        }
        return count;
    }

    static class Patient {
        private final int risk;
        private final int order;

        public Patient(int risk, int order) {
            this.risk = risk;
            this.order = order;
        }

        public boolean isOrder(int order) {
            return this.order == order;
        }

        public boolean isLessThanRisk(Patient findPatient) {
            return this.risk > findPatient.risk;
        }

        public boolean isMaxRisk(int maxRisk) {
            return this.risk == maxRisk;
        }
    }

}