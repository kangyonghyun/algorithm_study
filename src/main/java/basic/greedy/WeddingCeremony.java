package basic.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WeddingCeremony {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            times.add(new Time(sc.nextInt(), 's'));
            times.add(new Time(sc.nextInt(), 'e'));
        }
        System.out.println(getMaxNumberOfFriends(times));
    }

    public static int getMaxNumberOfFriends(List<Time> times) {
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
