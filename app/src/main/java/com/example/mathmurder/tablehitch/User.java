package com.example.mathmurder.tablehitch;

import java.util.ArrayList;

public class User {

    String id, name, age, gender, profile;
    static int rewardPoints = 0;
    private static ArrayList<Integer> bookedSeats;
    private static User instance = null;


    public User(){
        User.bookedSeats = new ArrayList<>();
    }

    public User(String id, String name, String age, String gender, String profile){
        User.bookedSeats = new ArrayList<>();
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.profile = profile;
    }

    public static void addRewardPoint(int point) {
        rewardPoints += point;

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
