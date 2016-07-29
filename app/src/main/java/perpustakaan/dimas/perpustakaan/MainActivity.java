package perpustakaan.dimas.perpustakaan;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    public static final String TAG = "MainActivity";

    /***********************************************************************************************
     *
     *          ACTIVITY LIFECYCLE
     *
     **********************************************************************************************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(TAG, "onCreate()");

        setContentView(R.layout.activity_main);

        getSupportFragmentManager().addOnBackStackChangedListener(this);

        if (savedInstanceState == null) {
            MainFragment mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, mainFragment, "PERPUSTAKAAN").commit();
        }
    }

    /*
        Only called if activity was stopped previously by onStop()
     */
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    /*
        Only called after a configuration change happened (screen rotation)
        OR after app process was killed due to out of memory
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState()");
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

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Log.i(TAG, "onCreateOptionsMenu()");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        Log.i(TAG, "onPrepareOptionsMenu()");
        return super.onPrepareOptionsMenu(menu);
    }

    /** ================================
     *      ACTIVITY IS ACTIVE
     * ================================*/

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    /*
        Called every time before onStop() is called
        EXCEPT when user presses the back button
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState()");
        outState.putInt("ActionBar", getSupportActionBar().getDisplayOptions());
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    /*
       WARNING: not guaranteed to be called
                do all data saving and resource releases in onStop()
     */
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }

    /***********************************************************************************************
     *
     *      END ACTIVITY LIFECYCLE
     *
     **********************************************************************************************/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i(TAG, "onOptionsItemSelected()");
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
        args.putParcelable("Kategori", kat);
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
        Log.i(TAG, "onBackStackChanged()");
        shouldDisplayHomeUp();
    }

    public void shouldDisplayHomeUp(){
        //Enable Up button only  if there are entries in the back stack
        boolean canback = getSupportFragmentManager().getBackStackEntryCount()>0;
        getSupportActionBar().setDisplayHomeAsUpEnabled(canback);
    }

    public boolean onSupportNavigateUp() {
        Log.i(TAG, "onSupportNavigateUp()");
        getSupportFragmentManager().popBackStack();
        return true;
    }
}


