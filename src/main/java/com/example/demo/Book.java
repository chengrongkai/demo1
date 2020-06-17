package com.example.demo;


public class Book {
    private String title = null;

    private double price = 2.0;

    public Book(){

    }

    public Book(String t,double p){
        this.title = t;
        this.price = p;
    }

    public void show(){
        System.out.println("书名:"+this.title+";价格:"+this.price);
    }
}
