package com.starbucks.coffees;

import com.starbucks.Beverage;

public class DarkRoast extends Beverage{
    public DarkRoast(){
        description = "DarkRoast";
    }

    public double cost(){
        return 0.99;
    }
}
