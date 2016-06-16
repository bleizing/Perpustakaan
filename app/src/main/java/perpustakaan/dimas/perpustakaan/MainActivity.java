package perpustakaan.dimas.perpustakaan;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().addOnBackStackChangedListener(this);

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
        args.putParcelable("Kategori", kat);
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

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onBackStackChanged() {
        shouldDisplayHomeUp();
    }

    public void shouldDisplayHomeUp(){
        //Enable Up button only  if there are entries in the back stack
        boolean canback = getSupportFragmentManager().getBackStackEntryCount()>0;
        getSupportActionBar().setDisplayHomeAsUpEnabled(canback);
    }

    public boolean onSupportNavigateUp() {
        Log.d("MainActivity", "Up!");
        getSupportFragmentManager().popBackStack();
        return true;
    }
}


