package com.example.williamj.hertz.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.williamj.hertz.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class LoginActivity extends AppCompatActivity implements FragmentDrawer.FragmentDrawerListener{

    EditText usernameInput;
    EditText passwordInput;
    String adminLogin = new String("admin");
    String adminPassword = new String("admin");
    Context context;

    ViewFlipper viewFlipper, viewFlipper2;
    Animation slide_in_left, slide_out_right;

    int userPick = 0;

    //Changed
    //Button LoginButton;
    Button GuestButton;
    ImageButton LeftArrowButton, RightArrowButton, UserLogoButton, UserLogoButton2, UserLogoButton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        context = this;
        super.onCreate(savedInstanceState);

        //Set screen to portrait mode
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        _("Login Activity Created");

        setContentView(R.layout.activity_login);



        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //usernameInput = (EditText) findViewById(R.id.usernameInput);
        //passwordInput = (EditText) findViewById(R.id.passwordInput);
        //LoginButton = (Button) findViewById(R.id.LoginButton);
        GuestButton = (Button) findViewById(R.id.guestButton);
        LeftArrowButton = (ImageButton) findViewById(R.id.leftarrowbutton);
        RightArrowButton = (ImageButton) findViewById(R.id.rightarrowbutton);

        UserLogoButton = (ImageButton) findViewById(R.id.userlogobutton);
        UserLogoButton2 = (ImageButton) findViewById(R.id.userlogobutton2);
        UserLogoButton3 = (ImageButton) findViewById(R.id.userlogobutton3);





        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        //viewFlipper2 = (ViewFlipper) findViewById(R.id.viewflipper2);

        slide_in_left = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_in_left);
        slide_out_right = AnimationUtils.loadAnimation(this,
                android.R.anim.slide_out_right);

        viewFlipper.setInAnimation(slide_in_left);
        viewFlipper.setOutAnimation(slide_out_right);

//        viewFlipper2.setInAnimation(slide_in_left);
//        viewFlipper2.setOutAnimation(slide_out_right);


        //If you press login button
//        LoginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                hideKeyboard();
//
//                _("Login Button hit");
//                String username = usernameInput.getText() + "";
//                String password = passwordInput.getText() + "";
//                _("Username: " + username);
//                _("Password: " + password);
//
//                //if you don't enter anything
//                if(username.length() == 0 || password.length() == 0){
//
//                    Toast.makeText(context, "Please fill in Username and Password", Toast.LENGTH_SHORT).show();
//                    return;
//
//                }
//
//                //Change this to the real user name and password
//                //if(username == "admin" && password == "admin"){
//                if(adminLogin.equals(username) && adminPassword.equals(password)){
//
//                    _("You've logged in as admin");
//                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(intent);
//
//
//                }
//
//            }
//        });


        //If you press guest link
        GuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();

                _("You've logged in as guest");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();


            }
        });

        //If you press left arrow
        LeftArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                viewFlipper.showPrevious();
                //viewFlipper2.showPrevious();
            }
        });

        //If you press right arrow
        RightArrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                viewFlipper.showNext();
                //viewFlipper2.showNext();
            }
        });

        //If you press UserLogoButtons arrow
        UserLogoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();

                _("You've logged in as User 1");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        UserLogoButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();

                _("You've logged in as User 2");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
        UserLogoButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();

                _("You've logged in as User3");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });



    }



    private void hideKeyboard(){
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    public void onDrawerItemSelected(View view, int position) {

        displayView(position);

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
                title = " ";
                break;
            case 1:
                fragment = new AccountSettingsFragment();
                //title = getString(R.string.title_accountsettings);
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
