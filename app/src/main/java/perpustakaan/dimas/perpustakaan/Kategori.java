package perpustakaan.dimas.perpustakaan;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by User on 04/06/2016.
 */
public class Kategori implements Parcelable {
    private String tipe;
    private ArrayList<Buku> list = new ArrayList<>();

    public Kategori(String tipe) {
        this.tipe = tipe;
    }

    public Kategori(Parcel in) {
        tipe = in.readString();
    }

    public String getTipe() {
        return tipe;
    }

    public ArrayList<Buku> getBukuArrayList() {
        return list;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(getTipe());
        dest.writeParcelableArray(list.toArray(new Kategori[0]), flags);
    }

    public static final Parcelable.Creator<Kategori> CREATOR = new Parcelable.Creator<Kategori>() {
        public Kategori createFromParcel(Parcel in) {
            return new Kategori(in);
        }

        public Kategori[] newArray(int size) {
            return new Kategori[size];
        }
    };
}