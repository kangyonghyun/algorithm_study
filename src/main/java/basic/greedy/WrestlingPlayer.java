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

    static class Player {
        int height;
        int weight;

        public Player(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }
    }
}
