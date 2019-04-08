package foo.bar.Dart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static foo.bar.Dart.CombinationsOfShield.BULLSEYE;
import static foo.bar.Dart.CombinationsOfShield.MIDDLE25;

public class Dart501Test {

    Dart501 dart = new Dart501();

    @Test
    public void testAll50Game(){
        for (int i = 0; i < 9; i++) {
            dart.hit(50, BULLSEYE);
        }
        Assertions.assertEquals(51, dart.score());
    }

    @Test
    public void testWrongValue(){
        Assertions.assertThrows(IllegalArgumentException.class,()->dart.hit(50, MIDDLE25));
    }

    @Test
    public void threeShotsHigherThanScore(){
        for (int i = 0; i < 9; i++) {
            dart.hit(50, BULLSEYE);
        }
        dart.hit(25, MIDDLE25);
        dart.hit(25, MIDDLE25);
        dart.hit(25, MIDDLE25);
        Assertions.assertEquals(51, dart.score());
    }

}
