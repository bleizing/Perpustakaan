package perpustakaan.dimas.perpustakaan;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by User on 04/06/2016.
 */
public class Buku implements Parcelable {

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


    public Buku(Parcel in) {
        kode = in.readString();
        judul = in.readString();
        kategori = in.readParcelable(null);
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(kode);
        dest.writeString(judul);
        dest.writeParcelable(kategori, flags);
    }

    public static final Parcelable.Creator<Buku> CREATOR = new Parcelable.Creator<Buku>() {
        public Buku createFromParcel(Parcel in) {
            return new Buku(in);
        }

        public Buku[] newArray(int size) {
            return new Buku[size];
        }
    };
}
