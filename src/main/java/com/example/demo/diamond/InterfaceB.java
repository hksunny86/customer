package com.example.demo.diamond;

public interface InterfaceB {
    default void display(){
        System.out.println("Interface B");
    }
}
