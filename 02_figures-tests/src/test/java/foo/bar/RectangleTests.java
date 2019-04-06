package foo.bar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTests {

    @ParameterizedTest(name = "Area of rectangle ({0}) ({1}) should be {2}")
    @CsvSource({
            "0, 0, 0",
            "1, 1, 1",
            "2, 1, 2"
    })
    void areaOfRectangle(int a, int b, int expected){
        Rectangle rectangle=new Rectangle(a, b);
        assertEquals(expected, rectangle.area(), "Area of square is different than expected");
    }

    @ParameterizedTest(name = "Circumference of rectangle ({0}) ({1}) should be {2}")
    @CsvSource({
            "0, 0, 0",
            "1, 1, 4",
            "2, 2, 8"
    })
    void circumferenceOfRectangle(int a, int b, int expected){
        Rectangle rectangle= new Rectangle(a,b);
        assertEquals(expected, rectangle.circumference(),"Circumference of rectangle different than expected");
    }
}
