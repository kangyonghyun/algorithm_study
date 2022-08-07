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
