package basic.sorting;

import java.util.*;

public class CoordinateSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Position> positions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            positions.add(new Position(sc.nextInt(), sc.nextInt()));
        }
//        sort(positions);
        Collections.sort(positions);
        for (Position position : positions) {
            System.out.println(position.x + " " + position.y);
        }
    }

    public static void sort(List<Position> positions) {
        Collections.sort(positions, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                if (o1.x - o2.x == 0) {
                    return o1.y - o2.y;
                }
                return o1.x - o2.x;
            }
        });
    }

    static class Position implements Comparable<Position> {
        int x;
        int y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public int compareTo(Position o) {
            return this.x - o.x == 0 ? this.y - o.y : this.x - o.x;
        }
    }
}
