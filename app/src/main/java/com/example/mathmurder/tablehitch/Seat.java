package com.example.mathmurder.tablehitch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Seat {

    private static int seatId;
    private static int status;

    private static HashMap<Integer, Integer> seatsStatus;



    private static ArrayList<Integer> table1;
    private static ArrayList<Integer> table2;
    private static ArrayList<Integer> table3;
    private static ArrayList<Integer> table4;


    private static Seat instance = null;

    public static int getSeatId() {
        return seatId;
    }

    public static void setSeatId(int seatId) {
        Seat.seatId = seatId;
    }

    public static int getStatus() {
        return status;
    }

    public static void setSeatStatus(int status) {
        Seat.status = status;
    }

    public static HashMap<Integer, Integer> getSeatsStatus() {
        return seatsStatus;
    }

    public static  void setSeatsStatus(HashMap<Integer, Integer> seatsStatus) {
        Seat.seatsStatus = seatsStatus;
    }



    public static ArrayList<Integer> getTable1() {
        return table1;
    }

    public static ArrayList<Integer> getTable2() {
        return table2;
    }

    public static ArrayList<Integer> getTable3() {
        return table3;
    }

    public static ArrayList<Integer> getTable4() {
        return table4;
    }



   /* public Seat(int seatId, int status){
        this.seatId = seatId;
        this.status = status;
        this.seatsStatus = new HashMap<>();
    }*/


    public Seat(){
    //    this.status = 0;
        Seat.seatsStatus = new HashMap<>();
    }


    public static Seat getInstance() {
        if(instance == null) {
            instance = new Seat();
        }
        return instance;
    }

    public static void clearInstance() {
        Seat.instance = null;
    }

    public static void addSeat(int key, int statu){
        seatsStatus.put(key, statu);
    }

}
