package basic.sorting;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

class CoordinateSortingTest {

    @Test
    void solution() {
        List<Position> positions = new ArrayList<>();
        positions.add(new Position(2, 7));
        positions.add(new Position(1, 3));
        positions.add(new Position(1, 2));
        positions.add(new Position(2, 5));
        positions.add(new Position(3, 6));
//        sort(positions);
        Collections.sort(positions);
        assertThat(positions)
                .containsExactly(new Position(1, 2), new Position(1, 3), new Position(2, 5), new Position(2, 7), new Position(3, 6));
    }

    public void sort(List<Position> positions) {
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