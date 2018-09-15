package com.example.mathmurder.tablehitch;

import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FoodStallsActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView listView;

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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_stalls);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        listView = (ListView) findViewById(R.id.stallListV);



     /*   final List<String> stalls_list = new ArrayList<String>(Arrays.asList(stalls));

         ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, stalls_list); */


     /*   try{
            Scanner inFile1 = new Scanner(new File("economic_rice_menu.txt"));

            StringBuilder sb = new Stringbuilder();
            while(inFile1.hasNext()) {
                sb.append(inFile1.nextLine());
            }

            String[] yourArray = sb.toString().split(", ");


        }
        catch(Exception e){

        }*/

         final CustomAdapter customAdapter = new CustomAdapter();
         listView.setAdapter(customAdapter);


        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                if (position == 0){
                    System.out.println("print");
                    stalls = null;
                    stalls = new String[]{"Ban Mian", "Fried Tofu", "Eggplant", "Potatoes", "Sausage", "Pork", "Beef", "Fish", "Fried Chicken"};

                    customAdapter.notifyDataSetChanged();


                } else if(position == 1){
                    stalls = null;
                    stalls = new String[]{"Chicken Ramen", "BBQ chicken set", "Omelette Rice" , "Bimbimbap", "Bulgogi","Gimbap","Fish Curry Rice","Tteok-booki", "Chicken + Prawn Bento"};

                    customAdapter.notifyDataSetChanged();

                } else if(position ==2){
                    stalls = null;
                    stalls = new String[]{"Vietnamese Braised Chicken","Thai Tom Yum Seafood Soup","Vietnamese Grilled Pork w Rice & Egg", "Phad Thai w/Egg" , "Vermicelli w/ Grilled Pork & Fried Spring Roll","Thai Basil Leaf Minced Chicken Set", "Viet Sliced Beef Kway Teow Soup","Thai Tom Yum Fried Mee", "Vietnamese Style Drumstick Wrap w Glutinous Rice"};

                    customAdapter.notifyDataSetChanged();


                }else if (position == 3){
                    stalls = null;
                    stalls = new String[]{"Roasted chicken rice","Steamed chicken rice", "Char siew rice", "Roasted pork rice" , "Roasted pork noodle","Roasted pork noodle", "Roasted duck noodle","Curry Chicken Noodle","Rice porridge"};

                    customAdapter.notifyDataSetChanged();

                }else if (position == 4){
                    stalls = null;
                    stalls = new String[]{"Butter chicken","Chicken 65", "South Indian meal", "Oaratha set" , "Garlic naan","Chappathi set","Tandoori","Fried rice","Chicken masala"};

                    customAdapter.notifyDataSetChanged();

                } else if (position == 5) {
                    stalls = null;
                    stalls = new String[]{"Fish and chips","Tomato pasta", "Chicken cutlet", "Breakfast set" , "Aglio olio","Chilled australian striploin S grade 180G","Honey soy chicken","Beef burger set","Mushroom cream pasta"};

                    customAdapter.notifyDataSetChanged();

                }else if (position == 6){
                    stalls = null;
                    stalls = new String[]{"Nasi Lemak Set","Ayam Penyet", "Ikan Penyet", "Lontong" , "Mee Rebus","Mee Soto","Economical Beehoon","Mee Goreng","Briyani"};

                    customAdapter.notifyDataSetChanged();


                }else if(position== 7){
                    stalls = null;
                    stalls = new String[]{"Mala hotpot","Mala Xiang Guo", "Spicy Fried Chicken","GreenPepper w sliced potato" , "Sichuan Boiled Beef","Minced Pork Rice", "Sauteed Pork w Pepper & Chilli","Olive Stir Fried Green Bean","Braised Beef Rice"};

                    customAdapter.notifyDataSetChanged();


                }else if (position == 8){
                    stalls = null;
                    stalls = new String[]{"Milk","Coke", "Coffee plus milo", "Milo" , "Milk tea","Cafe Latte","Espresso","Tuna sandwich","Chocolate cake"};

                    customAdapter.notifyDataSetChanged();

                }else if(position == 9){
                    stalls = null;
                    stalls = new String[]{"Apple juice","Pineapple juice", "Watermelon juice", "Kiwi juice" , "Orange juice","Carrot juice","Grape juice","Mango juice","Lime juice"};

                    customAdapter.notifyDataSetChanged();

                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.food_stalls, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.profileNav) {
            // Handle the camera action
        } else if (id == R.id.seatNav) {

        } else if (id == R.id.foodNav) {

        } else if (id == R.id.payNav) {

        } else if (id == R.id.rewardNav) {

        } else if (id == R.id.historyNav) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    class CustomAdapter extends BaseAdapter{

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
            view =  getLayoutInflater().inflate(R.layout.custom_layout, null);

            ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
            TextView stallNameTV = (TextView) view.findViewById(R.id.stallName);

            imageView.setImageResource(images[i]);
            stallNameTV.setText(stalls[i]);

            return view;
        }
    }
}
