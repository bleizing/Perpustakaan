package perpustakaan.dimas.perpustakaan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Bleizing on 6/11/2016.
 */
public class BukuAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Buku> bukuArray;
    private KategoriFragment fragment;

    public BukuAdapter(KategoriFragment fragment, ArrayList<Buku> bukuArray, Context context) {
        this.fragment = fragment;
        this.context = context;
        this.bukuArray = bukuArray;
    }

    @Override
    public int getCount() {
        return bukuArray.size();
    }

    @Override
    public Object getItem(int position) {
        return bukuArray.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.buku_layout, parent, false);
        }

        final Buku buku = (Buku) getItem(position);
        TextView kode = (TextView) convertView.findViewById(R.id.kode);
        TextView judul = (TextView) convertView.findViewById(R.id.judul);
        kode.setText(buku.getKode());
        judul.setText(buku.getJudul());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.bukuDiKlik(buku);
            }
        });

        return convertView;
    }
    public ArrayList<Buku> getBukuArray() {
        return bukuArray;
    }
}
