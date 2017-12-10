package FinalPrep;

import DataStructures.Vector;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Team {
    private Vector<String> names;
    private Map<String, int[]> scores;
    private String team_name;
    private int ranking;

    Team(String team_name, int ranking, String... players) {
        this.team_name = team_name;
        this.ranking = ranking;
        this.scores = new HashMap<>();
        this.names = new Vector<>();

        for (String player: players) {
            scores.put(player, new int[3]);
            names.push_back(player);
        }
    }

    public void evaluate_player (String player, int score1, int score2, int score3) {
        if (scores.containsKey(player)) {
            int[] player_scores = scores.get(player);
            player_scores[0] = score1;
            player_scores[1] = score2;
            player_scores[2] = score3;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < names.size(); i++) {
            stringBuilder.append(names.at(i)).append("\t").append(Arrays.toString(scores.get(names.at(i)))).append("\n");
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Team team = new Team("Cats", 2, "Argos", "Woo", "Uncreative name", "Hello", "Creative name");
        System.out.println(team);
        System.out.println();
        team.evaluate_player("Uncreative name", 3, 1, 4);
        System.out.println(team);
        System.out.println();
    }
}
