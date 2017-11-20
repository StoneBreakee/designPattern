package com.starbucks.condiments;

import com.starbucks.Beverage;
import com.starbucks.CondimentDecorator;

// Whip是一个装饰者，所以让他扩展自 CondimentDecorator
// CondimentDecorator扩展自 Beverage
public class Whip extends CondimentDecorator{
    Beverage beverage;

    public Whip(Beverage beverage){
        this.beverage = beverage;
    }

    // 我们希望不只是描述饮料，而是完整的连调料都描述出来。
    // 所以首先利用委托的做法，得到一个叙述，然后在其后加上附加的叙述
    public String getDescription(){
        return beverage.getDescription() + ",Whip";
    }

    public double cost(){
        // 要计算带Whip的价钱。首先把调用委托给被装饰对象，以计算价钱
        // 然后再加上Whip的价钱，得到最后结果。
        return beverage.cost() + 0.1;
    }
}
