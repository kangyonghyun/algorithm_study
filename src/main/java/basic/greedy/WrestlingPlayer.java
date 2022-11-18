package basic.greedy;

import java.util.*;

public class WrestlingPlayer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            players.add(new Player(sc.nextInt(), sc.nextInt()));
        }

        WrestlingPlayer wrestlingPlayer = new WrestlingPlayer();
        System.out.println(wrestlingPlayer.getNumberOfPlayers(players));
    }

    public int getNumberOfPlayers(List<Player> players) {
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
