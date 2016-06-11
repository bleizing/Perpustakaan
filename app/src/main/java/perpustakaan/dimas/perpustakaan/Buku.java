package perpustakaan.dimas.perpustakaan;

/**
 * Created by User on 04/06/2016.
 */
public class Buku {

    private String kode;
    private String judul;
    private Kategori kategori;

    public Buku(String kode, String judul, Kategori kategori) {
        this.kode = kode;
        this.judul = judul;
        this.kategori = kategori;
    }

    public String getKode() {
        return kode;
    }

    public String getJudul() {
        return judul;
    }

    public Kategori getKategori() {
        return kategori;
    }


}
