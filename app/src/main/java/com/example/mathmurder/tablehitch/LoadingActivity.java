package com.example.mathmurder.tablehitch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;

public class LoadingActivity extends AppCompatActivity {


    public PullMapData pulling = new PullMapData();
    private DatabaseReference db;
    private HashMap<Integer, Integer> seatsMap = new HashMap<>();

    public SharedPreferences preferences ;


    int x = 0;
    int seatNb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        preferences =getSharedPreferences("numberSeats", MODE_PRIVATE);

        seatNb = preferences.getInt("nb", 0);

        db = pulling.getmDatabase();


        db.getParent().addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                int value = dataSnapshot.getValue(Integer.class);

                System.out.println("value = "+value+", data snapchot value"+dataSnapshot.getKey().toString());
                String key = dataSnapshot.getKey().toString();
                key = key.replaceAll("\\D", "");

                int keyInt = Integer.parseInt(key);
//               Seat.addSeat(keyInt, value);
                seatsMap.put(keyInt, value);
                Seat.getInstance().getSeatsStatus().put(keyInt, value);


                System.out.println("x = "+x);
                System.out.println("map shit = "+ seatsMap.size());

                x++;



            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        new CountDownTimer(6000, 1000) { //40000 milli seconds is total time, 1000 milli seconds is time interval

            public void onTick(long millisUntilFinished) {
            }
            public void onFinish(){
                System.out.println("DONE!");
                pulling.bookSeats(seatNb);
                reservationIntent();
            }
        }.start();




    }

    public void reservationIntent(){
        Intent intent = new Intent(this, ReservationActivity.class);
        startActivity(intent);
    }

}
