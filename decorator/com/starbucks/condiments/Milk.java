package com.starbucks.condiments;

import com.starbucks.Beverage;
import com.starbucks.CondimentDecorator;

// Milk是一个装饰者，所以让他扩展自 CondimentDecorator
// CondimentDecorator扩展自 Beverage
public class Milk extends CondimentDecorator{
    Beverage beverage;

    public Milk(Beverage beverage){
        this.beverage = beverage;
    }

    // 我们希望不只是描述饮料，而是完整的连调料都描述出来。
    // 所以首先利用委托的做法，得到一个叙述，然后在其后加上附加的叙述
    public String getDescription(){
        return beverage.getDescription() + ",Milk";
    }

    public double cost(){
        // 要计算带Milk的价钱。首先把调用委托给被装饰对象，以计算价钱
        // 然后再加上Milk的价钱，得到最后结果。
        return beverage.cost() + 0.1;
    }
}
