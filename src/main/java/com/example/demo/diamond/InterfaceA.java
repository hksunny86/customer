package com.example.demo.diamond;

public interface InterfaceA {
    default void display(){
        System.out.println("Interface A");
    }
}
