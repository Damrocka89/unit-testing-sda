package foo.bar.Temperature;

import java.math.BigDecimal;

public class Kelvin implements TemperatureUnit {

    public static final BigDecimal KELVIN_TO_CELSIUS = new BigDecimal("-272.15").setScale(SCALE,ROUNDING_MODE);
    public static final BigDecimal KELVIN_TO_FAHRENHEIT = new BigDecimal("-457.87").setScale(SCALE,ROUNDING_MODE);


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




}
