package perpustakaan.dimas.perpustakaan;

import java.util.ArrayList;

/**
 * Created by User on 04/06/2016.
 */
public class Kategori {
    private String tipe;
    private ArrayList<Buku> list = new ArrayList<>();

    public Kategori(String tipe) {
        this.tipe = tipe;
    }

    public String getTipe() {
        return tipe;
    }

    public void simpanBuku(Buku b) {
        list.add(b);
    }
}