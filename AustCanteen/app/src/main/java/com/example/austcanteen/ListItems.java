package com.example.austcanteen;

import android.graphics.Bitmap;

/**
 * Created by sifatnabil on 1/22/2018.
 */

public class ListItems {
    private String name;
    private String price;
    private float rating;
    private String availibility;
    private boolean seleceted;
    private int id;
    private String paid;
    private String received;



    private int orderNumber;
    private String url;
    Bitmap bmp;

    public ListItems(String name, String price, float rating, String availibility, Bitmap bmp) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.availibility = availibility;
        this.bmp = bmp;
       // this.url = url;
    }

    public ListItems(String name, String price, float rating, Bitmap bmp) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.bmp = bmp;
    }

    public ListItems(String name, String price, float rating, int id) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.id = id;
    }

    public ListItems(int orderNumber,String name, String price, String paid, String received) {
        this.orderNumber = orderNumber;
        this.name = name;
        this.price = price;
        this.paid = paid;
        this.received = received;
    }


    public String getAvailibility(){
        return availibility;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public float getRating() {
        return rating;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public Bitmap getBmp() {
        return bmp;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return id;
    }

    public String getPaid() {
        return paid;
    }

    public String getReceived() {
        return received;
    }
}
