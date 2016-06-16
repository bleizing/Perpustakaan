package perpustakaan.dimas.perpustakaan;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mainFragment).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    public void changeToKategoriFragment(Kategori kat) {
        KategoriFragment kategoriFragment = new KategoriFragment();
        Bundle args = new Bundle();
        args.putParcelable("KategoriParcelable", kat);
        kategoriFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, kategoriFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void changeToBukuFragment(Buku b) {
        BukuFragment bukuFragment = new BukuFragment();
        Bundle args = new Bundle();
        args.putParcelable("Buku", b);
        bukuFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, bukuFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}


