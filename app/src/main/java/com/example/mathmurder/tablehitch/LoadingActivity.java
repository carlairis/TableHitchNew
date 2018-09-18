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

    public SharedPreferences preferences, sharedPreferences;


    int x = 0;
    int seatNb;
    String sharingStatus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        preferences = getSharedPreferences("numberSeats", MODE_PRIVATE);
        seatNb = preferences.getInt("nb", 0);

        sharedPreferences = getSharedPreferences("sharing", MODE_PRIVATE);
        sharingStatus = sharedPreferences.getString("status", "");


        System.out.println("seat number= "+seatNb);
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

                //add code to check if every seat is already booked

                int count = 0;
             /*   for(int i = 0; i<Seat.getSeatsStatus().size(); i++){
                    if(Seat.getSeatsStatus().get(i+1) != 0){
                        count++;
                    }

                }*/
                if (count==24){
                    Intent intent = new Intent(LoadingActivity.this, NoSeatActivity.class);
                    startActivity(intent);
                }

                if (sharingStatus.equals("true")){

                    pulling.bookSharingSeatsV2(seatNb);


                }else if (sharingStatus.equals("false")){
                    pulling.bookSeats(seatNb);

                }
              //  pulling.fillTables();

                System.out.println("DONE!" +sharingStatus);

                System.out.println("WHAT = "+Seat.getSeatsStatus().get(1));
                reservationIntent();
            }
        }.start();




    }

    public void reservationIntent(){
        Intent intent = new Intent(this, ReservationActivity.class);
        startActivity(intent);
    }

}
