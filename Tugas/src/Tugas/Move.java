package Tugas;

import java.util.ArrayList;

public interface Move {
    int move(int roll, String[] map, ArrayList<Player> player, ArrayList<Banana> banana, int turn);
    int botmove(int roll, String[] map, ArrayList<Player> player, ArrayList<Banana> banana, int turn);
}
