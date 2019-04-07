package foo.bar.meteorology.weather.alarm;

import foo.bar.meteorology.weather.Weather;
import foo.bar.meteorology.weather.WeatherService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class WeatherAlarmNotifierTest {

    WeatherService weatherServiceMock = Mockito.mock(WeatherService.class);

    private WeatherAlarmNotifier alarmNotifier =
            new WeatherAlarmNotifier(weatherServiceMock);


    @ParameterizedTest(name ="For temperature {1}C and windspeed {2}km/h and rainfall {3}mm should raise alarm: {0}")
    @CsvSource({
            "SECOND_LEVEL, 36, 34, 22",
            "SECOND_LEVEL, 30, 120, 0",
            "THIRD_LEVEL, 20, 0, 110",
            "FIRST_LEVEL, 35, 110, 110",
            "ALL_OK, 15, 15, 15"
    })
    void testAlarmNotifierWithMock(WeatherAlarmLevel alarmLevel, int temp, int wind, int rain) {
        Mockito.when(weatherServiceMock.getWeather())
//                .thenReturn(new Weather(36, 34, 22))
//                .thenReturn(new Weather(30, 120, 0))
//                .thenReturn(new Weather(20, 0, 110))
//                .thenReturn(new Weather(35, 110, 110))
                .thenReturn(new Weather(temp, wind, rain));

            Assertions.assertEquals(alarmLevel,alarmNotifier.raiseLevelIfNeccessary());
//        Assertions.assertEquals(WeatherAlarmLevel.SECOND_LEVEL, alarmNotifier.raiseLevelIfNeccessary());
//        Assertions.assertEquals(WeatherAlarmLevel.SECOND_LEVEL, alarmNotifier.raiseLevelIfNeccessary());
//        Assertions.assertEquals(WeatherAlarmLevel.THIRD_LEVEL, alarmNotifier.raiseLevelIfNeccessary());
//        Assertions.assertEquals(WeatherAlarmLevel.FIRST_LEVEL, alarmNotifier.raiseLevelIfNeccessary());
//        Assertions.assertEquals(WeatherAlarmLevel.ALL_OK, alarmNotifier.raiseLevelIfNeccessary());

    }


}
