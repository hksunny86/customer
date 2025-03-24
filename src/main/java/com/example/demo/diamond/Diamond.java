package com.example.demo.diamond;

public class Diamond implements InterfaceA, InterfaceB {
    @Override
    public void display() {
        InterfaceA.super.display();
        InterfaceB.super.display();
        System.out.println("Diamond Clas");
    }

    public static void main(String[] args) {
        Diamond diamond = new Diamond();
        diamond.display();
    }
}
