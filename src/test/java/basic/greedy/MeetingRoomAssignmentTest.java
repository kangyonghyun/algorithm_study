package basic.greedy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MeetingRoomAssignmentTest {

    /**
     *  그리디 알고리즘
     *  강의 종료 시간을 기준을 오름차순 정렬
     *  강의 종료 시간과 그 다음 강의 시작 시간을 비교
     *  시작 시간이 같거나 크면 카운트하고 아니면 지나감
     */

    @Test
    void 방법() {
        List<Meeting> meetings = new ArrayList<>();
        meetings.add(new Meeting(1, 4));
        meetings.add(new Meeting(2, 3));
        meetings.add(new Meeting(3, 5));
        meetings.add(new Meeting(4, 6));
        meetings.add(new Meeting(5, 7));
        assertThat(getMaxCountOfMeet(meetings)).isEqualTo(3);
    }
    private int getMaxCountOfMeet(List<Meeting> meetings) {
        Collections.sort(meetings, (o1, o2) -> {
            if (o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });
        int count = 0;
        int end = 0;
        for (Meeting meeting : meetings) {
            if (end <= meeting.start) {
                count++;
                end = meeting.end;
            }
        }
        return count;
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}