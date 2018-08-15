package com.example.mathmurder.tablehitch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private Spinner spinnerNb;
    private RadioButton share, notShare;
    private Button seatsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent intent = new Intent(MainActivity.this, LoadingActivity.class);
                startActivity(intent);
            }
        });




    }
}
