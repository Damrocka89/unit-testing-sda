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
// public Inch toInches() {
//        return new Inch(value.divide(Inch.INCH_TO_CENTIMETER, SCALE, ROUNDING_MODE));
//    }

    public Fahrenheit toFahreheit(){
        
    }

}
