package basic.search.decision;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MusicVideo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Video> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new Video(sc.nextInt()));
        }
        Videos videos = new Videos(list, m);
        System.out.println(videos.getMinTotalSizeOfVideoWithCapacity());
    }
    static class Video {
        int size;

        public Video(int size) {
            this.size = size;
        }
    }

    static class Videos {
        List<Video> videos;
        int capacity;

        public Videos(List<Video> videos, int capacity) {
            this.videos = videos;
            this.capacity = capacity;
        }

        public int getMinTotalSizeOfVideoWithCapacity() {
            int min = 0;
            int left = videos.stream().max(Comparator.comparingInt(o -> o.size)).get().size;
            int right = videos.stream().mapToInt(v -> v.size).sum();
            while (left <= right) {
                int mid = (left + right) / 2;
                if (getSizeOfVideoWithCapacity(mid) <= capacity) {
                    min = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return min;
        }

        private int getSizeOfVideoWithCapacity(int capacity) {
            int sum = 0;
            int count = 1;
            for (Video v : videos) {
                sum += v.size;
                if (sum > capacity) {
                    sum = v.size;
                    count++;
                }
            }
            return count;
        }
    }
}


