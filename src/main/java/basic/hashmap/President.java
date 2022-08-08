package basic.hashmap;

import java.util.HashMap;
import java.util.Scanner;

public class President {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int numberOfStudent = kb.nextInt();
        String votes = kb.next();

        President president = new President();
        System.out.println(president.solution(votes));
    }

    private char solution(String votes) {
        HashMap<Character, Integer> resultMap = new HashMap<>();
        for (char vote : votes.toCharArray()) {
            resultMap.put(vote, resultMap.getOrDefault(vote, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        char result = '\u0000';
        for (char key : resultMap.keySet()) {
            if (resultMap.get(key) >= max) {
                max = resultMap.get(key);
                result = key;
            }
        }
        return result;
    }
}
