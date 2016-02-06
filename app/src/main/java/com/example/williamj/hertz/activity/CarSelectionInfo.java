package com.example.williamj.hertz.activity;

/**
 * Created by Christian on 2/5/2016.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import com.example.williamj.hertz.R;

public class CarSelectionInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.car_selection_info);

        ImageButton infobtn = (ImageButton)findViewById(R.id.infoButton);
        infobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarSelectionInfo.this, CarSelection.class);
                startActivity(intent);
            }
        });

        ImageButton nextbtn = (ImageButton)findViewById(R.id.nextButton2);
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarSelectionInfo.this, CarSelectionInfo2.class);
                startActivity(intent);
            }
        });

        ImageButton prevbtn = (ImageButton)findViewById(R.id.prevButton2);
        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CarSelectionInfo.this, CarSelectionInfo2.class);
                startActivity(intent);
            }
        });


    }
}
