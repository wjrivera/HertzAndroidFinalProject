package com.example.williamj.hertz.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.williamj.hertz.R;

public class Credentials extends AppCompatActivity  {


    EditText UsernameInput;
    EditText PasswordInput;
    String adminLogin = new String("admin");
    String adminPassword = new String("admin");
    Context context;
    Button LoginButton, SubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        context = this;
        super.onCreate(savedInstanceState);
        //Set screen to portrait mode
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setContentView(R.layout.activity_credentials);

        _("Join Hertz Created");


        SubmitButton = (Button) findViewById(R.id.submitButton);
        UsernameInput = (EditText) findViewById(R.id.usernameInput);
        PasswordInput = (EditText) findViewById(R.id.passwordInput);


        //If you press login button
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hideKeyboard();

                //Save the username and password
                String getUserName = UsernameInput.getText() + "";
                String getPassword = PasswordInput.getText() + "";


                testEmpty(getUserName, getPassword);
                testAdmin(getUserName, getPassword);






            }

        });

    }

    public void testAdmin(String a, String b){

        if(adminLogin.equals(a) && adminPassword.equals(b)) {

            _("You've logged in as admin");
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);

        }else{

            Toast.makeText(context, "Please enter the correct credentials", Toast.LENGTH_SHORT).show();

        }

    }
    public void testEmpty(String a, String b){

        if(a.length() == 0 || b.length() == 0){

            Toast.makeText(context, "Please fill in Username and Password", Toast.LENGTH_SHORT).show();
            return;

        }

    }



    //Makes it easier to comment throughout the program
    private void _(String s){

        Log.d("MyApp", "MainActivity" + "---\n" + s);

    }

}
