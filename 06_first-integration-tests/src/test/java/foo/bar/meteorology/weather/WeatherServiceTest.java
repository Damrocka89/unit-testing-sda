package foo.bar.meteorology.weather;

import foo.bar.meteorology.weather.external.RainfallProvider;
import foo.bar.meteorology.weather.external.TemperatureProvider;
import foo.bar.meteorology.weather.external.WindSpeedProvider;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class WeatherServiceTest {

    private WeatherService weatherService =
            new WeatherService(
                    new TemperatureProvider(),
                    new RainfallProvider(),
                    new WindSpeedProvider()
            );

    @Test
    void testWeatherService() {
        Weather weather = weatherService.getWeather();
        Logger.getLogger("JUnit 5").info("Current weather : " + weather.toString());

        Assertions.assertNotNull(weather);
    }

    TemperatureProvider temperatureProviderMock = mock(TemperatureProvider.class);
    RainfallProvider rainfallProviderMock = mock(RainfallProvider.class);
    WindSpeedProvider windSpeedProviderMock = mock(WindSpeedProvider.class);

    private WeatherService weatherServiceWithMock =
            new WeatherService(
                    temperatureProviderMock,
                    rainfallProviderMock,
                    windSpeedProviderMock);

    @Test
    void testWeatherServiceWithMock() {
        when(temperatureProviderMock.getTemperature())
                .thenReturn(36)
                .thenReturn(0);
        when(windSpeedProviderMock.getWindSpeed())
                .thenReturn(0)
                .thenReturn(15);
        when(rainfallProviderMock.getRainfallLevel())
                .thenReturn(0)
                .thenReturn(110);

        Weather firstWeather=weatherServiceWithMock.getWeather();
        Weather secondWeather=weatherServiceWithMock.getWeather();

        Assertions.assertEquals(new Weather(36,0,0),firstWeather);
        Assertions.assertEquals(new Weather(0,15,110),secondWeather);

    }

}
