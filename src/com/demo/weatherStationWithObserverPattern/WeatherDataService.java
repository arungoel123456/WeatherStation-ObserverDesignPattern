package com.demo.weatherStationWithObserverPattern;

import java.util.*;
import java.util.concurrent.locks.*;

public class WeatherDataService implements Subject{

    private WeatherData weatherData;
    private List<Observer> observers;
    private boolean changed;
    ReentrantLock reentrantLock;

    private final Object MUTEX= new Object();

    public WeatherDataService(){
        this.weatherData= new WeatherData();
        observers= new ArrayList<>();
        changed= false;
        reentrantLock= new ReentrantLock();
    }
    @Override
    public void register(Observer observer) {
        reentrantLock.lock();
        if(!observers.contains(observer)){
            observers.add(observer);
        }
        reentrantLock.unlock();
    }

    @Override
    public void unregister(Observer observer) {
        reentrantLock.lock();
        try{
            observers.remove(observer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        reentrantLock.unlock();
    }

    @Override
    public void notifyObservers() {
        reentrantLock.lock();
        if(changed){
            for (Observer obj: observers){
                obj.update(weatherData.getTemp(), weatherData.getHumidity(), weatherData.getPressure());
            }
            changed= false;
        }
        reentrantLock.unlock();
    }
    public void measurementChanged(){
        this.changed= true;
        notifyObservers();
    }

    public void setPressure(int pressure) {
        weatherData.setPressure(pressure);
        measurementChanged();
    }

    public void setTemp(int temp) {
        weatherData.setTemp(temp);
        measurementChanged();
    }
    public void setHumidity(int humidity) {
        weatherData.setHumidity(humidity);
        measurementChanged();
    }


}
