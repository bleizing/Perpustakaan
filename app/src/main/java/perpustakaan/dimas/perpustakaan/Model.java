package perpustakaan.dimas.perpustakaan;

import java.util.ArrayList;

/**
 * Created by Bleizing on 6/15/2016.
 */
public class Model {

    private static ArrayList<Kategori> kategoriArrayList = new ArrayList<>();

    public static void addKategoriArrayList(Kategori kat) {
        kategoriArrayList.add(kat);
    }

    public static ArrayList<Kategori> getKategoriArrayList() {
        return new ArrayList<>(kategoriArrayList);
    }

}