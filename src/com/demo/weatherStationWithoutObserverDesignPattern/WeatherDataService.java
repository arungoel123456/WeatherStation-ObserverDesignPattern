package com.demo.weatherStationWithoutObserverDesignPattern;

public class WeatherDataService {
    private WeatherData weatherData;
    private CurrentConditionsDisplay currentConditionsDisplay;
    private ForecastDisplay forecastDisplay;
    private StatisticsDisplay statisticsDisplay;

    public WeatherDataService() {
        weatherData = new WeatherData();
        currentConditionsDisplay= new CurrentConditionsDisplay();
        forecastDisplay= new ForecastDisplay();
        statisticsDisplay= new StatisticsDisplay();
    }

    public void measurementChanged(){
        int temp= weatherData.getTemp();
        int pressure= weatherData.getPressure();
        int humidity= weatherData.getHumidity();
        currentConditionsDisplay.update(temp,humidity, pressure);
        forecastDisplay.update(temp,humidity, pressure);
        statisticsDisplay.update(temp,humidity, pressure);
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
