package com.demo.weatherStationWithoutObserverDesignPattern;

public class WeatherData {
    private int pressure;
    private int temp;
    private int humidity;

    public WeatherData(){
        pressure= 0;
        temp= 0;
        humidity=0;
    }

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure = pressure;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }
}
