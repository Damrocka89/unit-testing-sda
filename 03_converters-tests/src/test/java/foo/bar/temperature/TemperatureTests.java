package foo.bar.temperature;

import foo.bar.Temperature.Celsius;
import foo.bar.Temperature.Fahrenheit;
import foo.bar.Temperature.Kelvin;
import foo.bar.length.Inch;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TemperatureTests {

    @Test
    void shouldConvertZeroToZeroCelsiusValue() {
        Celsius c=new Fahrenheit(BigDecimal.ZERO).toCelsius();
        assertEquals(-32.00, c.getValue());
    }

    @Test
    void shouldConvertToZeroKelvinValue() {
        Kelvin k = new Celsius(BigDecimal.ZERO).toKelvin();
        assertEquals(273.15, k.getValue());
    }

    @Test
    void shouldConvertToZeroFahrenheitValue() {
        Fahrenheit f = new Kelvin(BigDecimal.ZERO).toFahrenhieut();
        assertEquals(BigDecimal.ZERO.setScale(2), f.getValue());
    }

    @Test
    void shouldntAcceptNegativeLengthInInches() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new Inch(new BigDecimal(-1))
        );
        assertEquals("Length can't be negative!", exception.getMessage());
    }
}
