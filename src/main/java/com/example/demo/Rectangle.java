package com.example.demo;


public class Rectangle {
    private double length;

    private double width;

    public Rectangle(double width,double length){
        this.width = width;
        this.length = length;
    }


    /**
     * 获取面积
     * @return
     */
    public double getArea(){
        return this.width*this.length;
    }

    /**
     * 获取周长
     * @return
     */
    public double getPerimeter(){
        return 2*(this.width+this.length);
    }
}
