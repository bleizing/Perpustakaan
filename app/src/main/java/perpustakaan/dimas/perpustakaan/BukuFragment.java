package perpustakaan.dimas.perpustakaan;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BukuFragment extends Fragment {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_buku, container, false);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle args = getArguments();
        Buku buku = args.getParcelable("Buku");

        TextView kode = (TextView) getActivity().findViewById(R.id.kode);
        TextView kategori = (TextView) getActivity().findViewById(R.id.kategori);
        TextView judul = (TextView) getActivity().findViewById(R.id.judul);

        kode.setText("Kode : " + buku.getKode());
        kategori.setText("Kateogri : " + buku.getKategori().getTipe());
        judul.setText("Judul : " + buku.getJudul());
    }
}
