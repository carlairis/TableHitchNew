package com.example.mathmurder.tablehitch;

import java.util.ArrayList;

public class Table {

    public  String tableID;
    public  String status;


    public  ArrayList<Integer> sharedTables;


    public  ArrayList<Integer> getSharedTables() {
        return sharedTables;
    }

    public  void setSharedTables(ArrayList<Integer> sharedTables) {
        this.sharedTables = sharedTables;
    }



    public Table(){
        this.sharedTables = new ArrayList<>();
    }

}
