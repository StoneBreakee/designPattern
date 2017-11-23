package com.gumball;

public class GumballMachineTestDrive{
    public static void main(String[] args){
        int count = 0;

        if(args.length < 2){
            System.out.println("GumballMachine <name> <inventory>");
            System.exit(1);
        }

        count = Integer.parseInt(args[1]);
        GumballMonitor monitor = new GumballMonitor(new GumballMachine(args[0],count));
        monitor.report();
    }
}
