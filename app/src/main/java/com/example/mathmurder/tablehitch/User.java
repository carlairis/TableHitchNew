package com.example.mathmurder.tablehitch;

import java.util.ArrayList;

public class User {


    private static ArrayList<Integer> bookedSeats;
    private static User instance = null;


    public User(){
        User.bookedSeats = new ArrayList<>();
    }


    public static ArrayList<Integer> getBookedSeats() {
        return bookedSeats;
    }

    public static void setBookedSeats(ArrayList<Integer> bookedSeats) {
        User.bookedSeats = bookedSeats;
    }

    public static User getInstance() {
        if(instance == null) {
            instance = new User();
        }
        return instance;
    }

    public static void clearInstance() {
        User.instance = null;
    }
}
