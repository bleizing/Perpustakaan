package perpustakaan.dimas.perpustakaan;

import android.content.Context;
import android.content.DialogInterface;
import android.provider.SyncStateContract;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
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
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mainFragment, "PERPUSTAKAAN").commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("MainACtivity", "onOptionsItemSelected");
        switch (item.getItemId()) {
            case android.R.id.home:
                FragmentManager fm = getSupportFragmentManager();
                if (fm.getBackStackEntryCount() > 0) {
                    fm.popBackStack();
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void changeToKategoriFragment(Kategori kat) {
        KategoriFragment kategoriFragment = new KategoriFragment();
        Bundle args = new Bundle();
        args.putParcelable("KategoriParcelable", kat);
        kategoriFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, kategoriFragment, "KATEGORI");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void changeToBukuFragment(Buku b) {
        BukuFragment bukuFragment = new BukuFragment();
        Bundle args = new Bundle();
        args.putParcelable("Buku", b);
        bukuFragment.setArguments(args);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, bukuFragment, "BUKU");
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onBackStackChanged() {
        Log.d("MainActivity", "Back stack number: " + getSupportFragmentManager().getBackStackEntryCount());
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

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("ActionBar", getSupportActionBar().getDisplayOptions());
    }
    protected void onRestoreInstanceState (Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int options = savedInstanceState.getInt("ActionBar");

        final boolean isShowHomeEnabled = (options & ActionBar.DISPLAY_SHOW_HOME) != 0;
        final boolean isHomeAsUpEnabled = (options & ActionBar.DISPLAY_HOME_AS_UP) != 0;
        final boolean isShowTitleEnabled = (options & ActionBar.DISPLAY_SHOW_TITLE) != 0;
        final boolean isUseLogoEnabled = (options & ActionBar.DISPLAY_USE_LOGO) != 0;
        final boolean isShowCustomEnabled = (options & ActionBar.DISPLAY_SHOW_CUSTOM) != 0;

        ActionBar ab = getSupportActionBar();
        ab.setDisplayShowHomeEnabled(isShowHomeEnabled);
        ab.setDisplayHomeAsUpEnabled(isHomeAsUpEnabled);
        ab.setDisplayShowTitleEnabled(isShowTitleEnabled);
        ab.setDisplayUseLogoEnabled(isUseLogoEnabled);
        ab.setDisplayShowCustomEnabled(isShowCustomEnabled);
    }
}


