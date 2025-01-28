package objects;

import java.io.Serializable;

public class Player implements Serializable {
    private String name;
    private int points;
    private int pointBalance;

    public Player(String name){
        this.name = name;
        this.points = 0;
        this.pointBalance = 0;
    }

    public String getName() {
        return name;
    }

    public void win(int points){
        this.points += 2;
        this.pointBalance += points;
    }

    public void tie(int points){
        this.points += 1;
        this.pointBalance += points;
    }

    public void lose(int points){
        this.pointBalance += points;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPointBalance() {
        return pointBalance;
    }

    public void setPointBalance(int pointBalance) {
        this.pointBalance = pointBalance;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public boolean equals(Object obj){
        Player objPlayer = (Player) obj;
        return this.getName().equals(objPlayer.getName());
    }
}
