package perpustakaan.dimas.perpustakaan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by User on 04/06/2016.
 */
public class KategoriAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Kategori> kategoriArray;

    public KategoriAdapter(ArrayList<Kategori> kategoriArray, Context context) {
        this.context = context;
        this.kategoriArray = kategoriArray;
    }

    @Override
    public int getCount() {
        return kategoriArray.size();
    }

    @Override
    public Object getItem(int position) {
        return kategoriArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.kategori_layout, parent, false);
        }

        Kategori kategori = (Kategori) getItem(position);
        TextView tipe = (TextView) convertView.findViewById(R.id.tipe);
        tipe.setText(kategori.getTipe());

        return convertView;
    }


    public ArrayList<Kategori> getKategoriArray() {
        return kategoriArray;
    }
}
