package com.example.demo;

import java.util.Scanner;


public class Test1 {
    public static void main(String[] args) {
        Rectangle[] r = new Rectangle[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter length and width:");
        String input = sc.nextLine();
        String[] strings = input.split(" ");
        double length= Double.valueOf(strings[0]);
        double width= Double.valueOf(strings[1]);
        r[0] = new Rectangle(width,length);
        System.out.println("Perimeter:"+r[0].getPerimeter());

        System.out.println("Area:"+r[0].getArea());

    }
}
