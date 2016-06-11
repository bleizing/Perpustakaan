package perpustakaan.dimas.perpustakaan;

import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

;
public class KategoriFragment extends Fragment {

    private BukuAdapter bukuAdapter;
    private ListView listView;
    private Kategori kat;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_kategori, container, false);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Bundle args = getArguments();
        kat = args.getParcelable("Kategori");

        ArrayList<Buku> bukuArrayList;
        if (savedInstanceState != null) {
            bukuArrayList = savedInstanceState.getParcelableArrayList("Array");
        }
        else {
            bukuArrayList = new ArrayList<Buku>();
        }

        bukuAdapter = new BukuAdapter(this, bukuArrayList, getContext());
        listView = (ListView) getActivity().findViewById(R.id.buku_list);
        listView.setAdapter(bukuAdapter);
        Log.d("KategoriFragment", "Masuk onActivityCreated Null");

    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList("Array", bukuAdapter.getBukuArray());

    }
    public void bukuDiKlik(Buku buku) {

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add :
                final AlertDialog.Builder inputAlert = new AlertDialog.Builder(getContext());
                inputAlert.setTitle("Title of the Input Box");
                inputAlert.setMessage("We need your name to proceed");

                LinearLayout layout = new LinearLayout(getContext());
                layout.setOrientation(LinearLayout.VERTICAL);

                final EditText userInput = new EditText(getContext());
                layout.addView(userInput);
                final EditText userInput2 = new EditText((getContext()));
                layout.addView(userInput2);
                inputAlert.setView(layout);
                inputAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String judul = userInput.getText().toString();
                        String kode = userInput2.getText().toString();
                        Buku buku = new Buku(judul,kode,kat);
                        bukuAdapter.getBukuArray().add(buku);
                        bukuAdapter.notifyDataSetChanged();
                        Log.d("Kategori Array", String.valueOf(bukuAdapter.getBukuArray().size()));
                    }
                });
                inputAlert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                AlertDialog alertDialog = inputAlert.create();
                alertDialog.show();
                break;
        } //end of switch
        return true;
    }


}
