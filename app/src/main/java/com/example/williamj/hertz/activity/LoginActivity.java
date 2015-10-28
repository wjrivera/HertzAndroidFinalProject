package com.example.williamj.hertz.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.williamj.hertz.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    EditText usernameInput;
    EditText passwordInput;
    String adminLogin = new String("admin");
    String adminPassword = new String("admin");
    Context context;

    //Changed
    Button LoginButton;
    Button GuestButton;


    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Set Application to full screen by removing action bar
//        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
//        getActionBar().hide();

        context = this;
        super.onCreate(savedInstanceState);

        _("Login Activity Created");

        setContentView(R.layout.activity_login);

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        usernameInput = (EditText) findViewById(R.id.usernameInput);
        passwordInput = (EditText) findViewById(R.id.passwordInput);
        LoginButton = (Button) findViewById(R.id.LoginButton);
        GuestButton = (Button) findViewById(R.id.guestButton);


        //If you press login button
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();

                _("Login Button hit");
                String username = usernameInput.getText() + "";
                String password = passwordInput.getText() + "";
                _("Username: " + username);
                _("Password: " + password);

                //if you don't enter anything
                if(username.length() == 0 || password.length() == 0){

                    Toast.makeText(context, "Please fill in Username and Password", Toast.LENGTH_SHORT).show();
                    return;

                }

                //Change this to the real user name and password
                //if(username == "admin" && password == "admin"){
                if(adminLogin.equals(username) && adminPassword.equals(password)){

                    _("You've logged in as admin");
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);


                }

            }
        });


        //If you press guest link
        GuestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();

                _("You've logged in as guest");
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);


            }
        });

    }

    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() > 4;
    }

    private void hideKeyboard(){
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    //Makes it easier to comment throughout the program
    private void _(String s){

        Log.d("MyApp", "MainActivity" + "---\n" + s);

    }

}
