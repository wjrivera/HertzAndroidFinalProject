package com.example.williamj.hertz.activity;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.Calendar;

import com.example.williamj.hertz.R;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener {

    private static String TAG = MainActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private FragmentDrawer drawerFragment;
    private Button pickUpDate = null;
    private Button dropOffDate = null;

    DatePicker datePicker;      //Need to initialize this
    TextView displayDate;
    Button CallRoadside;
    int month;


    FragmentManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set screen to portrait mode
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);

        _("Set Content View done");


        pickUpDate = (Button) findViewById(R.id.pickUpDate);

        datePicker = (DatePicker) findViewById(R.id.datePicker);


        manager = getSupportFragmentManager();
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        assert getSupportActionBar() != null;       //to tell compiler it won't be null
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        drawerFragment = (FragmentDrawer)
                getSupportFragmentManager().findFragmentById(R.id.fragment_navigation_drawer);
        drawerFragment.setUp(R.id.fragment_navigation_drawer, (DrawerLayout) findViewById(R.id.drawer_layout), mToolbar);
        drawerFragment.setDrawerListener(this);

        _("Drawer Fragments Created done");

        // display the first navigation drawer view on app launch
        displayView(0);

        _("Display View done");

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        // Add your initialization code here
        Parse.initialize(this, "Ip81WvPKbI8cBr3xGyvdXvMBIuRzStfiqnW3NvzX", "4cRFxgZIJqRkfIKKkWbc2cDAjwAt6kxRH5tftC7m");
        ParseInstallation.getCurrentInstallation().saveInBackground();

        _("Parse done");


    }


    public String currentDate() {
        StringBuilder mcurrentDate = new StringBuilder();
        month = datePicker.getMonth() + 1;
        mcurrentDate.append("Date: " + month + "/" + datePicker.getDayOfMonth() + "/" + datePicker.getYear());
        return mcurrentDate.toString();
    }

    @Override
    public void onBackPressed() {


        int count = getFragmentManager().getBackStackEntryCount();

        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }


        //moveTaskToBack(true);


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

    public void callRoadsideButton(View view) {

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:1-800-654-5060"));

        try {
            startActivity(callIntent);
        }catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"Can't call at this time",Toast.LENGTH_SHORT).show();
        }

    }

    public void callReservationButton(View view) {

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:1-800-654-3131"));

        try {
            startActivity(callIntent);
        }catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"Can't call at this time",Toast.LENGTH_SHORT).show();
        }

    }

    public void callShopButton(View view) {

        Intent callIntent = new Intent(Intent.ACTION_DIAL);
        callIntent.setData(Uri.parse("tel:1-800-704-4473"));

        try {
            startActivity(callIntent);
        }catch (android.content.ActivityNotFoundException ex){
            Toast.makeText(getApplicationContext(),"Can't call at this time",Toast.LENGTH_SHORT).show();
        }

    }

//    public void callReservationButton(View view) {
//
//        Intent callIntent = new Intent(Intent.ACTION_CALL);
//        callIntent.setData(Uri.parse("tel:1-800-654-3131"));
//
//        try {
//            startActivity(callIntent);
//        }catch (android.content.ActivityNotFoundException ex){
//            Toast.makeText(getApplicationContext(),"Can't call at this time",Toast.LENGTH_SHORT).show();
//        }
//
//    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

        displayView(position);

    }

    //Click on Reserve a car
    public void reserveButtonClick(View v){

        Log.d("tag", "Reserver a car fragment called");
        displayView(7);

    }

    public void prevButtonClick1(View v){

        //Log.d("tag", "Reserver a car fragment called");
        displayView(11);

    }

    public void prevButtonClick2(View v){

        //Log.d("tag", "Reserver a car fragment called");
        displayView(10);

    }

    public void nextButtonClick1(View v){

        //Log.d("tag", "Reserver a car fragment called");
        displayView(11);

    }

    public void nextButtonClick2(View v){

        //Log.d("tag", "Reserver a car fragment called");
        displayView(10);

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

    //Click on Home
    public void checkoutClick(View view){

        //Log.d("tag", "Home");
        displayView(12);

    }


    //Click on Home
    public void finalCheckoutClick(View view){

//        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//        startActivity(intent);

    }

    //Click on Home
    public void goCarSelectionButtonClick(View view){

        Log.d("tag", "Car Selection");
        displayView(10);

    }

    //Click on Home
    public void congratsButtonClick(View view){

        Log.d("tag", "Car Selection");
        displayView(13);

    }

    //Makes it easier to comment throughout the program
    private void _(String s){

        Log.d("MyApp", "MainActivity" + "---\n" + s);

    }

    private void displayView(int position) {
        Fragment fragment = null;
        String title = getString(R.string.app_name);
        switch (position) {
            case 0:
                fragment = new HomeFragment();
                //title = getString(R.string.title_home);
                title = "   ";
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
            case 10:
                fragment = new CarSelection();
                //title = getString(R.string.title_findreservation);
                title = " ";
                break;
            case 11:
                fragment = new CarSelection2();                              //add fragment here
                //title = getString(R.string.title_findreservation);
                title = " ";
                break;
            case 12:
                fragment = new CheckoutFragment();                              //add fragment here
                //title = getString(R.string.title_findreservation);
                title = " ";
                break;
            case 13:
                fragment = new CongratsFragment();                              //add fragment here
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
