package basic.greedy;

import java.util.*;

public class MeetingRoomAssignment {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }
        MeetingRoomAssignment assignment = new MeetingRoomAssignment();
        int maxCountOfMeet = assignment.getMaxCountOfMeet(meetings);
        System.out.println(maxCountOfMeet);
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
