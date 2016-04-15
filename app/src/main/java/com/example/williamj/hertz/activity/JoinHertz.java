package com.example.williamj.hertz.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.williamj.hertz.R;

public class JoinHertz extends AppCompatActivity  {


    EditText NameInput;
    EditText EmailInput;
    EditText AddressInput;
    EditText PhoneInput;
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

        setContentView(R.layout.content_join_hertz);

        _("Join Hertz Created");


        SubmitButton = (Button) findViewById(R.id.submitButton);
        NameInput = (EditText) findViewById(R.id.nameInput);
        EmailInput = (EditText) findViewById(R.id.emailInput);
        AddressInput = (EditText) findViewById(R.id.addressInput);
        PhoneInput = (EditText) findViewById(R.id.phoneInput);


        //If you press login button
        SubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //hideKeyboard();

                //Will retrieve the new join member, at a later time we will
                //submit this information upstream.
                String regName = NameInput.getText() + "";
                String regEmail = EmailInput.getText() + "";
                String regAddress = AddressInput.getText() + "";
                String regPhone = PhoneInput.getText() + "";

                if(regName.length() == 0 || regEmail.length() == 0 || regAddress.length() == 0 || regPhone.length() == 0){

                    Toast.makeText(context, "Please fill in all the information", Toast.LENGTH_SHORT).show();
                    return;

                }

                _("You have registered thru Hertz, check your email");
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);

                }

        });

    }



    //Makes it easier to comment throughout the program
    private void _(String s){

        Log.d("MyApp", "MainActivity" + "---\n" + s);

    }

}
