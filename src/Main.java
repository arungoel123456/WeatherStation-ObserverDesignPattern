public class Main {
    public static void main(String[] args) {
        WeatherDataService weatherDataService= new WeatherDataService();

        weatherDataService.setTemp(21);
        weatherDataService.setHumidity(100);
        weatherDataService.setPressure(200);

        weatherDataService.setTemp(30);

    }
}