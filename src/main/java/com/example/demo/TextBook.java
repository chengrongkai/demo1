package com.example.demo;


public class TextBook extends Book{
    private String category;

    public TextBook(String t,double p,String c){
        super(t,p);
        this.category = c;
    }

    @Override
    public void show(){
        super.show();
        System.out.println("分类:"+this.category);
    }

}
