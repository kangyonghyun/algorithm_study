package basic.greedy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WrestlingPlayerTest {

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

    public int getNumberOfPlayers(List<Player> players) {
        int result = 0;
        Collections.sort(players, (o1, o2) -> o2.height - o1.height);

        for (int i = 0; i < players.size(); i++) {
            boolean flag = true;
            for (int j = i - 1; j >= 0; j--) {
                if (players.get(i).weight < players.get(j).weight) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result++;
            }
        }
        return result;
    }

    public int getNumberOfPlayers2(List<Player> players) {
        int result = 0;
        Collections.sort(players, (o1, o2) -> o2.height - o1.height);

        int max = Integer.MIN_VALUE;
        for (Player player : players) {
            if (player.weight > max) {
                max = player.weight;
                result++;
            }
        }
        return result;
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
