package foo.bar.Dart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static foo.bar.Dart.CombinationsOfShield.*;

public class Dart501Test {

    Dart501 dart = new Dart501();

    @Test
    public void testAll50Game(){
        playerThrowBullseye(9);
        Assertions.assertEquals(51, dart.score());
    }

    @Test
    public void testWrongValue(){
        Assertions.assertThrows(IllegalArgumentException.class,()->dart.hit(50, MIDDLE25));
    }

    @Test
    public void threeShotsHigherThanScore(){
        playerThrowBullseye(9);
        dart.hit(25, MIDDLE25);
        dart.hit(25, MIDDLE25);
        dart.hit(25, MIDDLE25);
        Assertions.assertEquals(51, dart.score());
    }

    private void playerThrowBullseye(int n) {
        for (int i = 0; i < n; i++) {
            dart.hit(50, BULLSEYE);
        }
    }

    @Test
    public void testWin(){
        playerThrowBullseye(10);
        dart.hit(1,SINGLE);
        Assertions.assertEquals(0, dart.score());
    }

}
