package com.example.mathmurder.tablehitch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class ReservationActivity extends AppCompatActivity  implements NavigationView.OnNavigationItemSelectedListener {

    private NavigationView nDrawer;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;

    public PullMapData pulling = new PullMapData();

    private TextView seatsTV;

    public SharedPreferences preferences, sharedPreferences;

    private DatabaseReference db;

    private Seat seat;

    private HashMap<Integer, Integer> seatsMap = new HashMap<>();

    int x=1;

    int count = 1;
    String sharingStatus;

    int seatNb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawer, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        nDrawer = (NavigationView) findViewById(R.id.nav_view);
    //    setNavDrawer();

    /*    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        preferences = getSharedPreferences("numberSeats", MODE_PRIVATE);

        seatNb = preferences.getInt("nb", 0);

        System.out.println("this is what we are printing"+seatNb);


        sharedPreferences = getSharedPreferences("sharing", MODE_PRIVATE);
        sharingStatus = sharedPreferences.getString("status", "");


   /*     if (sharingStatus.equals("true")){

            pulling.bookSharingSeatsV2(seatNb);


        }else if (sharingStatus.equals("false")){
            pulling.bookSeats(seatNb);

        }*/


        seatsTV = (TextView) findViewById(R.id.tvSeats);
        seatsTV.setText("Seats:" +User.getBookedSeats().toString());





        //pulling.doSomething();


       // pulling.readNewSeat();


       /* pulling.writeNewSeat(2, 2);
        pulling.writeNewSeat(3,2);
        pulling.writeNewSeat(4, 2);*/

       seatsMap = Seat.getInstance().getSeatsStatus();

       db = pulling.getmDatabase();



        System.out.println("size"+Seat.getSeatsStatus().size());




    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profileNav) {
            // Handle the camera action
        } else if (id == R.id.seatNav) {

        } else if (id == R.id.foodNav) {
            Intent intent = new Intent(this, FoodStallsActivity.class);
            startActivity(intent);

        } else if (id == R.id.payNav) {

        } else if (id == R.id.rewardNav) {

        } else if (id == R.id.historyNav) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void mapIntent(View view){
        Intent intent = new Intent(this, MapActivity.class);
        startActivity(intent);
    }

    public void menuIntent(View view){
        Intent intent = new Intent(this, FoodStallsActivity.class);
        startActivity(intent);
    }
}

