package com.demo.weatherStationWithObserverPattern;

public class CurrentConditionsDisplay implements Observer{
    public void update(int temp, int humidity, int pressure){
        System.out.println("Current conditions are, temp: " + temp + " pressure: "+ pressure+ " humidity: " + humidity);
    }
}
