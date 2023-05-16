package com.demo.weatherStationWithObserverPattern;

public interface Observer {
    void update(int temp, int humidity, int pressure);
}
