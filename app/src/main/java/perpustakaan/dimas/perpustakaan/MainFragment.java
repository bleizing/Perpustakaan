package perpustakaan.dimas.perpustakaan;

import android.app.Activity;
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
import android.widget.ListView;

import java.util.ArrayList;


public class MainFragment extends Fragment {


    private ListView listView;
    private KategoriAdapter kategoriAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ((MainActivity) getActivity()).setActionBarTitle("Perpustakaan");

        kategoriAdapter = new KategoriAdapter(this, Model.getKategoriArrayList(), getContext());
        listView = (ListView) getActivity().findViewById(R.id.kategori_list);
        listView.setAdapter(kategoriAdapter);
        Log.d("MainFragment", "Masuk onActivityCreated Null");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelableArrayList("Array", kategoriAdapter.getKategoriArray());

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
                inputAlert.setTitle("Input Kategori");
                inputAlert.setMessage("Masukkan Jenis Kategori");
                final EditText userInput = new EditText(getContext());
                inputAlert.setView(userInput);
                inputAlert.setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String userInputValue = userInput.getText().toString();
                        Kategori kat = new Kategori(userInputValue);
                        Model.addKategoriArrayList(kat);
                        kategoriAdapter.notifyDataSetChanged();
                        Log.d("Kategori Array", String.valueOf(kategoriAdapter.getKategoriArray().size()));
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

    public void kategoriDiklik(Kategori kat) {
        ((MainActivity) getActivity()).changeToKategoriFragment(kat);
    }
}


