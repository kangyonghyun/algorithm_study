package hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AllAnagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        AllAnagram allAnagram = new AllAnagram();
        System.out.println(allAnagram.findCountOfAnagram(word1, word2));
    }

    private int findCountOfAnagram(String word1, String word2) {
        Map<Character, Integer> anaMap1 = new HashMap<>();
        Map<Character, Integer> anaMap2 = new HashMap<>();
        for (char c : word2.toCharArray()) {
            anaMap2.put(c, anaMap2.getOrDefault(c, 0) + 1);
        }
        char[] chars = word1.toCharArray();
        for (int i = 0; i < word2.length() - 1; i++) {
            char c = chars[i];
            anaMap1.put(c, anaMap1.getOrDefault(c, 0) + 1);
        }
        int count = 0;
        int lt = 0;
        for (int rt = word2.length() - 1; rt < word1.length(); rt++) {
            char c = chars[rt];
            anaMap1.put(c, anaMap1.getOrDefault(c, 0) + 1);

            if (anaMap1.equals(anaMap2)) {
                count++;
            }

            if (anaMap1.get(chars[lt]) != 0 || anaMap1.get(chars[lt]) != null) {
                anaMap1.put(chars[lt], anaMap1.get(chars[lt]) - 1);
            }
            if (anaMap1.get(chars[lt]) == 0) {
                anaMap1.remove(chars[lt]);
            }
            lt++;
        }
        return count;
    }

}
