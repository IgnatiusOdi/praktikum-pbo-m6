package Materi;

import java.util.*;

public class Main {

    public static int randomX() {
        return new Random().nextInt(11)+1;
    }

    public static int randomY() {
        return new Random().nextInt(10)+1;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

	    String[][] map = new String[12][13];
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 13; j++) {
                if (i==0 || i==11 || j==0 || j==12) {
                    map[i][j] = "*  ";
                } else {
                    map[i][j] = "   ";
                }
            }
        }

        Player p = new Player(1,1);
        map[1][1] = p.getSimbol();

        ArrayList<Ikan> ikan = new ArrayList<>();

        while (ikan.size() < 10) {
            int x = randomX();
            int y = randomY();
            if (map[y][x].equals("   ")) {
                if (ikan.size() < 3) {
                    ikan.add(new Small(x,y));
                    map[y][x] = "S  ";
                } else if (ikan.size() < 6) {
                    ikan.add(new Medium(x,y));
                    map[y][x] = "M  ";
                } else {
                    ikan.add(new Large(x,y));
                    map[y][x] = "L  ";
                }
            }
        }

        do{
            for (int i = -2; i < 13; i++) {
                if (i >= 1 && i < 12){
                    System.out.print(i+"  ");
                } else if (i==0) {
                    System.out.print("   ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
            for (int i = 0; i < 12; i++) {
                if (i == 0) {
                    System.out.print("    ");
                } else {
                    if (i/10 > 0) {
                        System.out.print(i+"| ");
                    } else {
                        System.out.print(i+" | ");
                    }
                }
                for (int j = 0; j < 13; j++) {
                    if (i==p.getY() && j==p.getX()) {
                        System.out.print(p.getSimbol()+"  ");
                    } else {
                        System.out.print(map[i][j]);
                    }
                }
                System.out.println();
            }
            System.out.println("===MENU===");
            System.out.println("Score : "+p.getScore());
            System.out.println("Player Level : "+p.getLevel());
            System.out.println("Player Health : "+p.getHealth()+"HP");
            System.out.println("1. Skill");
            System.out.println("2. List Ikan");
            System.out.println("3. Cheat");
            System.out.println("4. Surrender");
            System.out.print(">> ");
            String input = scan.nextLine();
            if (input.equals("4")) {
                System.out.println("SCORE AKHIR PLAYER = "+p.getScore());
                break;
            } else if (input.equals("1")) {

            } else if (input.equals("2")) {
                for (Ikan i : ikan) {
                    System.out.print(ikan.indexOf(i)+1+". ");
                    if (i instanceof Small) {
                        System.out.print("Ikan Small - ");
                    } else if (i instanceof Medium) {
                        System.out.print("Ikan Medium - ");
                    } else {
                        System.out.print("Ikan Large - ");
                    }
                    System.out.println("("+i.getX()+","+i.getY()+")");
                }
            } else if (input.equals("3")) {
                if (p.getLevel() < 3) {
                    System.out.println("Successfully added 1 level to player");
                    p.setLevel(p.getLevel()+1);
                } else {
                    System.out.println("Player level is already Maxed");
                }
            } else if (input.equals("w") || input.equals("a") || input.equals("s") || input.equals("d")) {
                if (input.equals("w")){
                    if (map[p.getY()-1][p.getX()].equals("   ")) {
                        p.move(input);
                        for (Ikan i : ikan) {
                            i.setCounter(i.getCounter()+1);
                            if (i instanceof Small) {
                                if (i.getCounter() == i.getCounterJalan()) {
                                    int x = rand.nextInt(2);
                                    if (x == 0) {
                                        x = -1;
                                    }
                                    if (map[i.getY()][i.getX()+x].equals("   ")) {
                                        i.setX(i.getX()+x);
                                    }
                                }
                            }
                        }
                    } else {
                        p.move(input);
                        for (Ikan i : ikan) {
                            if (i.getX()==p.getX() && i.getY()==p.getY()) {
                                if (i instanceof Small) {
                                    if (p.getLevel() >= 1) {
                                        p.setScore(p.getScore()+i.getScore());
                                    }
                                } else if (i instanceof Medium) {
                                    if (p.getLevel() >= 2) {
                                        p.setScore(p.getScore()+i.getScore());
                                    } else {
                                        p.setHealth(p.getHealth()-1);
                                    }
                                } else if (i instanceof Large) {
                                    if (p.getLevel() == 3) {
                                        p.setScore(p.getScore()+i.getScore());
                                    } else {
                                        p.setHealth(p.getHealth()-1);
                                    }
                                }
                                break;
                            }
                        }
                    }
                } else if (input.equals("s")) {
                    if (map[p.getY() + 1][p.getX()].equals("   ")) {
                        p.move(input);
                        for (Ikan i : ikan) {
                            i.setCounter(i.getCounter() + 1);
                            if (i instanceof Small) {
                                if (i.getCounter() == i.getCounterJalan()) {
                                    int x = rand.nextInt(2);
                                    if (x == 0) {
                                        x = -1;
                                    }
                                    if (map[i.getY()][i.getX() + x].equals("   ")) {
                                        i.setX(i.getX() + x);
                                    }
                                }
                            }
                        }
                    } else {
                        p.move(input);
                        for (Ikan i : ikan) {
                            if (i.getX() == p.getX() && i.getY() == p.getY()) {
                                if (i instanceof Small) {
                                    if (p.getLevel() >= 1) {
                                        p.setScore(p.getScore() + i.getScore());
                                    }
                                } else if (i instanceof Medium) {
                                    if (p.getLevel() >= 2) {
                                        p.setScore(p.getScore() + i.getScore());
                                    } else {
                                        p.setHealth(p.getHealth() - 1);
                                    }
                                } else if (i instanceof Large) {
                                    if (p.getLevel() == 3) {
                                        p.setScore(p.getScore() + i.getScore());
                                    } else {
                                        p.setHealth(p.getHealth() - 1);
                                    }
                                }
                                break;
                            }
                        }
                    }
                } else if (input.equals("a")) {
                    if (map[p.getY()][p.getX()-1].equals("   ")) {
                        p.move(input);
                        for (Ikan i : ikan) {
                            i.setCounter(i.getCounter()+1);
                            if (i instanceof Small) {
                                if (i.getCounter() == i.getCounterJalan()) {
                                    int x = rand.nextInt(2);
                                    if (x == 0) {
                                        x = -1;
                                    }
                                    if (map[i.getY()][i.getX()+x].equals("   ")) {
                                        i.setX(i.getX()+x);
                                    }
                                }
                            }
                        }
                    } else {
                        p.move(input);
                        for (Ikan i : ikan) {
                            if (i.getX()==p.getX() && i.getY()==p.getY()) {
                                if (i instanceof Small) {
                                    if (p.getLevel() >= 1) {
                                        p.setScore(p.getScore()+i.getScore());
                                    }
                                } else if (i instanceof Medium) {
                                    if (p.getLevel() >= 2) {
                                        p.setScore(p.getScore()+i.getScore());
                                    } else {
                                        p.setHealth(p.getHealth()-1);
                                    }
                                } else if (i instanceof Large) {
                                    if (p.getLevel() == 3) {
                                        p.setScore(p.getScore()+i.getScore());
                                    } else {
                                        p.setHealth(p.getHealth()-1);
                                    }
                                }
                                break;
                            }
                        }
                    }
                } else {
                    if (map[p.getY()][p.getX()-1].equals("   ")) {
                        p.move(input);
                        for (Ikan i : ikan) {
                            i.setCounter(i.getCounter()+1);
                            if (i instanceof Small) {
                                if (i.getCounter() == i.getCounterJalan()) {
                                    int x = rand.nextInt(2);
                                    if (x == 0) {
                                        x = -1;
                                    }
                                    if (map[i.getY()][i.getX()+x].equals("   ")) {
                                        i.setX(i.getX()+x);
                                    }
                                }
                            }
                        }
                    } else {
                        p.move(input);
                        for (Ikan i : ikan) {
                            if (i.getX()==p.getX() && i.getY()==p.getY()) {
                                if (i instanceof Small) {
                                    if (p.getLevel() >= 1) {
                                        p.setScore(p.getScore()+i.getScore());
                                    }
                                } else if (i instanceof Medium) {
                                    if (p.getLevel() >= 2) {
                                        p.setScore(p.getScore()+i.getScore());
                                    } else {
                                        p.setHealth(p.getHealth()-1);
                                    }
                                } else if (i instanceof Large) {
                                    if (p.getLevel() == 3) {
                                        p.setScore(p.getScore()+i.getScore());
                                    } else {
                                        p.setHealth(p.getHealth()-1);
                                    }
                                }
                                break;
                            }
                        }
                    }
                }
            }

            if (p.getHealth() == 0) {
                System.out.println("SCORE AKHIR PLAYER = "+p.getScore());
                break;
            }
        }while(true);
    }
}
