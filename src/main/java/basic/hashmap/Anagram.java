package basic.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();

        Anagram anagram = new Anagram();
        System.out.println(anagram.solution(word1, word2));
    }

    private String solution(String word1, String word2) {
        Map<Character, Integer> word1Map = new HashMap<>();
        for (char c : word1.toCharArray()) {
            word1Map.put(c, word1Map.getOrDefault(c, 0) + 1);
        }

        for (char c : word2.toCharArray()) {
            if (!word1Map.containsKey(c) || word1Map.get(c) == 0) {
                return "NO";
            }
            word1Map.put(c, word1Map.get(c) - 1);
        }
        return "YES";
    }

}
