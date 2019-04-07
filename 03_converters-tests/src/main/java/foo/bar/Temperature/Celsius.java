package foo.bar.Temperature;

import java.math.BigDecimal;

public class Celsius implements TemperatureUnit {

    private final BigDecimal value;

    public Celsius(BigDecimal value) {
        if (BigDecimal.valueOf(-273.15).compareTo(value)>0){
    throw  new IllegalArgumentException("Temperature can't be below -273.15C");
        }
        this.value = value.setScale(SCALE,ROUNDING_MODE);
    }

    public BigDecimal getValue() {
        return value;
    }

    public Fahrenheit toFahreheit(){
        return new Fahrenheit(value.multiply(BigDecimal.valueOf(1.8)).subtract(Fahrenheit.FAHREHEIT_TO_CELSIUS).setScale(SCALE,ROUNDING_MODE));
    }

    public Kelvin toKelvin(){
        return new Kelvin(value.subtract(Kelvin.KELVIN_TO_CELSIUS).setScale(SCALE,ROUNDING_MODE));
    }

}
