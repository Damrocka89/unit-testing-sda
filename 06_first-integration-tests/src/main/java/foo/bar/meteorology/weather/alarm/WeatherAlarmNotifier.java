package foo.bar.meteorology.weather.alarm;

import foo.bar.meteorology.weather.Weather;
import foo.bar.meteorology.weather.WeatherService;

public class WeatherAlarmNotifier {

    private WeatherService weatherService;

    public WeatherAlarmNotifier(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public WeatherAlarmLevel raiseLevelIfNeccessary() {
        Weather weather = weatherService.getWeather();
       WeatherAlarmLevel weatherAlarmLevel=WeatherAlarmLevel.ALL_OK;
       int countAlarms=0;
       if (weather.getTemprature()>35){
           weatherAlarmLevel=WeatherAlarmLevel.SECOND_LEVEL;
           countAlarms++;
       }
       if (weather.getRainfall()>100){
           weatherAlarmLevel=WeatherAlarmLevel.THIRD_LEVEL;
           countAlarms++;
       }
       if (weather.getWindSpeed()>100){
           weatherAlarmLevel=WeatherAlarmLevel.SECOND_LEVEL;
           countAlarms++;
       }

        return countAlarms>=2? WeatherAlarmLevel.FIRST_LEVEL:weatherAlarmLevel;
    }
}
