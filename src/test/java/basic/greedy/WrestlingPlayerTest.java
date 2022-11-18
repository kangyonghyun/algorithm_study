package basic.greedy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WrestlingPlayerTest {

    /**
     * 그리디 알고리즘 (탐욕 알고리즘)
     * 키로 내림차순 정렬
     * 몸무게를 비교하여 맥스인 몸무게
     */

    @Test
    void count() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(172, 67));
        players.add(new Player(183, 65));
        players.add(new Player(180, 70));
        players.add(new Player(170, 72));
        players.add(new Player(181, 60));

        assertThat(getNumberOfPlayers2(players)).isEqualTo(3);
    }

    public int getNumberOfPlayers2(List<Player> players) {
        int count = 0;
        Collections.sort(players, (o1, o2) -> o2.height - o1.height);

        int max = Integer.MIN_VALUE;
        for (Player player : players) {
            if (player.weight > max) {
                max = player.weight;
                count++;
            }
        }
        return count;
    }

    static class Player {
        int height;
        int weight;

        public Player(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }

}
