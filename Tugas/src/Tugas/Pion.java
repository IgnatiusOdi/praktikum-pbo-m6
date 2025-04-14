package Tugas;

public class Pion extends Benda {
    boolean buff;
    int jarak, status; //0 no buff, 1 shield
    public Pion(String nama, int pos, int warna, int status) {
        super(nama, pos, warna);
        this.buff = false;
        this.jarak = 32;
        this.status = status;
    }

    public boolean isBuff() {
        return buff;
    }

    public void setBuff(boolean buff) {
        this.buff = buff;
    }

    public int getJarak() {
        return jarak;
    }

    public void setJarak(int jarak) {
        this.jarak = jarak;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void reset() {
        setPos(-1);
        setJarak(32);
        setStatus(0);
    }

    public void cekBuff() {
        String temp = this.nama;
        if (isBuff()) {
            this.nama = temp.charAt(0) + "$";
        } else {
            this.nama = temp.charAt(0) + "#";
        }
    }
}
