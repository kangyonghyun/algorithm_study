package basic.search.decision;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class MusicVideoTest {

    @Test
    void solution() {
        int n = 9;
        int m = 3;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(getMinSizeVideo(n, m, arr)).isEqualTo(17);
    }

    @Test
    void solution1() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Video> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(new Video(arr[i]));
        }
        Videos videos = new Videos(list, 3);
        int result = videos.getMinTotalSizeOfVideoWithCapacity();
        assertThat(result).isEqualTo(17);
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

    private int getMinSizeVideo(int n, int m, int[] arr) {
        int min = 0;
        int left = Arrays.stream(arr).max().getAsInt();
        int right = Arrays.stream(arr).sum();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (count(arr, mid) <= m) {
                min = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return min;
    }

    private int count(int[] arr, int capacity) {
        int sum = 0;
        int count = 1;
        for (int i : arr) {
            sum += i;
            if (sum > capacity) {
                sum = i;
                count++;
            }
        }
        return count;
    }

}