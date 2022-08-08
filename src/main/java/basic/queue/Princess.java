package basic.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Princess {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Princess princess = new Princess();
        System.out.println(princess.getPrinceForSavePrincess(sc.nextInt(), sc.nextInt()));
    }

    private int getPrinceForSavePrincess(int total, int except) {
        Queue<Integer> princes = new LinkedList<>();
        for (int i = 1; i <= total; i++) {
            princes.add(i);
        }
        int prince = 0;
        while (!princes.isEmpty()) {
            for (int i = 0; i < except - 1; i++) {
                princes.add(princes.poll());
            }
            if (!princes.isEmpty()) {
                prince = princes.poll();
            }
        }
        return prince;
    }
}
