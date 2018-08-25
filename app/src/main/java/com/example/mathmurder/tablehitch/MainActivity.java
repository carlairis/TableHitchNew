package com.example.mathmurder.tablehitch;

import android.content.Intent;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;


public class MainActivity extends AppCompatActivity {

    private Spinner spinnerNb;
    private RadioButton share, notShare;
    private Button seatsButton;


    private NavigationView nDrawer;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;

    // Firebase instance variables
    //private FirebaseAuth mFirebaseAuth;
 //   private FirebaseUser mFirebaseUser;

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

        String[] num = {"1","2","3","4","5","6"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, num);

        spinnerNb.setAdapter(adapter);


        share= (RadioButton) findViewById(R.id.radioShare);
        notShare = (RadioButton) findViewById(R.id.radioNotShare);


        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(share.isChecked()){
                    notShare.setChecked(false);
                }

            }
        });


        notShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(notShare.isChecked()){
                    share.setChecked(false);
                }
            }
        });

        seatsButton = (Button) findViewById(R.id.seatsButton);
        seatsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReservationActivity.class);
                startActivity(intent);
            }
        });



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
}
