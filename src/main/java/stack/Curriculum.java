package stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Curriculum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Curriculum curriculum = new Curriculum();
        System.out.println(curriculum.planCurriculum(sc.next(), sc.next()));
    }

    private String planCurriculum(String priority, String curriculums) {
        Queue<Character> check = new LinkedList<>();
        for (Character ranking : priority.toCharArray()) {
            check.add(ranking);
        }
        for (Character curriculum : curriculums.toCharArray()) {
            if (curriculum == check.peek()) {
                check.poll();
            }
            if (check.isEmpty()) {
                return "YES";
            }
        }
        return "NO";
    }
}
