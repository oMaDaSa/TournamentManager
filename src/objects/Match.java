package objects;

import java.io.Serializable;


public class Match implements Serializable {

    private Boolean tie;

    private Player winner;

    private Player looser;

    private String desc;

    private int round;

    public Match(Player player1, int points1, Player player2, int points2){
        if(points1 == points2){
            tie = false;
        }else{
            tie = true;
            if(points1 > points2){
                winner = player1;
                looser = player2;
            }else{
                winner = player2;
                looser = player1;
            }
        }
        desc = null;
    }

    public Match(Player player1, int points1, Player player2, int points2, String desc) {
        if (points1 == points2) {
            tie = false;
        } else {
            tie = true;
            if (points1 > points2) {
                winner = player1;
                looser = player2;
            } else {
                winner = player2;
                looser = player1;
            }
        }
        this.desc = desc;
    }
}
