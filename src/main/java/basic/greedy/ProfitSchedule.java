package basic.greedy;

import java.util.*;

public class ProfitSchedule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Lecture> lectures = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            lectures.add(new Lecture(sc.nextInt(), sc.nextInt()));
        }
        System.out.println(getMaxPay(n, lectures));
    }

    private static int getMaxPay(int n, List<Lecture> lectures) {
        Collections.sort(lectures, (o1, o2) -> o2.day - o1.day);
        int result = 0;
        int max = Integer.MIN_VALUE;
        for (Lecture lecture : lectures) {
            if (lecture.day > max) {
                max = lecture.day;
            }
        }
        PriorityQueue<Integer> pQue = new PriorityQueue<>(Collections.reverseOrder());
        int j = 0;
        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (lectures.get(j).day < i) {
                    break;
                }
                pQue.offer(lectures.get(j).pay);
            }
            if (!pQue.isEmpty()) {
                result += pQue.poll();
            }
        }
        return result;
    }

    static class Lecture {
        int pay;
        int day;

        public Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }
}
