package basic.greedy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class ScheduleTest {

    @Test
    void solution() {
        int n = 6;
        List<Lecture> lectures = new ArrayList<>();
        lectures.add(new Lecture(50, 2));
        lectures.add(new Lecture(20, 1));
        lectures.add(new Lecture(40, 2));
        lectures.add(new Lecture(60, 3));
        lectures.add(new Lecture(30, 3));
        lectures.add(new Lecture(30, 1));

        int maxPay = getMaxPay(n, lectures);
        assertThat(maxPay).isEqualTo(150);
    }

    private int getMaxPay(int n, List<Lecture> lectures) {
        Collections.sort(lectures, new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                return o2.day - o1.day;
            }
        });

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