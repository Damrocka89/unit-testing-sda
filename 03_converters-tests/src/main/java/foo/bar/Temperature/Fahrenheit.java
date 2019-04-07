package foo.bar.Temperature;

import java.math.BigDecimal;

public class Fahrenheit implements TemperatureUnit {

    public static final BigDecimal FAHREHEIT_TO_CELSIUS =new BigDecimal("-32").setScale(SCALE,ROUNDING_MODE);


    private final BigDecimal value;

    public Fahrenheit(BigDecimal value) {

        if (BigDecimal.valueOf(-459.67).compareTo(value)>0){
            throw new IllegalArgumentException("Temperature can't be lower than -459.67F");
        }
        this.value = value.setScale(SCALE, ROUNDING_MODE);
    }

    public BigDecimal getValue() {
        return value;
    }
    public Celsius toCelsius(){
        return new Celsius(value.add(Fahrenheit.FAHREHEIT_TO_CELSIUS).multiply(BigDecimal.valueOf(0.555555))
                .setScale(SCALE,ROUNDING_MODE));
    }

    public Kelvin toKelvin(){
        return new Kelvin(toCelsius().getValue().subtract(Kelvin.KELVIN_TO_CELSIUS));
    }



}
