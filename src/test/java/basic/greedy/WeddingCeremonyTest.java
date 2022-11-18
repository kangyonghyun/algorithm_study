package basic.greedy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WeddingCeremonyTest {

    /**
     * 그리디 알고리즘
     * 타임 객체를 오는 시간과 가는 시간을 따로 생성
     * 시간을 기준으로 오름차순 정렬을 한 후, 같을 경우 가는 시간을 기준으로 오름차순 정렬
     * 리스트를 전체 탐색하면서, 오는 시간일 경우 더해주고 가는 시간을 경우 뺴주면서 max 값을 구함
     * 전체 탐색 후, max 값이 동시에 존재하는 최대 인원임
     */

    @Test
    void solution() {
        List<Time> times = new ArrayList<>();
        times.add(new Time(5, 's'));
        times.add(new Time(14, 'e'));
        times.add(new Time(12, 's'));
        times.add(new Time(15, 'e'));
        times.add(new Time(14, 's'));
        times.add(new Time(18, 'e'));
        times.add(new Time(15, 's'));
        times.add(new Time(20, 'e'));
        times.add(new Time(20, 's'));
        times.add(new Time(30, 'e'));

        assertThat(getMaxNumberOfFriends(times)).isEqualTo(2);
    }

    private int getMaxNumberOfFriends(List<Time> times) {
        Collections.sort(times, (o1, o2) -> {
            if (o1.time == o2.time) {
                return o1.state - o2.state;
            }
            return o1.time - o2.time;
        });
        int count = 0;
        int maxCount = 0;
        for (Time time : times) {
            if (time.state == 's') {
                count++;
            } else {
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    static class Time {
        int time;
        char state;

        public Time(int time, char state) {
            this.time = time;
            this.state = state;
        }
    }

}