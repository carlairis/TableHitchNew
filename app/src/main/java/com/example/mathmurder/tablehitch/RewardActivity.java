package com.example.mathmurder.tablehitch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RewardActivity extends AppCompatActivity {

    int[] rewardImgs = {R.drawable.westernfood, R.drawable.chickenrice, R.drawable.muslimfoodshop,
            R.drawable.malahotpot,R.drawable.beverage, R.drawable.fruitjuices};


    String[] rewardNames = new String[] {
            "1 Free Dish \n from Western stall",
            "1 Free Dish \n from Chicken Rice stall",
            "1 Free Dish \n from Muslim Stall",
            "1 Free Dish \n from Mala Hotpot",
            "1 Free Drink \n of your choice",
            "1 Free Juice \n no mixed fruits"
    };

    String[] rewardPrices = new String[]{
            "400",
            "300",
            "300",
            "450",
            "200",
            "250",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        GridView rewardList = (GridView) findViewById(R.id.rewardsList);

        TextView currentPoint = (TextView)findViewById(R.id.currentPoint);
        currentPoint.setText("Current Point: " + User.rewardPoints);

        final CustomAdapter customAdapter = new CustomAdapter();
        rewardList.setAdapter(customAdapter);


        rewardList.setClickable(true);

        rewardList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int toRedeem = Integer.parseInt(rewardPrices[position]);
                if(User.rewardPoints >= toRedeem){
                    User.rewardPoints -= toRedeem;
                    view.setBackgroundColor(getResources().getColor(R.color.aluminum));
                    view.setClickable(false);
                }
                else{
                    Toast.makeText(RewardActivity.this, "Not Enough Points", Toast.LENGTH_LONG).show();
                }
            }
        });
    }




    class CustomAdapter extends BaseAdapter {

        String itemSelected;
        TextView stallNameTV, priceTV, quantity;

        @Override
        public int getCount() {
            return rewardImgs.length;
        }

        @Override
        public Object getItem(int i) {
             return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view =  getLayoutInflater().inflate(R.layout.custom_reward_layout, null);

            TextView rewardName = (TextView) view.findViewById(R.id.rewardName);

            ImageView imageView = (ImageView) view.findViewById(R.id.rewardImg);
            TextView rewardPrice = (TextView) view.findViewById(R.id.rewardPrice);

            imageView.setImageResource(rewardImgs[i]);
            rewardName.setText(rewardNames[i]);
            rewardPrice.setText(rewardPrices[i] + " Points");

            return view;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(RewardActivity.this, MainActivity.class);
        startActivity(intent);

    }
}

