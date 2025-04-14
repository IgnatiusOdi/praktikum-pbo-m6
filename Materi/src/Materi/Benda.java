package Materi;

public abstract class Benda {
    protected String simbol;
    protected int x,y,score;

    public Benda(String simbol, int x, int y, int score) {
        this.simbol = simbol;
        this.x = x;
        this.y = y;
        this.score = score;
    }

    public String getSimbol() {
        return simbol;
    }

    public void setSimbol(String simbol) {
        this.simbol = simbol;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
