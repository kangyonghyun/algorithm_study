package basic.queue;

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
            check.offer(ranking);
        }
        for (Character curriculum : curriculums.toCharArray()) {
            if (check.contains(curriculum)) {
                if (check.poll() != curriculum) {
                    return "NO";
                }
            }
        }
        if (!check.isEmpty()) {
            return "NO";
        }
        return "YES";
    }
}
