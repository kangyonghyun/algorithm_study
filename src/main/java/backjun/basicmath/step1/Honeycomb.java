package backjun.basicmath.step1;

import java.util.Scanner;

public class Honeycomb {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Honeycomb honeycomb = new Honeycomb();
        System.out.println(honeycomb.getFloor(sc.nextInt()));
    }

    private int getFloor(int room) {
        int totalRoom = 1;
        int floor = 1;
        while (room > totalRoom) {
            totalRoom += (floor * 6);
            floor++;
        }
        return floor;
    }
}
