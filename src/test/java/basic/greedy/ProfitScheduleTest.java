package basic.greedy;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

class ProfitScheduleTest {

    /**
     * 그리디 알고리즘
     * 날짜를 기준으로 내림차순 정렬
     * 이중 for 문을 이용해서 가장 긴 날짜 순서로 바깥 for 문을 돌린다.
     * 안쪽 for 문은 기준 날짜보다 작아지면 빠져나오고 아니면 priorityQue 에 넣는다.
     * priorityQue 에서 가장 높은 페이를 뽑아서 값을 더하고 바깥 for 문을 돌린다.
     * 날짜가 3일이 주여졌으몰 바깥 for 문이 3번 돌고 최대 페이를 que 에서 빼서 더해준다.
     */

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