package com.demo.weatherStationWithoutObserverDesignPattern;

public class ForecastDisplay {
    public void update(int temp, int humidity, int pressure){
        System.out.println("I am forecasting that today's max temp will be " + temp+10);
    }
}
