package com.example.williamj.hertz.activity;

/**
 * Created by Christian on 2/5/2016.
 */

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.williamj.hertz.R;

public class CarSelection extends Fragment {

    public CarSelection() {
        //empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    //Edit fragment_home to change appearance of screen
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.car_selection, container, false);               //change this to fragment_car_selection


        // Inflate the layout for this fragment
        return rootView;
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}




//        setContentView(R.layout.car_selection);
//        ImageButton nextbtn = (ImageButton)findViewById(R.id.nextButton);
//        nextbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(CarSelection.this, CarSelectionInfo2.class);
//                startActivity(intent);
//            }
//        });
//
//        ImageButton prevbtn = (ImageButton)findViewById(R.id.prevButton);
//        prevbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(CarSelection.this, CarSelectionInfo2.class);
//                startActivity(intent);
//            }
//        });
//
//        ImageButton backbtn = (ImageButton)findViewById(R.id.backButton);
//        backbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(CarSelection.this, CarSelectionInfo.class);
//                startActivity(intent);
//            }
//        });



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//      /*  if (id == R.id.action_settings) {
//            return true;
//        } */
//
//        return super.onOptionsItemSelected(item);
//    }






