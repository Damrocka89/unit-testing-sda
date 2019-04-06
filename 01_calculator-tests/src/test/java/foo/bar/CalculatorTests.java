package foo.bar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CalculatorTests {

    Calculator calculator = new Calculator();


    @Test
    @DisplayName("1 + 1 = 2")
    void addsTwoNumbers() {
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
    }

    @Test
    @DisplayName("0 + 101 = 101")
    void addsTwoNumbers2() {
        assertEquals(101, calculator.add(0, 101), "0 + 101 should give 101");
    }

    @Test
    @DisplayName("-5 + (-2) = -7")
    void addTwoNumbers3() {
        assertEquals(-7, calculator.add(-5, -2), "-5 + (-2) should give -7");
    }

    @Test
    @DisplayName("-1 + 5 = 4")
    void addTwoNumbers4() {
        assertEquals(4, calculator.add(-1, 5), "-1 + 5 should give 4");
    }

    @Test
    @DisplayName("1 - 1 = 0")
    void subtractTwoNumbers1() {
        assertEquals(0, calculator.subtract(1, 1), "1 - 1 should give 0");
    }

    @Test
    @DisplayName("0 - 101 = -101")
    void subtractTwoNumbers2() {
        assertEquals(-101, calculator.subtract(0, 101), "0 - 101 should give -101");
    }

    @Test
    @DisplayName("0 * 5 = 0")
    void multiplyZeroAndFive() {
        assertEquals(0, calculator.multiply(0, 5), "0 * 5 should give 0");
    }

    @Test
    @DisplayName("15 - 0 = 15")
    void subtractTwoNumbers3() {
        assertEquals(15, calculator.subtract(15, 0), "15 - 0 should give 15");
    }

    @Test
    @DisplayName("(-1) * 1 = -1")
    void multiplyMinusOneAndOne() {
        assertEquals(-1, calculator.multiply(-1, 1), "-1 * 1 should give -1");
    }

    @Test
    @DisplayName("2 * 2 = 4")
    void multiplyTwoAndTwo() {
        assertEquals(4, calculator.multiply(2, 2), "2 * 2 should give 4");
    }

    @Test
    @DisplayName("1 / 0")
    void divideOneByZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(1, 0), "Cannot divide by zero");
    }

    @Test
    @DisplayName("1 / 1 = 1")
    void divideOneByOne(){
        assertEquals(1, calculator.divide(1,1),"1 /1 should give 1");
    }

    @Test
    @DisplayName("4 / 2 = 2")
    void divideFourByTwo(){
        assertEquals(2, calculator.divide(4,2),"4 / 2 should give 2");
    }

    @Test
    @DisplayName("0 / 1 = 0")
    void divideZeroByOne(){
        assertEquals(0, calculator.divide(0,1), "0 / 1 should give 0");
    }
}
