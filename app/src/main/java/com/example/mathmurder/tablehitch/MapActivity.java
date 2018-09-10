package com.example.mathmurder.tablehitch;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MapActivity extends AppCompatActivity {

    public PullMapData pulling = new PullMapData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


      //  pulling.doSomething();

        pulling.writeNewSeat(1, 1);

//        System.out.println("this is in the map = "+ Seat.getSeatsStatus().get(3));

        System.out.println("static map = "+Seat.getSeatsStatus().get(4));





    }

}
