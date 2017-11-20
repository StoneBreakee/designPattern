package com.starbucks.coffees;

import com.starbucks.Beverage;

public class Espresso extends Beverage{
    public Espresso(){
        description = "Espresso";
    }

    public double cost(){
        return 1.99;
    }
}
