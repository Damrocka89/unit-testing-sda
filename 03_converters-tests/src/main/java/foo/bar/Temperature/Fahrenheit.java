package foo.bar.Temperature;

import java.math.BigDecimal;

public class Fahrenheit implements TemperatureUnit {

    public static final BigDecimal FAHREHEIT_TO_CELSIUS =new BigDecimal("-17.2222222").setScale(SCALE,ROUNDING_MODE);
    public static final BigDecimal FAHRENHEIT_TO_KELVIN =new BigDecimal("255.927778").setScale(SCALE,ROUNDING_MODE);


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




}
