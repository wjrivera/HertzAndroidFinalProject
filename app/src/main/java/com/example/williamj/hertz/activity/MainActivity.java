package com.example.williamj.hertz.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.williamj.hertz.R;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private static String TAG = MainActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        assert getSupportActionBar() != null;       //to tell compiler it won't be null
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        // display the first navigation drawer view on app launch
        displayView(0);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

        displayView(position);

    }

    //Click on Reserve a car
    public void reserveButtonClick(View v){

        Log.d("tag", "Reserver a car fragment called");
        displayView(7);

    }

    //Click on Reserve a car
    public void lookupReservationButtonClick(View v){

        Log.d("tag", "Look up Reservation fragment called");
        displayView(9);

    }

    //Click on Reserve a car
    public void findLocationButtonClick(View v){

        Log.d("tag", "Find Location Fragment called");
        displayView(5);

    }
    //Click on Reserve a car
    public void findVehicleButtonClick(View view){

        Log.d("tag", "Find Vehicle");
        displayView(8);

    }

    //Click on Home
    public void goHomeButtonClick(View view){

        Log.d("tag", "Home");
        displayView(0);

    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                //title = getString(R.string.title_home);
                title = " ";
                break;
            case 1:
                fragment = new AccountSettingsFragment();
                //title = getString(R.string.title_accountsettings);
                title = " ";
                break;
            case 2:
                fragment = new PreferencesFragment();
                //title = getString(R.string.title_preferences);
                title = " ";
                break;
            case 3:
                fragment = new DealsFragment();
                //title = getString(R.string.title_deals);
                title = " ";
                break;
            case 4:
                fragment = new RoadsideFragment();
                //title = getString(R.string.title_roadside);
                title = " ";
                break;
            case 5:
                fragment = new ContactFragment();
                //title = getString(R.string.title_contact);
                title = " ";
                break;
            case 6:
                fragment = new PrivacyFragment();
                //title = getString(R.string.title_privacy);
                title = " ";
                break;
            case 7:
                fragment = new ReserveCarFragment();
                //title = getString(R.string.title_reservecar);
                title = " ";
                break;
            case 8:
                fragment = new VehicleFragment();
                //title = getString(R.string.title_findvehicle);
                title = " ";
                break;
            case 9:
                fragment = new FindReservationFragment();
                //title = getString(R.string.title_findreservation);
                title = " ";
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.container_body, fragment);
            fragmentTransaction.commit();

            // set the toolbar title
            assert getSupportActionBar() != null;       //to tell compiler it won't be null
            getSupportActionBar().setTitle(title);
        }
    }
}
