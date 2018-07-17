package com.example.admin.w7d4testing;

import java.util.ArrayList;
import java.util.List;

public class Calculation {

    Addition addition;

    public Calculation(Addition addition) {
        this.addition = addition;
    }

    //testing logic with unit testing
    public int add(int a, int b) {
        return a + b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    //testing with mockito addition class
    public int addTen(int a, int b) {
        return addition.add(a, b) + 10;

//        we dont care about the addition.add(a, b)
//        we only care about if it added the 10
    }


    public void something() {
        addition.something( );
    }

    public int divide(int a, int b) {
        return a / b;
    }

    public List<String> getList() {
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        return strings;
    }


}
