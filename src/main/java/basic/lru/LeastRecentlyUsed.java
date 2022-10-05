package basic.lru;

import java.util.Scanner;

public class LeastRecentlyUsed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] cache = getCacheMemory(s, arr);
        for (int i : cache) {
            System.out.print(i + " ");
        }
    }

    private static int[] getCacheMemory(int size, int[] arr) {
        int[] cache = new int[size];
        for (int a : arr) {
            int idx = 0;
            boolean isExistCache = false;
            for (int i = 0; i < size; i++) {
                if (cache[i] == a) {
                    idx = i;
                    isExistCache = true;
                }
            }
            if (isExistCache) {
                cacheHit(cache, idx);
            } else {
                cacheMiss(cache);
            }
            cache[0] = a;
        }
        return cache;
    }

    private static void cacheMiss(int[] cache) {
        for (int i = cache.length - 1; i > 0; i--) {
            cache[i] = cache[i - 1];
        }
    }

    private static void cacheHit(int[] cache, int pos) {
        for (int i = pos; i > 0; i--) {
            cache[i] = cache[i - 1];
        }
    }
}
