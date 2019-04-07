package foo.bar.Temperature;

import java.math.BigDecimal;

public class Kelvin implements TemperatureUnit {

    public static final BigDecimal KELVIN_TO_CELSIUS = new BigDecimal("-273.15").setScale(SCALE,ROUNDING_MODE);


    private final BigDecimal value;

    public Kelvin(BigDecimal value) {

        if (BigDecimal.valueOf(0).compareTo(value)>0){
            throw new IllegalArgumentException("Temperature can't be lower than -459.67F");
        }
        this.value = value.setScale(SCALE, ROUNDING_MODE);
    }

    public BigDecimal getValue() {
        return value;
    }

    public Celsius toCelsius(){
        return new Celsius(value.add(KELVIN_TO_CELSIUS).setScale(SCALE,ROUNDING_MODE));
    }

    public Fahrenheit toFahrenhieut() {
        return new Fahrenheit(toCelsius().getValue().multiply(BigDecimal.valueOf(9 / 5))
                .subtract(Fahrenheit.FAHREHEIT_TO_CELSIUS).setScale(SCALE,ROUNDING_MODE));


    }
}
