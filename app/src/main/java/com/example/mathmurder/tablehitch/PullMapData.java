package com.example.mathmurder.tablehitch;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import static android.content.ContentValues.TAG;

public class PullMapData {



    private FirebaseDatabase database = FirebaseDatabase.getInstance();

    public DatabaseReference getmDatabase() {
        return mDatabase;
    }

    private DatabaseReference mDatabase = database.getReference("tablehitch");
    private static final String LOG_TAG = PullMapData.class.getSimpleName();

    private String seatStatus;

    private Seat seat;

    private HashMap<Integer, Integer> seatsMap = new HashMap<>();

    int x= 0;

    int count =0;
    private int tableID = 0;

    private Boolean sharing= false;

    // Write a message to the database
 //   DatabaseReference myRef = database.getReference("message");

    public void doSomething(){
     //   mDatabase.setValue("Hello, World!");
        // Read from the database
        mDatabase.addChildEventListener(new ChildEventListener() {
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
                System.out.println("size here"+Seat.getSeatsStatus().size());

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
    }

    public void writeNewSeat( int seatId, int status) {
      //  Seat seat = new Seat(seatId, status);

        mDatabase.getParent().child("seat "+seatId).setValue(status);
        Log.d(LOG_TAG, "this works");
    }

    public void readNewSeat(DataSnapshot snapshot){
        System.out.println("tit goes here");


        for (DataSnapshot ds: snapshot.getChildren()){
          //  Seat seat = new Seat();
            for (int x= 0; x<42; x++ ){
                seatsMap.put(x+1,ds.child("seat "+(x+1)).getValue(Seat.class).getStatus());

            }
            System.out.println("this is in the map = "+ seatsMap.get(3));
            Seat.setSeatsStatus(seatsMap);

        }
     /*   for(int i = 1; i <8 ; i++){
            DatabaseReference database = FirebaseDatabase.getInstance().getReference();

            DatabaseReference ref = database.child("seat"+i);
            System.out.println("ref= "+ref.toString());

        }*/


    }

    public void bookSeats(int seatNb){
        // for NON sharing table
        if(!LoadingActivity.cancelledClick) {
            for(int i = 0; i<seatNb; i++){
                for (int e = 1; e<Seat.getSeatsStatus().size(); e++){
                    //if(Seat.getSeatsStatus().get(e+1) == 0 && count < seatNb){
                    if(Seat.getSeatsStatus().get(e) == 0 && count < seatNb){

                        writeNewSeat(e+1, 2);
                        User.getInstance().getBookedSeats().add(e+1);

                        count++;

                    }

                }
        }

//add line here to check if the seat is taken, if not, give it to the person and change it's status)

        }
    }






    public void bookSharingSeatsV2(int seatNb){
        //used for SHARING table with anyone
        //numbers,
        if(!LoadingActivity.cancelledClick){
            System.out.println("goes there");
            for (int i = 0; i<seatNb; i++){

                //i is num of ppl
               // System.out.println("shared table one");

                for (int e = 1; e<9; e++){
                    System.out.println("shared table two");

                    if(Seat.getSeatsStatus().get(e)!=0 && count < seatNb){

                        writeNewSeat(e+1+i, 2);
                        User.getInstance().getBookedSeats().add(e+1+i);

                        System.out.println("shared table");
                        count++;

                    }
                }


                for (int e = 9; e<13; e++){
                    System.out.println("shared table one");

                    if(Seat.getSeatsStatus().get(e)!=0 && count < seatNb){
                        System.out.println("shared table two");

                        writeNewSeat(e+1+i, 2);
                        User.getBookedSeats().add(e+1+i);


                        count++;

                        System.out.println("count"+count);
                    }
                }


                for (int e = 13; e<21; e++){

                    if(Seat.getSeatsStatus().get(e)!=0  && count<seatNb){

                        writeNewSeat(e+1+i, 2);
                        User.getInstance().getBookedSeats().add(e+1+i);

                        System.out.println("shared table");
                        count++;

                    }
                }


                for (int e = 21; e<25; e++){

                    if(Seat.getSeatsStatus().get(e)!=0 && count<seatNb && e!=24){

                        writeNewSeat(e+1+i, 2);
                        User.getInstance().getBookedSeats().add(e+1+i);

                        System.out.println("shared table");
                        count++;

                    }
                }

            }
            User.rewardPoints += 50;
        }


    }


    public void fillTables(){
        for(int a = 0; a<Seat.getSeatsStatus().size(); a++){
            System.out.println("this is a = "+ a+1);
            System.out.println("this is the seat id = "+ Seat.getSeatsStatus().get(a+1));

            if(a >0 && a<9){
                Seat.getTable1().add((a+1), Seat.getSeatsStatus().get(a+1));
            }else if(a >8 && a<13){
                Seat.getTable2().add((a+1), Seat.getSeatsStatus().get(a+1));

            }else if(a >12 && a<21){
                Seat.getTable3().add((a+1), Seat.getSeatsStatus().get(a+1));

            }else if(a >20 && a<25){
                Seat.getTable4().add((a+1), Seat.getSeatsStatus().get(a+1));

            }
        }
    }



}
