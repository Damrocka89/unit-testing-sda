package foo.bar.meteorology.weather;

import java.util.Objects;

public class Weather {

    private int temprature;
    private int windSpeed;
    private int rainfall;

    public Weather(int temprature, int windSpeed, int rainfall) {
        this.temprature = temprature;
        this.windSpeed = windSpeed;
        this.rainfall = rainfall;
    }

    public int getTemprature() {
        return temprature;
    }

    public int getWindSpeed() {
        return windSpeed;
    }

    public int getRainfall() {
        return rainfall;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "temprature=" + temprature + " C " +
                ", windSpeed=" + windSpeed + " km/h " +
                ", rainfall=" + rainfall + " mm/day " +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return temprature == weather.temprature &&
                windSpeed == weather.windSpeed &&
                rainfall == weather.rainfall;
    }

    @Override
    public int hashCode() {
        return Objects.hash(temprature, windSpeed, rainfall);
    }
}
