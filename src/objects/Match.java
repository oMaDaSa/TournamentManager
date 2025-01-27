package objects;

import java.io.Serializable;


public class Match implements Serializable {
    private Boolean tie;

    private Player winner;
    private int winnerPoints;

    private Player looser;
    private int looserPoints;


    private int round;

    public Match(Player player1, int points1, Player player2, int points2, int round) {
        if (points1 == points2) {
            tie = false;
        } else {
            tie = true;
            if (points1 > points2) {
                winner = player1;
                looser = player2;
                winnerPoints = points1;
                looserPoints = points2;
            } else {
                winner = player2;
                looser = player1;
                winnerPoints = points2;
                looserPoints = points1;
            }
        }
        this.round = round;

    }

    public Boolean getTie() {
        return tie;
    }

    public void setTie(Boolean tie) {
        this.tie = tie;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public Player getLooser() {
        return looser;
    }

    public void setLooser(Player looser) {
        this.looser = looser;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getWinnerPoints() {
        return winnerPoints;
    }

    public void setWinnerPoints(int winnerPoints) {
        this.winnerPoints = winnerPoints;
    }

    public int getLooserPoints() {
        return looserPoints;
    }

    public void setLooserPoints(int looserPoints) {
        this.looserPoints = looserPoints;
    }
}
