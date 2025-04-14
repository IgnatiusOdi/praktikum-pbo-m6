package Materi;

public class Ikan extends Benda implements Skill, Move{
    protected int counter, persentaseSkill, counterJalan;
    public Ikan(String simbol, int x, int y, int score, int persentaseSkill, int counterJalan) {
        super(simbol, x, y, score);
        this.counter = 0;
        this.persentaseSkill = persentaseSkill;
        this.counterJalan = counterJalan;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getPersentaseSkill() {
        return persentaseSkill;
    }

    public void setPersentaseSkill(int persentaseSkill) {
        this.persentaseSkill = persentaseSkill;
    }

    public int getCounterJalan() {
        return counterJalan;
    }

    public void setCounterJalan(int counterJalan) {
        this.counterJalan = counterJalan;
    }

    @Override
    public void move(String input) {

    }

    @Override
    public void skill() {

    }
}
