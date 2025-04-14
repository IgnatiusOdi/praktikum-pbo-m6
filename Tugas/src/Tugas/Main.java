package Tugas;

import java.util.*;

public class Main {
    public static int randomDadu() {
        return new Random().nextInt(6)+1;
    }

    public void checkMap(String[] map) {

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);
        Random rand = new Random();
        Color c = new Color();
//        for (int i = 0; i < 6; i++) {
//            c.setColor(i);
//            System.out.println("Text Color Code : "+i);
//            c.resetColor();
//            c.setBgColor(i);
//            System.out.print("BG Color Code : "+i);
//            c.resetColor();
//            System.out.println();
//        }

        //HISTORY
        ArrayList<String> history = new ArrayList<>();

        //MAP
        String[] map = new String[32];

        //BANANA
        ArrayList<Banana> banana = new ArrayList<>();

        do{
            //MAIN MENU
            System.out.println("===Main Menu LUDO===");
            System.out.println("1. Play Game");
            System.out.println("2. History Game");
            System.out.println("3. Exit");
            System.out.print(">> ");
            int menu = scanint.nextInt();
            if (menu == 1) {
                //PLAY
                ArrayList<Player> player = new ArrayList<>();
                //HOW MANY PLAYER
                int jumlahplayer;
                do {
                    System.out.print("Jumlah Player yang bermain (1-4): ");
                    jumlahplayer = scanint.nextInt();
                } while(jumlahplayer < 1 || jumlahplayer > 4);
                //PLAYER NAME
                for (int i = 0; i < jumlahplayer; i++) {
                    System.out.print("Masukkan nama Player "+(i+1)+" : ");
                    String nama = scan.nextLine();
                    if (i == 0) {
                        player.add(new Player(nama,0,0));
                    } else if (i == 1) {
                        player.add(new Player(nama,8,1));
                    } else if (i == 2) {
                        player.add(new Player(nama,16,2));
                    } else {
                        player.add(new Player(nama,24,3));
                    }
                }
                //FILL EMPTY SLOT WITH BOT
                if (player.size() < 4) {
                    for (int i = player.size()+1; i <= 4; i++) {
                        String nama = "Player "+i+" (BOT)";
                        if (i == 2) {
                            player.add(new Bot(nama,8, 1));
                        } else if (i == 3) {
                            player.add(new Bot(nama,16, 2));
                        } else if (i == 4) {
                            player.add(new Bot(nama,24, 3));
                        }
                    }
                }

                //WHICH TURN
                int turn;
                do {
                    ArrayList<Integer> urutan = new ArrayList<>();
                    System.out.println("==Highest Roll==");
                    while (urutan.size() < 4) {
                        urutan.add(randomDadu());
                    }
                    System.out.println("Player 1 : "+urutan.get(0));
                    System.out.println("Player 2 : "+urutan.get(1));
                    System.out.println("Player 3 : "+urutan.get(2));
                    System.out.println("Player 4 : "+urutan.get(3));

                    int max = 0;
                    int index = -1;
                    for (int i = 0; i < urutan.size(); i++) {
                        if (max < urutan.get(i)) {
                            max = urutan.get(i);
                            index = i;
                        }
                    }
                    boolean ada = false;
                    for (int i = 0; i < 4; i++) {
                        if (max == urutan.get(i) && index != i) {
                            ada = true;
                            break;
                        }
                    }

                    if (ada) {
                        System.out.println("≡≡≡ Re Roll! ≡≡≡");
                    } else {
                        turn = index;
                        System.out.println("Player who goes first : Player " + (turn+1));
                        break;
                    }
                } while(true);

                do {
                    Player active = player.get(turn);
                    //EMPTY MAP
                    for (int i = 0; i < 32; i++) {
                        map[i] = "  ";
                    }
                    //FILL BANANA
                    for (int i = 0; i < banana.size(); i++) {
                        map[banana.get(i).getPos()] = banana.get(i).getNama();
                    }
                    //FILL PION
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < player.get(i).getPionSize(); j++) {
                            Pion p = player.get(i).getPion(j);
                            if (p.getPos() != -1) {
                                map[p.getPos()] = p.getNama();
                            }
                        }
                    }
                    //PRINT MAP
                    for (int i = 0; i < 4; i++) {
                        if (i == 0) {
                            //BASE 1
                            for (int j = 0; j < 8; j++) {
                                if (j == 0) {
                                    c.setColor(0);
                                }
                                System.out.print("[");
                                c.resetColor();
                                if (map[j].equals("  ")) {
                                    //KOSONG
                                    System.out.print(map[j]);
                                } else if (map[j].equals("BA")) {
                                    //BANANA
                                    for (Banana b : banana) {
                                        if (b.getPos() == j) {
                                            if (b.getWarna() == 0) {
                                                c.setColor(0);
                                            } else if (b.getWarna() == 1) {
                                                c.setColor(1);
                                            } else if (b.getWarna() == 2) {
                                                c.setColor(2);
                                            } else {
                                                c.setColor(3);
                                            }
                                            System.out.print("BA");
                                            c.resetColor();
                                            break;
                                        }
                                    }
                                } else {
                                    //PLAYER
                                    for (int k = 0; k < 4; k++) {
                                        for (int l = 0; l < player.get(k).getPionSize(); l++) {
                                            Pion p = player.get(k).getPion(l);
                                            if (p.getPos() == j) {
                                                if (k == 0) {
                                                    c.setColor(0);
                                                } else if (k == 1) {
                                                    c.setColor(1);
                                                } else if (k == 2) {
                                                    c.setColor(2);
                                                } else {
                                                    c.setColor(3);
                                                }
                                                System.out.print(p.getNama());
                                                c.resetColor();
                                            }
                                        }
                                    }
                                }
                                if (j == 0) {
                                    c.setColor(0);
                                }
                                System.out.print("]");
                                c.resetColor();
                            }
                        }
                        else if (i == 1) {
                            //BASE 2
                            for (int j = 15; j >= 8; j--) {
                                if (j == 8) {
                                    c.setColor(1);
                                }
                                System.out.print("[");
                                c.resetColor();
                                if (map[j].equals("  ")) {
                                    //KOSONG
                                    System.out.print(map[j]);
                                } else if (map[j].equals("BA")) {
                                    //BANANA
                                    for (Banana b : banana) {
                                        if (b.getPos() == j) {
                                            if (b.getWarna() == 0) {
                                                c.setColor(0);
                                            } else if (b.getWarna() == 1) {
                                                c.setColor(1);
                                            } else if (b.getWarna() == 2) {
                                                c.setColor(2);
                                            } else {
                                                c.setColor(3);
                                            }
                                            System.out.print("BA");
                                            c.resetColor();
                                            break;
                                        }
                                    }
                                } else {
                                    //PLAYER
                                    for (int k = 0; k < 4; k++) {
                                        for (int l = 0; l < player.get(k).getPionSize(); l++) {
                                            Pion p = player.get(k).getPion(l);
                                            if (p.getPos() == j) {
                                                if (k == 0) {
                                                    c.setColor(0);
                                                } else if (k == 1) {
                                                    c.setColor(1);
                                                } else if (k == 2) {
                                                    c.setColor(2);
                                                } else {
                                                    c.setColor(3);
                                                }
                                                System.out.print(p.getNama());
                                                c.resetColor();
                                            }
                                        }
                                    }
                                }
                                if (j == 8) {
                                    c.setColor(1);
                                }
                                System.out.print("]");
                                c.resetColor();
                            }
                        }
                        else if (i == 2) {
                            //BASE 3
                            for (int j = 16; j < 24; j++) {
                                if (j == 16) {
                                    c.setColor(2);
                                }
                                System.out.print("[");
                                c.resetColor();
                                if (map[j].equals("  ")) {
                                    //KOSONG
                                    System.out.print(map[j]);
                                } else if (map[j].equals("BA")) {
                                    //BANANA
                                    for (Banana b : banana) {
                                        if (b.getPos() == j) {
                                            if (b.getWarna() == 0) {
                                                c.setColor(0);
                                            } else if (b.getWarna() == 1) {
                                                c.setColor(1);
                                            } else if (b.getWarna() == 2) {
                                                c.setColor(2);
                                            } else {
                                                c.setColor(3);
                                            }
                                            System.out.print("BA");
                                            c.resetColor();
                                            break;
                                        }
                                    }
                                } else {
                                    //PLAYER
                                    for (int k = 0; k < 4; k++) {
                                        for (int l = 0; l < player.get(k).getPionSize(); l++) {
                                            Pion p = player.get(k).getPion(l);
                                            if (p.getPos() == j) {
                                                if (k == 0) {
                                                    c.setColor(0);
                                                } else if (k == 1) {
                                                    c.setColor(1);
                                                } else if (k == 2) {
                                                    c.setColor(2);
                                                } else {
                                                    c.setColor(3);
                                                }
                                                System.out.print(p.getNama());
                                                c.resetColor();
                                            }
                                        }
                                    }
                                }
                                if (j == 16) {
                                    c.setColor(2);
                                }
                                System.out.print("]");
                                c.resetColor();
                            }
                        }
                        else {
                            //BASE 4
                            for (int j = 31; j >= 24; j--) {
                                if (j == 24) {
                                    c.setColor(3);
                                }
                                System.out.print("[");
                                c.resetColor();
                                if (map[j].equals("  ")) {
                                    //KOSONG
                                    System.out.print(map[j]);
                                } else if (map[j].equals("BA")) {
                                    //BANANA
                                    for (Banana b : banana) {
                                        if (b.getPos() == j) {
                                            if (b.getWarna() == 0) {
                                                c.setColor(0);
                                            } else if (b.getWarna() == 1) {
                                                c.setColor(1);
                                            } else if (b.getWarna() == 2) {
                                                c.setColor(2);
                                            } else {
                                                c.setColor(3);
                                            }
                                            System.out.print("BA");
                                            c.resetColor();
                                            break;
                                        }
                                    }
                                } else {
                                    //PLAYER
                                    for (int k = 0; k < 4; k++) {
                                        for (int l = 0; l < player.get(k).getPionSize(); l++) {
                                            Pion p = player.get(k).getPion(l);
                                            if (p.getPos() == j) {
                                                if (k == 0) {
                                                    c.setColor(0);
                                                } else if (k == 1) {
                                                    c.setColor(1);
                                                } else if (k == 2) {
                                                    c.setColor(2);
                                                } else {
                                                    c.setColor(3);
                                                }
                                                System.out.print(p.getNama());
                                                c.resetColor();
                                            }
                                        }
                                    }
                                }
                                if (j == 24) {
                                    c.setColor(3);
                                }
                                System.out.print("]");
                                c.resetColor();
                            }
                        }
                        System.out.println();
                        System.out.println();
                    }

                    if (active instanceof Bot) {
                        //BOT
                        System.out.println("Turn : " + active.getNama());
                    } else {
                        //PLAYER
                        System.out.println("Turn : Player " + (turn+1));
                    }
                    for (Player p : player) {
                        if (p instanceof Bot) {
                            System.out.println(p.getNama() + ": " + p.getScore());
                        } else {
                            System.out.println("Player " + (player.indexOf(p)+1) + " : " + p.getScore());
                        }
                    }
                    if (active instanceof Bot) {
                        //BOT MOVE
                        int roll = new Random().nextInt(2);
                        if (roll == 0) {
                            //ROLL DICE
                            System.out.println(active.getNama() + " Action : Roll Dice");
                            roll = randomDadu();
                            System.out.print("Bot just roll " + roll + " to move");
                            if (active.botmove(roll,map,player,banana,turn) == 1) {
                                turn++;
                            }
                            System.out.println();
                        } else {
                            roll = new Random().nextInt(3);
                            if (roll == 0) {
                                //BANANA
                                System.out.println("Bot Action : Power Up (Banana)");
                                ArrayList<Integer> temp = new ArrayList<>();
                                for (Pion p : active.pion) {
                                    if (p.getPos() != -1) {
                                        temp.add(active.pion.indexOf(p));
                                    }
                                }
                                if (temp.size() > 0) {
                                    int pilihan = new Random().nextInt(temp.size());
                                    Pion p = active.getPion(temp.get(pilihan));
                                    banana.add(new Banana(p.getPos()-1,turn));
                                    System.out.println(active.getNama() + " just lay a trap!");
                                    turn++;
                                } else {
                                    System.out.println("Tidak ada pion yang tersedia di map");
                                }
                            } else if (roll == 1) {
                                //SHIELD
                                System.out.println("Bot Action : Power Up (Shield)");
                                ArrayList<Integer> temp = new ArrayList<>();
                                for (Pion p : active.pion) {
                                    if (p.getPos() != -1) {
                                        temp.add(active.pion.indexOf(p));
                                    }
                                }
                                if (temp.size() > 0) {
                                    int pilihan = new Random().nextInt(temp.size());
                                    Pion p = active.getPion(temp.get(pilihan));
                                    p.setBuff(true);
                                    p.cekBuff();
                                    System.out.println(active.getNama() + " just used a shield on " + p.getNama() + "!");
                                    turn++;
                                } else {
                                    System.out.println("Tidak ada pion yang tersedia di map");
                                }
                            } else {
                                //BOOST
                                roll = randomDadu();
                                System.out.println("Bot Action : Power Up (Boost)");
                                System.out.println(active.getNama() + " just randomed a dice " + roll + " * 2 = " + roll*2);
                                roll *= 2;
                                System.out.print(active.getNama());
                                if (active.botmove(roll,map,player,banana,turn) == 1) {
                                    turn++;
                                }
                                System.out.println(roll + " tiles ahead");
                            }
                        }
                    } else {
                        //PLAYER MOVE
                        System.out.println("====Play Menu====");
                        System.out.println("1. Roll Dice");
                        System.out.println("2. Power Up");
                        System.out.println("3. Input Roll (CHEAT)");
                        System.out.print(">> ");
                        String input = scan.nextLine();
                        if (input.equals("1")) {
                            //ROLL DICE
                            int roll = randomDadu();
                            System.out.println("Player roll dadu "+roll);
                            if (!active.adaDiluarBase() && roll != 6) {
                                System.out.println("Tidak ada pion yang tersedia di map");
                                turn++;
                            } else {
                                if (active.move(roll,map,player,banana,turn) == 1) {
                                    turn++;
                                }
                            }
                        } else if (input.equals("2")) {
                            //POWER UP
                            System.out.println("==Power Up==");
                            System.out.println("1. Banana");
                            System.out.println("2. Shield");
                            System.out.println("3. 2x Boost");
                            System.out.print(">> ");
                            int powerup = scanint.nextInt();
                            if (powerup == 1) {
                                //BANANA
                                if (active.adaDiluarBase()) {
                                    System.out.println("List of Pawns");
                                    active.printPion();
                                    int inputan;
                                    while (active.adaDiluarBase()) {
                                        do {
                                            System.out.print(">> ");
                                            inputan = scanint.nextInt();
                                            inputan--;
                                        } while (inputan < 0 || inputan > active.getPionSize()-1);
                                        Pion p = active.getPion(inputan);
                                        if (p.getPos() == -1) {
                                            System.out.println("Invalid Input! " + p.getNama() + " is still in base!");
                                        } else {
                                            System.out.println("Player " + (turn+1) + " just successfully lay a trap");
                                            banana.add(new Banana(p.getPos()-1,turn));
                                            break;
                                        }
                                    }
                                    turn++;
                                } else {
                                    System.out.println("Tidak ada pion yang tersedia di map");
                                }
                            } else if (powerup == 2) {
                                //SHIELD
                                if (active.adaDiluarBase()) {
                                    System.out.println("List of Pawns");
                                    active.printPion();
                                    int inputan;
                                    while (active.adaDiluarBase()) {
                                        do {
                                            System.out.print(">> ");
                                            inputan = scanint.nextInt();
                                            inputan--;
                                        } while (inputan < 0 || inputan > active.getPionSize()-1);

                                        Pion p = active.getPion(inputan);
                                        if (p.getPos() == -1) {
                                            System.out.println("Invalid Input! " + p.getNama() + " is still in base!");
                                        } else {
                                            System.out.println("Player " + (turn+1) + " just used a shield on " + p.getNama());
                                            p.setBuff(true);
                                            p.cekBuff();
                                            break;
                                        }
                                    }
                                    turn++;
                                } else {
                                    System.out.println("Tidak ada pion yang tersedia di map");
                                }
                            } else if (powerup == 3) {
                                //BOOST
                                if (active.adaDiluarBase()) {
                                    int randoman = randomDadu();
                                    System.out.println("Player " + (player.indexOf(active)+1) + " rolls a " + randoman + " * 2 = " + randoman*2);
                                    randoman *= 2;
                                    if (active.move(randoman,map,player,banana,turn) == 1) {
                                        if (randoman / 2 != 6) {
                                            turn++;
                                        }
                                    }
                                } else {
                                    System.out.println("Tidak ada pion yang tersedia di map");
                                }
                            }
                        } else if (input.equals("3")) {
                            System.out.print("Pilih angka : ");
                            int angka;
                            do {
                                angka = scanint.nextInt();
                            } while (angka < 1 || angka > 12);

                            if (!active.adaDiluarBase() && angka != 6) {
                                System.out.println("Tidak ada pion yang tersedia di map");
                                turn++;
                            } else {
                                if (active.move(angka,map,player,banana,turn) == 1) {
                                    turn++;
                                }
                            }
                        } else if (input.equals("4")) {
                            //CEK LIST STATUS PION
                            for (int i = 0; i < 4; i++) {
                                System.out.println(player.get(i).getNama());
                                player.get(i).printPionPosJarak();
                            }
                        } else if (input.equals("game over")) {
                            //GAME OVER
                            String winner = active.getNama();
                            String p1 = player.get(0).getNama();
                            String p2 = player.get(1).getNama();
                            String p3 = player.get(2).getNama();
                            String p4 = player.get(3).getNama();
                            history.add(p1+"-"+p2+"-"+p3+"-"+p4+" | Winner : "+winner);
                            System.out.println("Player " + (player.indexOf(active)+1) + " win the game");
                            break;
                        }
                    }

                    if (turn > 3) {
                        turn = 0;
                    }

                    if (active.getPionSize() == 0) {
                        String winner = active.getNama();
                        String p1 = player.get(0).getNama();
                        String p2 = player.get(1).getNama();
                        String p3 = player.get(2).getNama();
                        String p4 = player.get(3).getNama();
                        history.add(p1+"-"+p2+"-"+p3+"-"+p4+" | Winner : "+winner);
                        System.out.println("Player " + (player.indexOf(active)+1) + " win the game");
                        break;
                    }
                } while(true);
            } else if (menu == 2) {
                //HISTORY
                int input;
                do {
                    System.out.println("====History Game====");
                    if (history.size() > 0) {
                        for (String h : history) {
                            System.out.println(history.indexOf(h)+1+". "+h);
                        }
                    } else {
                        System.out.println("TIDAK ADA HISTORY SAAT INI");
                    }
                    System.out.println("0. Exit");
                    System.out.print(">> ");
                    input = scanint.nextInt();
                } while(input != 0);
            }
            else if (menu == 3) {
                //EXIT
                break;
            }

        }while(true);
    }
}
