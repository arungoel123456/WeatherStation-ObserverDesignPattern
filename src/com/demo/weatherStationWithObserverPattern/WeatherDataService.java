package com.demo.weatherStationWithObserverPattern;

import java.util.*;

public class WeatherDataService implements Subject{

    private WeatherData weatherData;
    private List<Observer> observers;
    private boolean changed;

    private final Object MUTEX= new Object();

    public WeatherDataService(){
        this.weatherData= new WeatherData();
        observers= new ArrayList<>();
        changed= false;
    }
    @Override
    public void register(Observer observer) {
        synchronized (MUTEX){
            if(!observers.contains(observer)){
                observers.add(observer);
            }
        }
    }

    @Override
    public void unregister(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        if(changed== true){
            for (Observer obj: observers){
                obj.update(weatherData.getTemp(), weatherData.getHumidity(), weatherData.getPressure());
            }
            changed= false;
        }
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
