package Materi;

public class Player extends Benda implements Skill,Move {
    private int level,health;
    public Player(int x, int y) {
        super("P", x, y, 0);
        this.level = 1;
        this.health = 3;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    @Override
    public void move(String input) {
        if (input.equals("w")) {
            y--;
        } else if (input.equals("s")) {
            y++;
        } else if (input.equals("a")) {
            x--;
        } else if (input.equals("d")) {
            x++;
        }
    }

    @Override
    public void skill() {

    }
}
