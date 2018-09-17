package com.example.mathmurder.tablehitch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class MainActivity extends AppCompatActivity {

    private Spinner spinnerNb;
    private RadioButton share, notShare;
    private Button seatsButton, orderButton;


    private NavigationView nDrawer;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;


    public SharedPreferences preferences, sharedPreferences;

    private String toastText = "Please select an option";
    // Firebase instance variables
    //private FirebaseAuth mFirebaseAuth;
 //   private FirebaseUser mFirebaseUser;



    public PullMapData pulling = new PullMapData();
    private DatabaseReference db;
    private HashMap<Integer, Integer> seatsMap = new HashMap<>();
    int x = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);


        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        mDrawer = (DrawerLayout) findViewById(R.id.main_drawer_layout);
        mDrawerToggle = new ActionBarDrawerToggle(this,mDrawer, toolbar, R.string.nav_drawer_open, R.string.nav_drawer_close);
        mDrawer.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
        nDrawer = (NavigationView) findViewById(R.id.main_nav_view);


        spinnerNb  = (Spinner) findViewById(R.id.spinnerSeatNb);

        preferences = getSharedPreferences("numberSeats", MODE_PRIVATE);

        sharedPreferences = getSharedPreferences("sharing", MODE_PRIVATE);

        String[] num = {"1","2","3","4","5","6"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, num);

        spinnerNb.setAdapter(adapter);

        spinnerNb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String seats = spinnerNb.getItemAtPosition(i).toString();

                int seatsInt = Integer.parseInt(seats);

                preferences.edit().putInt("nb",seatsInt).apply();
                System.out.println("number of seats"+seatsInt);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
























        share= (RadioButton) findViewById(R.id.radioShare);
        notShare = (RadioButton) findViewById(R.id.radioNotShare);




        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(share.isChecked()){
                    notShare.setChecked(false);

                }
                sharedPreferences.edit().putString("status","true").apply();


            }
        });


        notShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(notShare.isChecked()){
                    share.setChecked(false);
                }
                sharedPreferences.edit().putString("status","false").apply();

            }
        });

        seatsButton = (Button) findViewById(R.id.seatsButton);
        seatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(share.isChecked() == false && notShare.isChecked()==false){
                    Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_LONG).show();
                }
                else{
                    Intent intent = new Intent(MainActivity.this, LoadingActivity.class);
                    startActivity(intent);
                }

            }
        });


        orderButton = (Button) findViewById(R.id.ordrFoodButt);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FoodStallsActivity.class);
                startActivity(intent);
            }
        });







      //  pulling.doSomething();




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



    public void fillTables(){
    }


}
