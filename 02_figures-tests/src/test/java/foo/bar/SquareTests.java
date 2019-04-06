package foo.bar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquareTests {



    @ParameterizedTest(name = "Area of square({0}) should be {1}")
    @CsvSource({
                 "0, 0",
                 "1, 1",
                 "10, 100"
    })
    @CsvFileSource(resources = "/figures.csv", numLinesToSkip = 1)
    void areaOfSquare(int a, int expectedArea) {
        Square square = new Square(a);
        assertEquals(expectedArea, square.area(), "Area of square is different than expected");
    }

    @ParameterizedTest(name="Circumference of square ({0}) should be {1}")
    @CsvSource({
            "0, 0",
            "1, 4",
            "10, 40"
    })
    @CsvFileSource(resources = "/circumference.csv", numLinesToSkip = 0)
    void circumferenceOfSquare(int a, int expected){
        Square square = new Square(a);
        assertEquals(expected, square.circumference(),  "Circumference of square is different than expected");
    }


}
