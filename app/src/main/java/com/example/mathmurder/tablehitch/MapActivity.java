package com.example.mathmurder.tablehitch;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MapActivity extends AppCompatActivity {

    public PullMapData pulling = new PullMapData();
    public ArrayList<ImageView> seatsColor;

    private ImageView s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


      //  pulling.doSomething();

     //   pulling.writeNewSeat(1, 1);

//        System.out.println("this is in the map = "+ Seat.getSeatsStatus().get(3));

        System.out.println("static map = "+Seat.getSeatsStatus().get(4));


        s1 = (ImageView) findViewById(R.id.seat1);
        s2 = (ImageView) findViewById(R.id.seat2);
        s3 = (ImageView) findViewById(R.id.seat3);
        s4 = (ImageView) findViewById(R.id.seat4);
        s5 = (ImageView) findViewById(R.id.seat5);
        s6 = (ImageView) findViewById(R.id.seat6);
        s7 = (ImageView) findViewById(R.id.seat7);
        s8 = (ImageView) findViewById(R.id.seat8);
        s9 = (ImageView) findViewById(R.id.seat9);
        s10 = (ImageView) findViewById(R.id.seat10);
        s11 = (ImageView) findViewById(R.id.seat11);
        s12 = (ImageView) findViewById(R.id.seat12);
        s13 = (ImageView) findViewById(R.id.seat13);
        s14 = (ImageView) findViewById(R.id.seat14);
        s15 = (ImageView) findViewById(R.id.seat15);
        s16 = (ImageView) findViewById(R.id.seat16);
        s17 = (ImageView) findViewById(R.id.seat17);
        s18 = (ImageView) findViewById(R.id.seat18);
        s19 = (ImageView) findViewById(R.id.seat19);
        s20 = (ImageView) findViewById(R.id.seat20);
        s21 = (ImageView) findViewById(R.id.seat21);
        s22 = (ImageView) findViewById(R.id.seat22);
        s23 = (ImageView) findViewById(R.id.seat23);
        s24 = (ImageView) findViewById(R.id.seat24);



        seatsColor = new ArrayList<>(Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13, s14, s15, s16, s17, s18, s19, s20, s21, s22, s23, s24));

        for (int i=0; i<User.getBookedSeats().size(); i++){
            int seatID = User.getBookedSeats().get(i);

            seatsColor.get(seatID-1).setImageResource(R.drawable.blue_rectangle);
        }


        System.out.println("size = "+Seat.getSeatsStatus().size());

        for (int i=0; i<Seat.getSeatsStatus().size(); i++){
            int seatID = Seat.getSeatsStatus().get(i+1);

            if (seatID == 0){
                System.out.println("free seat");
            }
            else if (seatID == 1){
                System.out.println("booked seat");
                seatsColor.get(seatID).setImageResource(R.drawable.red_rectangle);
            }
        }



    }





}
