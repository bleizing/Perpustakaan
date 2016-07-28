package perpustakaan.dimas.perpustakaan;

import android.content.Context;
import android.content.DialogInterface;
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


public class MainFragment extends Fragment {

    public static final String TAG = "MainFragment";

    private LayoutInflater inflater;

    private ListView listView;
    private KategoriAdapter kategoriAdapter;

    /***********************************************************************************************
     *
     *          FRAGMENT LIFECYCLE
     *
     **********************************************************************************************/

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach()");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate()");

        setHasOptionsMenu(true);
        inflater = getLayoutInflater(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView()");
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.i(TAG, "onViewCreated()");
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated()");
        ((MainActivity) getActivity()).setActionBarTitle("Perpustakaan");

        kategoriAdapter = new KategoriAdapter(this, Model.getKategoriArrayList(), getContext());
        listView = (ListView) getActivity().findViewById(R.id.kategori_list);
        listView.setAdapter(kategoriAdapter);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i(TAG, "onViewStateRestored()");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Inflate the menu; this adds items to the action bar if it is present.
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
        Log.i(TAG, "onCreateOptionsMenu()");
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        Log.i(TAG, "onPrepareOptionsMenu()");
    }

    /** ================================
     *      FRAGMENT IS ACTIVE
     * ================================*/

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    /*
        Called whenever Activity's onSaveInstanceState is called
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState()");
        if (kategoriAdapter != null) {
            outState.putParcelableArrayList("Array", kategoriAdapter.getKategoriArray());
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach()");
    }

    /***********************************************************************************************
     *
     *      END FRAGMENT LIFECYCLE
     *
     **********************************************************************************************/

    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected()");
        switch (item.getItemId()) {
            case R.id.action_add :
                final AlertDialog.Builder inputAlert = new AlertDialog.Builder(getContext());
                inputAlert.setTitle("Input Kategori");
                inputAlert.setMessage("Masukkan Jenis Kategori");
                final LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.dialog_edit_text, null);
                final EditText userInput = (EditText) layout.findViewById(R.id.edit_text);
                inputAlert.setView(layout);
                userInput.setHint("Kategori Buku");
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