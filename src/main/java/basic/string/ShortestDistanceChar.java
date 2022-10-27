package basic.string;

import java.util.Scanner;

public class ShortestDistanceChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next();
        char target = sc.next().charAt(0);
        for (int dist : getShortestDistance(word, target)) {
            System.out.print(dist + " ");
        }
    }

    private static int[] getShortestDistance(String word, char target) {
        int[] distance = new int[word.length()];
        for (int i = 0; i < word.length(); i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == target) {
                for (int j = 0; j < chars.length; j++) {
                    distance[j] = Math.min(distance[j], Math.abs(j - i));
                }
            }
        }
        return distance;
    }
}
