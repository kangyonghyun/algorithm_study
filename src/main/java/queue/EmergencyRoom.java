package queue;

import java.util.*;

public class EmergencyRoom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfPatient = sc.nextInt();
        int order = sc.nextInt();
        Integer[] risks = new Integer[numberOfPatient];
        for (int i = 0; i < numberOfPatient; i++) {
            risks[i] = sc.nextInt();
        }

        EmergencyRoom emergencyRoom = new EmergencyRoom();
        System.out.println(emergencyRoom.getTreatmentOrder(numberOfPatient, order, risks));
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
