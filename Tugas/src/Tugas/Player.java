package Tugas;

import java.util.*;

public class Player extends Benda implements Move {
    protected ArrayList<Pion> pion = new ArrayList<>();
    protected int score;

    public Player(String nama, int pos, int warna) {
        super(nama, pos, warna);
        pion.add(new Pion("1#", pos, this.warna, 1));
        pion.add(new Pion("2#",-1, this.warna, 0));
        pion.add(new Pion("3#",-1, this.warna, 0));
        pion.add(new Pion("4#",-1, this.warna, 0));
        this.score = 0;
    }

    public int getPionSize() {
        return pion.size();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void printPion() {
        for (Pion p : pion) {
            System.out.print((pion.indexOf(p)+1)+". "+p.getNama());
            if (p.getPos() == -1) {
                System.out.println(" (Still in Base)");
            } else {
                System.out.println();
            }
        }
    }

    public void printPionPosJarak() {
        for (Pion p : pion) {
            System.out.print((pion.indexOf(p)+1)+". "+p.getNama() + " P" + p.getPos() + " J" + p.getJarak() + " S" + p.getStatus());
            if (p.getPos() == -1) {
                System.out.println(" (Still in Base)");
            } else {
                System.out.println();
            }
        }
    }

    public Pion getPion(int index) {
        return pion.get(index);
    }

    public boolean adaDiluarBase() {
        for(Pion p : pion) {
            if (p.getPos() != -1) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int move(int roll, String[] map, ArrayList<Player> player, ArrayList<Banana> banana, int turn) {
        Scanner scanint = new Scanner(System.in);
        System.out.println("Who do you want to move?");
        printPion();

        boolean loop = true;
        int pilihan;
        while (loop) {
            do {
                //1-4
                System.out.print(">> ");
                pilihan = scanint.nextInt();
                pilihan--;
            } while (pilihan < 0 || pilihan > pion.size()-1);

            Pion p = pion.get(pilihan);
            if (roll == 6) {
                if (p.getPos() == -1) {
                    //KELUARKAN PION
                    loop = false;
                    p.setPos(pos);
                    p.setStatus(1);
                    System.out.println(p.getNama() + " telah keluar dari Base");
                } else {
                    //UKUR JARAK
                    if (p.getJarak() - roll >= 0) {
                        loop = false;
                        if (p.getPos() + roll >= 32) {
                            int sisa = p.getPos()+roll-32;
                            p.setPos(sisa);
                        } else {
                            p.setPos(p.getPos() + roll);
                        }
                        System.out.println("Move "+p.getNama() + " " + roll + " tiles ahead!");
                        p.setJarak(p.getJarak() - roll);

                        //CEK POSISI YANG DITEMPATI
                        if (p.getPos() == pos) {
                            p.setStatus(p.getStatus() + 1);
                            if (p.getStatus() == 2) {
                                System.out.println(p.getNama() + " has returned to base");
                                System.out.println("Player " + (turn+1) + " got +1 score");
                                score++;
                                pion.remove(p);
                            }
                        } else {
                            if (!map[p.getPos()].equals("  ")) {
                                if (p.getPos() != 0 && p.getPos() != 8 && p.getPos() != 16 && p.getPos() != 24) {
                                    //TIDAK KOSONG DAN BUKAN BASE
                                    int ada = -1;
                                    //BANANA
                                    for (Banana b : banana) {
                                        if (p.getPos() == b.getPos()) {
                                            ada = banana.indexOf(b);
                                            System.out.println(p.getNama() + " menginjak BANANA");
                                            //CEK BUFF
                                            if (p.isBuff()) {
                                                p.setBuff(false);
                                                p.cekBuff();
                                                System.out.println("Buff " + p.getNama() + " hilang");
                                            } else {
                                                p.reset();
                                                System.out.println(p.getNama() + " back to base");
                                            }
                                            banana.remove(ada);
                                            break;
                                        }
                                    }
                                    if (ada == -1) {
                                        //OTHER PLAYER
                                        for (Player play : player) {
                                            if (turn != player.indexOf(play)) {
                                                //CEK PION MASING" PLAYER
                                                for (Pion pio : play.pion) {
                                                    if (pio.getPos() == p.getPos() && pio.getPos() != -1) {
                                                        System.out.println(p.getNama() + " bertemu Player " + (player.indexOf(play)+1));
                                                        //CEK BUFF
                                                        if (pio.isBuff()) {
                                                            pio.setBuff(false);
                                                            pio.cekBuff();
                                                            p.reset();
                                                            System.out.println("Player " + (player.indexOf(play)+1) + " " + pio.getNama() + " buff hilang");
                                                            System.out.println("Player " + (turn+1) + " " + p.getNama() + " back to base");
                                                        } else {
                                                            pio.reset();
                                                            System.out.println("Player " + (player.indexOf(play)+1) + " " + pio.getNama() + " back to base");
                                                        }
                                                        ada = 1;
                                                    }
                                                }
                                            }
                                            if (ada != -1) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Kelewatan bosque");
                        loop = false;
                    }
                }

            } else {
                //ROLL SELAIN 6
                if (p.getPos() == -1) {
                    //TIDAK BISA KARENA MASIH DI BASE
                    System.out.println("Invalid Input! " + p.getNama() + " is still in base!");
                    if (!adaDiluarBase()) {
                        loop = false;
                    }
                } else {
                    //UKUR JARAK
                    if (p.getJarak() - roll >= 0) {
                        loop = false;
                        if (p.getPos() + roll >= 32) {
                            int sisa = p.getPos()+roll-32;
                            p.setPos(sisa);
                        } else {
                            p.setPos(p.getPos() + roll);
                        }
                        System.out.println("Move "+p.getNama()+" "+roll+" tiles ahead!");
                        p.setJarak(p.getJarak() - roll);

                        if (p.getPos() == pos) {
                            p.setStatus(p.getStatus() + 1);
                            if (p.getStatus() == 2) {
                                System.out.println(p.getNama() + " has returned to base");
                                System.out.println("Player " + (turn+1) + " got +1 score");
                                score++;
                                pion.remove(p);
                            }
                        } else {
                            if (!map[p.getPos()].equals("  ")) {
                                if (p.getPos() != 0 && p.getPos() != 8 && p.getPos() != 16 && p.getPos() != 24) {
                                    //TIDAK KOSONG DAN BUKAN BASE
                                    int ada = -1;
                                    //BANANA
                                    for (Banana b : banana) {
                                        if (p.getPos() == b.getPos()) {
                                            ada = banana.indexOf(b);
                                            System.out.println(p.getNama() + " menginjak BANANA");
                                            //CEK BUFF
                                            if (p.isBuff()) {
                                                p.setBuff(false);
                                                p.cekBuff();
                                                System.out.println("Buff " + p.getNama() + " hilang");
                                            } else {
                                                p.reset();
                                                System.out.println(p.getNama() + " back to base");
                                            }
                                            banana.remove(ada);
                                            break;
                                        }
                                    }
                                    if (ada == -1) {
                                        //OTHER PLAYER
                                        for (Player play : player) {
                                            if (turn != player.indexOf(play)) {
                                                //CEK PION MASING" PLAYER
                                                for (Pion pio : play.pion) {
                                                    if (pio.getPos() == p.getPos()  && pio.getPos() != -1) {
                                                        System.out.println(p.getNama() + " bertemu Player " + (player.indexOf(play)+1));
                                                        //CEK BUFF
                                                        if (pio.isBuff()) {
                                                            pio.setBuff(false);
                                                            pio.cekBuff();
                                                            p.reset();
                                                            System.out.println("Player " + (player.indexOf(play)+1) + " " + pio.getNama() + " buff hilang");
                                                            System.out.println("Player " + (turn+1) + " " + p.getNama() + " back to base");
                                                        } else {
                                                            pio.reset();
                                                            System.out.println("Player " + (player.indexOf(play)+1) + " " + pio.getNama() + " back to base");
                                                        }
                                                        ada = 1;
                                                    }
                                                }
                                            }
                                            if (ada != -1) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Kelewatan bosque");
                        loop = false;
                    }
                }
            }
        }
        if (roll == 6) {
            //ANOTHER TURN
            return 0;
        } else {
            //CHANGE TURN
            return 1;
        }
    }

    @Override
    public int botmove(int roll, String[] map, ArrayList<Player> player, ArrayList<Banana> banana, int turn) {
        int counter = 0;
        for (Pion p : pion) {
            if (p.getPos() != -1) {
                counter++;
            }
        }
        boolean loop = true;
        while (loop) {
            int pilihan;
            if (roll == 6) {
                pilihan = new Random().nextInt(pion.size());
            } else {
                pilihan = new Random().nextInt(counter);
            }
            Pion p = pion.get(pilihan);
            System.out.print(" " + p.getNama() + " ");
            if (roll == 6) {
                if (p.getPos() == -1) {
                    //KELUARKAN PION
                    loop = false;
                    p.setPos(pos);
                    p.setStatus(1);
                    System.out.println(p.getNama() + " telah keluar dari Base");
                } else {
                    //UKUR JARAK
                    if (p.getJarak() - roll >= 0) {
                        loop = false;
                        if (p.getPos() + roll >= 32) {
                            int sisa = p.getPos()+roll-32;
                            p.setPos(sisa);
                        } else {
                            p.setPos(p.getPos() + roll);
                        }
                        p.setJarak(p.getJarak() - roll);

                        //CEK POSISI YANG DITEMPATI
                        if (p.getPos() == pos) {
                            p.setStatus(p.getStatus() + 1);
                            if (p.getStatus() == 2) {
                                System.out.println(p.getNama() + " has returned to base");
                                System.out.println("Player " + (turn+1) + " got +1 score");
                                score++;
                                pion.remove(p);
                            }
                        } else {
                            if (!map[p.getPos()].equals("  ")) {
                                if (p.getPos() != 0 && p.getPos() != 8 && p.getPos() != 16 && p.getPos() != 24) {
                                    //TIDAK KOSONG DAN BUKAN BASE
                                    int ada = -1;
                                    //BANANA
                                    for (Banana b : banana) {
                                        if (p.getPos() == b.getPos()) {
                                            ada = banana.indexOf(b);
                                            System.out.println(p.getNama() + " menginjak BANANA");
                                            //CEK BUFF
                                            if (p.isBuff()) {
                                                p.setBuff(false);
                                                p.cekBuff();
                                                System.out.println("Buff " + p.getNama() + " hilang");
                                            } else {
                                                p.reset();
                                                System.out.println(p.getNama() + " back to base");
                                            }
                                            banana.remove(ada);
                                            break;
                                        }
                                    }
                                    if (ada == -1) {
                                        //OTHER PLAYER
                                        for (Player play : player) {
                                            if (turn != player.indexOf(play)) {
                                                //CEK PION MASING" PLAYER
                                                for (Pion pio : play.pion) {
                                                    if (pio.getPos() == p.getPos() && pio.getPos() != -1) {
                                                        System.out.println(p.getNama() + " bertemu Player " + (player.indexOf(play)+1));
                                                        //CEK BUFF
                                                        if (pio.isBuff()) {
                                                            pio.setBuff(false);
                                                            pio.cekBuff();
                                                            p.reset();
                                                            System.out.println("Player " + (player.indexOf(play)+1) + " " + pio.getNama() + " buff hilang");
                                                            System.out.println("Player " + (turn+1) + " " + p.getNama() + " back to base");
                                                        } else {
                                                            pio.reset();
                                                            System.out.println("Player " + (player.indexOf(play)+1) + " " + pio.getNama() + " back to base");
                                                        }
                                                        ada = 1;
                                                    }
                                                }
                                            }
                                            if (ada != -1) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Kelewatan bosque");
                        loop = false;
                    }
                }

            } else {
                //ROLL SELAIN 6
                if (p.getPos() == -1) {
                    //TIDAK BISA KARENA MASIH DI BASE
                    System.out.println("Invalid Input! " + p.getNama() + " is still in base!");
                    if (!adaDiluarBase()) {
                        loop = false;
                    }
                } else {
                    //UKUR JARAK
                    if (p.getJarak() - roll >= 0) {
                        loop = false;
                        if (p.getPos() + roll >= 32) {
                            int sisa = p.getPos()+roll-32;
                            p.setPos(sisa);
                        } else {
                            p.setPos(p.getPos() + roll);
                        }
                        p.setJarak(p.getJarak() - roll);

                        if (p.getPos() == pos) {
                            p.setStatus(p.getStatus() + 1);
                            if (p.getStatus() == 2) {
                                System.out.println(p.getNama() + " has returned to base");
                                System.out.println("Player " + (turn+1) + " got +1 score");
                                score++;
                                pion.remove(p);
                            }
                        } else {
                            if (!map[p.getPos()].equals("  ")) {
                                if (p.getPos() != 0 && p.getPos() != 8 && p.getPos() != 16 && p.getPos() != 24) {
                                    //TIDAK KOSONG DAN BUKAN BASE
                                    int ada = -1;
                                    //BANANA
                                    for (Banana b : banana) {
                                        if (p.getPos() == b.getPos()) {
                                            ada = banana.indexOf(b);
                                            System.out.println(p.getNama() + " menginjak BANANA");
                                            //CEK BUFF
                                            if (p.isBuff()) {
                                                p.setBuff(false);
                                                p.cekBuff();
                                                System.out.println("Buff " + p.getNama() + " hilang");
                                            } else {
                                                p.reset();
                                                System.out.println(p.getNama() + " back to base");
                                            }
                                            banana.remove(ada);
                                            break;
                                        }
                                    }
                                    if (ada == -1) {
                                        //OTHER PLAYER
                                        for (Player play : player) {
                                            if (turn != player.indexOf(play)) {
                                                //CEK PION MASING" PLAYER
                                                for (Pion pio : play.pion) {
                                                    if (pio.getPos() == p.getPos()  && pio.getPos() != -1) {
                                                        System.out.println(p.getNama() + " bertemu Player " + (player.indexOf(play)+1));
                                                        //CEK BUFF
                                                        if (pio.isBuff()) {
                                                            pio.setBuff(false);
                                                            pio.cekBuff();
                                                            p.reset();
                                                            System.out.println("Player " + (player.indexOf(play)+1) + " " + pio.getNama() + " buff hilang");
                                                            System.out.println("Player " + (turn+1) + " " + p.getNama() + " back to base");
                                                        } else {
                                                            pio.reset();
                                                            System.out.println("Player " + (player.indexOf(play)+1) + " " + pio.getNama() + " back to base");
                                                        }
                                                        ada = 1;
                                                    }
                                                }
                                            }
                                            if (ada != -1) {
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    } else {
                        System.out.println("Kelewatan bosque");
                        loop = false;
                    }
                }
            }
        }

        if (roll == 6) {
            //ANOTHER TURN
            return 0;
        } else {
            //CHANGE TURN
            return 1;
        }
    }
}
