package com.example.mathmurder.tablehitch;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FoodItemActivity extends AppCompatActivity {

    private GridView menuItems;

    int[] images = {R.drawable.economicrice, R.drawable.koreanjapanese, R.drawable.thaivietnamese,
            R.drawable.chickenrice,R.drawable.indianfoodshop, R.drawable.westernfood, R.drawable.muslimfoodshop,
            R.drawable.mala, R.drawable.beverage, R.drawable.fruitjuices};


    String[] stalls = new String[] {
            "Economic Rice",
            "Korean/Japanese",
            "Thai/Vietnamese",
            "Chicken Rice",
            "Indian Food",
            "Western",
            "Muslim Stall",
            "Mala Hotpot",
            "Drinks",
            "Fruit Juices"
    };


    String[] prices = new String[]{"$0", "$0","$0","$0","$0","$0","$0","$0","$0","$0"};

    int count  = 1;
    private int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        menuItems = (GridView) findViewById(R.id.foodListGV);

        final CustomAdapter customAdapter = new CustomAdapter();


        Intent intentA = getIntent();
        position = intentA.getIntExtra("position", 0);
        System.out.println("position"+position);
        menuItems.setAdapter(customAdapter);


        if (position == 0){
            stalls = null;
            stalls = new String[]{"Ban Mian", "Fried Tofu", "Eggplant", "Potatoes", "Sausage", "Pork", "Beef", "Fish", "Fried Chicken", "Sweet and Sour Pork"};
            prices = new String[]{"$4", "$2","$1","$1","$3","$3","$3","$3","$3","$3"};
            customAdapter.notifyDataSetChanged();
            count++;


        } else if(position == 1){
            stalls = null;
            stalls = new String[]{"Chicken Ramen", "BBQ chicken set", "Omelette Rice" , "Bimbimbap", "Bulgogi","Gimbap","Fish Curry Rice","Tteok-booki", "Chicken + Prawn Bento", "Karage Chicken set"};
            prices = new String[]{"$3.50", "$4.50","$4","$3.50","$4","$2.90","$3","$4.50","$5","$3.50"};
            customAdapter.notifyDataSetChanged();
            count++;


        } else if(position == 2){
            stalls = null;
            stalls = new String[]{"Vietnamese Braised Chicken","Thai Tom Yum Seafood Soup","Vietnamese Grilled Pork w Rice & Egg", "Pad Thai w/Egg" , "Tofu Pad Thai", "Vermicelli w/ Grilled Pork & Fried Spring Roll","Thai Basil Leaf Minced Chicken Set", "Viet Sliced Beef Kway Teow Soup","Thai Tom Yum Fried Mee", "Vietnamese Style Drumstick Wrap w Glutinous Rice"};
            prices = new String[]{"$3.50", "$3.50","$5.50","$4","$4.50","$4.50","$4","$3","$3.50","$4.50"};
            customAdapter.notifyDataSetChanged();
            count++;



        }else if (position == 3 ){
            stalls = null;
            stalls = new String[]{"Roasted chicken rice", "Steamed chicken rice", "Roasted Duck rice", "Char siew rice", "Roasted pork rice" , "Roasted pork noodle","Roasted chicken noodle", "Roasted duck noodle","Curry Chicken Noodle","Rice porridge"};
            prices = new String[]{"$3", "$3","$3.5O","$3.5O","$3","$3.50","4.50","$4","$4","$4"};
            customAdapter.notifyDataSetChanged();
            count++;


        }else if (position == 4 ){
            stalls = null;
            stalls = new String[]{"Butter chicken","Chicken 65", "South Indian meal", "Oaratha set" , "Egg Prata", "Garlic naan","Chappathi set","Tandoori","Fried rice","Chicken masala"};
            prices = new String[]{"$3.50", "$4","$4.50","$3.50","$1.50","$1","$2.50","$4","$3","$3.50"};
            customAdapter.notifyDataSetChanged();
            count++;


        } else if (position == 5 ) {
            stalls = null;
            stalls = new String[]{"Fish and chips","Tomato pasta", "Chicken cutlet", "Breakfast set" , "Cheese Fries", "Aglio olio","Chilled australian striploin S grade 180G","Honey soy chicken","Beef burger set","Mushroom cream pasta"};
            prices = new String[]{"$4.50", "$3.50","$3.50","$3","$2.90","$3","$6","$4","$5","$3"};
            customAdapter.notifyDataSetChanged();
            count++;


        }else if (position == 6){
            stalls = null;
            stalls = new String[]{"Nasi Lemak Set","Ayam Penyet", "Ikan Penyet", "Lontong" , "Mee Rebus","Mee Soto","Economical Beehoon","Mee Goreng","Briyani", "Curry Puff"};
            prices = new String[]{"$4", "$3.50","$3.50","$3","$4.50","$3.50","$2","$3","$2.50","$0.50"};
            customAdapter.notifyDataSetChanged();
            count++;



        }else if(position== 7 ){
            stalls = null;
            stalls = new String[]{"Mala hotpot","Mala Xiang Guo", "Spicy Fried Chicken","GreenPepper w sliced potato" , "Sichuan Boiled Beef","Minced Pork Rice", "Sauteed Pork w Pepper & Chilli","Olive Stir Fried Green Bean","Braised Beef Rice"};
            prices = new String[]{"$6.50", "$5.50","5.50","$4","$5.50","$5","$5.50","$3","$4.50","$5"};
            customAdapter.notifyDataSetChanged();
            count++;



        }else if (position == 8 ){
            stalls = null;
            stalls = new String[]{"Milk","Coke", "SoyBean Drink", "Coffee plus milo", "Milo" , "Milk tea","Cafe Latte","Espresso","Tuna sandwich","Chocolate cake"};
            prices = new String[]{"$1.20", "$1.30","$1.20","$1.70","$1.50","$1.50","$4","$2","$2.40","$5.50"};
            customAdapter.notifyDataSetChanged();
            count++;


        }else if(position == 9 ){
            stalls = null;
            stalls = new String[]{"Apple juice","Pineapple juice", "Watermelon juice", "Soursop + DragonFruit Juice", "Kiwi juice" , "Orange juice","Carrot juice","Grape juice","Mango juice","Lime juice"};
            prices = new String[]{"$2", "$2.50","$2.50","$3","$2.50","$2","$2","$2","$2.50","$2.50"};
            customAdapter.notifyDataSetChanged();
            count++;


        }




    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return images.length;
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
            view =  getLayoutInflater().inflate(R.layout.custom_grid_layout, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageViewGV);
            TextView stallNameTV = (TextView) view.findViewById(R.id.stallNameGV);
            TextView priceTV = (TextView) view.findViewById(R.id.priceTV);

            imageView.setImageResource(images[i]);
            stallNameTV.setText(stalls[i]);
            priceTV.setText(prices[i]);

            return view;
        }
    }
}
