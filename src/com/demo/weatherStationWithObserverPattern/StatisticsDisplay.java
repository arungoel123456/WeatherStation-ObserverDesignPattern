package com.demo.weatherStationWithObserverPattern;

public class StatisticsDisplay implements Observer{
    public void update(int temp, int humidity, int pressure){
        // logic
        System.out.println("according to stats, this day day is going to be hot");
    }
}
