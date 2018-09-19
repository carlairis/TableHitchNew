package com.example.mathmurder.tablehitch;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class FoodItemActivity extends AppCompatActivity {

    private GridView gridView;

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



    private int selectionCounter;
    public static ArrayList<String> selectedItems = new ArrayList<String>();
    private boolean hasBeenSelected;
    private Button removeFood;
    TextView foodQuantity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("toolbar", "clicked on back in toolbar");
                if(selectedItems.size()!=0){
                    Toast.makeText(FoodItemActivity.this, "Selected items are removed", Toast.LENGTH_LONG).show();
                    selectedItems.clear();
                }
                startActivity(new Intent(getApplicationContext(),FoodStallsActivity.class));
//                finish();
            }
        });

        gridView = (GridView) findViewById(R.id.foodListGV);

        final CustomAdapter customAdapter = new CustomAdapter();


        Intent intentA = getIntent();
        position = intentA.getIntExtra("position", 0);
        System.out.println("position"+position);
        gridView.setAdapter(customAdapter);


        images = null;
        if (position == 0){
            stalls = null;
            stalls = new String[]{"Ban Mian", "Fried Tofu", "Eggplant", "Potatoes", "Sausage", "Pork", "Beef", "Fish", "Fried Chicken", "Sweet and Sour Pork"};
            prices = new String[]{"$4", "$2","$1","$1","$3","$3","$3","$3","$3","$3"};
            images = new int[]{R.drawable.banmian, R.drawable.friedtofu, R.drawable.eggplant, R.drawable.potato, R.drawable.sausage, R.drawable.pork, R.drawable.beef, R.drawable.fish, R.drawable.friedchicken, R.drawable.sweetandsourpork};
            customAdapter.notifyDataSetChanged();
            count++;


        } else if(position == 1){
            stalls = null;
            stalls = new String[]{"Chicken Ramen", "BBQ chicken set", "Omelette Rice" , "Bimbimbap", "Bulgogi","Gimbap","Fish Curry Rice","Tteok-booki", "Chicken + Prawn Bento", "Karage Chicken set"};
            prices = new String[]{"$3.50", "$4.50","$4","$3.50","$4","$2.90","$3","$4.50","$5","$3.50"};
            images = new int[]{R.drawable.chickenramen, R.drawable.bbqchickenset, R.drawable.omeletterice, R.drawable.bibimbap, R.drawable.bulgogi, R.drawable.gimbap, R.drawable.fishcurryrice, R.drawable.tteokbokki, R.drawable.karagechicken};
            customAdapter.notifyDataSetChanged();
            count++;


        } else if(position == 2){
            stalls = null;
            stalls = new String[]{"Vietnamese Braised Chicken","Thai Tom Yum Seafood Soup","Vietnamese Grilled Pork w Rice & Egg", "Pad Thai w/Egg" , "Tofu Pad Thai", "Vermicelli w/ Grilled Pork & Fried Spring Roll","Thai Basil Leaf Minced Chicken Set", "Viet Sliced Beef Kway Teow Soup","Thai Tom Yum Fried Mee", "Vietnamese Style Drumstick Wrap w Glutinous Rice"};
            prices = new String[]{"$3.50", "$3.50","$5.50","$4","$4.50","$4.50","$4","$3","$3.50","$4.50"};
            images = new int[]{R.drawable.vietnamesebraisedchicken, R.drawable.tomyumseafoodsoup, R.drawable.grilledporkwithriceandegg, R.drawable.phadthaiegg, R.drawable.tofupadthai, R.drawable.vermicelligrilledporkspringroll, R.drawable.basilleafmincedchickenset, R.drawable.slicedbeefkwayteowsoup, R.drawable.tomyumfriedmee, R.drawable.drumstickwrapwithglutinousrice};
            customAdapter.notifyDataSetChanged();
            count++;



        }else if (position == 3 ){
            stalls = null;
            stalls = new String[]{"Roasted chicken rice", "Steamed chicken rice", "Roasted Duck rice", "Char siew rice", "Roasted pork rice" , "Roasted pork noodle","Roasted chicken noodle", "Roasted duck noodle","Curry Chicken Noodle","Rice porridge"};
            prices = new String[]{"$3", "$3","$3.5O","$3.5O","$3","$3.50","4.50","$4","$4","$4"};
            images = new int[]{R.drawable.roastedchickenrice, R.drawable.steamedchickenrice, R.drawable.roastedduckrice, R.drawable.charsiewrice, R.drawable.roastedporkrice, R.drawable.roastedporknoodle, R.drawable.roastedducknoodle, R.drawable.charsiewwantonnoodle, R.drawable.riceporridge};
            customAdapter.notifyDataSetChanged();
            count++;


        }else if (position == 4 ){
            stalls = null;
            stalls = new String[]{"Butter chicken","Chicken 65", "South Indian meal", "Oaratha set" , "Egg Prata", "Garlic naan","Chappathi set","Tandoori","Fried rice","Chicken masala"};
            prices = new String[]{"$3.50", "$4","$4.50","$3.50","$1.50","$1","$2.50","$4","$3","$3.50"};
            images = new int[]{R.drawable.butterchicken, R.drawable.chicken65, R.drawable.southindianmeal, R.drawable.oarathaset, R.drawable.eggprata, R.drawable.garlicnaan, R.drawable.chappathiset, R.drawable.tandoori, R.drawable.friedrice, R.drawable.chickenmasala};
            customAdapter.notifyDataSetChanged();
            count++;


        } else if (position == 5 ) {
            stalls = null;
            stalls = new String[]{"Fish and chips","Tomato pasta", "Chicken cutlet", "Breakfast set" , "Cheese Fries", "Aglio olio","Chilled australian striploin S grade 180G","Honey soy chicken","Beef burger set","Mushroom cream pasta"};
            prices = new String[]{"$4.50", "$3.50","$3.50","$3","$2.90","$3","$6","$4","$5","$3"};
            images = new int[]{R.drawable.fishandchips, R.drawable.tomatpasta, R.drawable.chickencutlet, R.drawable.breakfastset, R.drawable.cheesefries, R.drawable.aglioolio, R.drawable.chilledaustraliantriploin, R.drawable.honeysoychicken, R.drawable.beefburgerset, R.drawable.mushroomcreampasta};
            customAdapter.notifyDataSetChanged();
            count++;


        }else if (position == 6){
            stalls = null;
            stalls = new String[]{"Nasi Lemak Set","Ayam Penyet", "Ikan Penyet", "Lontong" , "Mee Rebus","Mee Soto","Economical Beehoon","Mee Goreng","Briyani", "Curry Puff"};
            prices = new String[]{"$4", "$3.50","$3.50","$3","$4.50","$3.50","$2","$3","$2.50","$0.50"};
            images = new int[]{R.drawable.yanpenyet,R.drawable.ayanpenyet, R.drawable.ikanpenyet, R.drawable.lontong, R.drawable.meesoto, R.drawable.economicalbeehoon, R.drawable.meegoreng, R.drawable.briyani, R.drawable.currypuff};
            customAdapter.notifyDataSetChanged();
            count++;



        }else if(position== 7 ){
            stalls = null;
            stalls = new String[]{"Mala hotpot","Mala Xiang Guo", "Spicy Fried Chicken","GreenPepper w sliced potato" , "Sichuan Boiled Beef","Minced Pork Rice", "Sauteed Pork w Pepper & Chilli","Olive Stir Fried Green Bean","Braised Beef Rice"};
            prices = new String[]{"$6.50", "$5.50","5.50","$4","$5.50","$5","$5.50","$3","$4.50","$5"};
            images = new int[]{R.drawable.malahotpot, R.drawable.malaxiangguo, R.drawable.spicyfriedchicken, R.drawable.greenpepperwithslicedpotato, R.drawable.sichuanboiledbeef, R.drawable.sauteedporkwithpepperandchilli, R.drawable.olivestirfriedgreenbean, R.drawable.braisedbeefrice};
            customAdapter.notifyDataSetChanged();
            count++;



        }else if (position == 8 ){
            stalls = null;
            stalls = new String[]{"Milk","Coke", "SoyBean Drink", "Coffee plus milo", "Milo" , "Milk tea","Cafe Latte","Espresso","Tuna sandwich","Chocolate cake"};
            prices = new String[]{"$1.20", "$1.30","$1.20","$1.70","$1.50","$1.50","$4","$2","$2.40","$5.50"};
            images = new int[]{R.drawable.milk, R.drawable.coke, R.drawable.soymilk, R.drawable.coffeeplusmilo, R.drawable.milo, R.drawable.milktea, R.drawable.cafelatte, R.drawable.expresso, R.drawable.tunasandwich, R.drawable.chocolatecake};
            customAdapter.notifyDataSetChanged();
            count++;


        }else if(position == 9 ){
            stalls = null;
            stalls = new String[]{"Apple juice","Pineapple juice", "Watermelon juice", "Soursop + DragonFruit Juice", "Kiwi juice" , "Orange juice","Carrot juice","Grape juice","Mango juice","Lime juice"};
            prices = new String[]{"$2", "$2.50","$2.50","$3","$2.50","$2","$2","$2","$2.50","$2.50"};
            images = new int[]{R.drawable.apple, R.drawable.pineapple, R.drawable.watermelon, R.drawable.dragonfruit, R.drawable.kiwi, R.drawable.orange, R.drawable.carrot,R.drawable.grape, R.drawable.mango, R.drawable.lime};
            customAdapter.notifyDataSetChanged();
            count++;


        }




        gridView.setClickable(true);




        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                foodQuantity = (TextView)view.findViewById(R.id.foodQuantity);
                if(foodQuantity.getText().toString().equals("Selected")){
                    foodQuantity.setText("Unselected");
                    view.setBackgroundColor(getResources().getColor(R.color.iron));
                    selectedItems.remove(stalls[position] + "\t\t\t\t" + prices[position]);
                }
                else{
                    foodQuantity.setText("Selected");
                    view.setBackgroundColor(getResources().getColor(R.color.aluminum));
                    selectedItems.add(stalls[position] + "\t\t\t\t" + prices[position]);
                }
            }
        });

        Button orderBtn = findViewById(R.id.confirmOrderBtn);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectedItems.size()==0){
                    Toast.makeText(FoodItemActivity.this, "You have not selected any food.", Toast.LENGTH_LONG).show();
                }
                else{
                    startActivity(new Intent(getApplicationContext(), OrderActivity.class));
                }
            }
        });



       // selectionCounter +=1;
//        Log.i("clicked in gridview ",selectedItems.get(selectionCounter-2));


               // Intent intent = new Intent (FoodItemActivity.this, OrderActivity.class);

                //intent.putExtra("pos", pos);
                //startActivity(intent);




    }
//    public void clickQuantity(View view){
//        TextView tv = (TextView) view;
//        View a = view.getRootView().findViewById(R.id.quantity);
//
//        TextView toUpdate = (TextView) a.findViewById(R.id.foodQuantity);
//        String currentText = toUpdate.getText().toString();
//        String[] split = currentText.split(" ");
//        int currentNum = Integer.parseInt(split[1]);
//        if(tv.getId()==R.id.addItem){
//            currentNum += 1;
//            toUpdate.setText("x " + currentNum);
//        }
//        if(tv.getId()==R.id.subtractItem){
//            currentNum -= 1;
//            toUpdate.setText("x " + currentNum);
//        }
//
//
//    }

    class CustomAdapter extends BaseAdapter {

        String itemSelected;
        TextView stallNameTV, priceTV, quantity;

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return stallNameTV.getText() + " " + priceTV.getText();
           // return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view =  getLayoutInflater().inflate(R.layout.custom_grid_layout, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageViewGV);
            stallNameTV = (TextView) view.findViewById(R.id.stallNameGV);
            priceTV = (TextView) view.findViewById(R.id.priceTV);

            imageView.setImageResource(images[i]);
            stallNameTV.setText(stalls[i]);
            priceTV.setText(prices[i]);

            return view;
        }
    }
}
