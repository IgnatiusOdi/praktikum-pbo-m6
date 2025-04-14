package Tugas;

public abstract class Benda {
    protected String nama;
    protected int pos, warna;

    public Benda(String nama, int pos, int warna) {
        this.nama = nama;
        this.pos = pos;
        this.warna = warna;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public int getWarna() {
        return warna;
    }

    public void setWarna(int warna) {
        this.warna = warna;
    }
}
