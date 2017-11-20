package com.starbucks;

public abstract class Beverage{
    public String description = "Unkown Beverage";

    public String getDescription(){
        return description;
    }

    public abstract double cost();
}
