package nl.hva.miw.ads.trein;

import comparator.SomWagonNummersComparator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class RangeerderTest {

    public Trein setUp() {
        Trein trein = new Trein();
        trein.voegWagonToe(2, 1);
        trein.voegWagonToe(1, 1);
        trein.voegWagonToe(12, 3);
        trein.voegWagonToe(10, 3);
        return trein;
    }

    @Test
    public void verplaatsWagon() {
        Rangeerder r = new Rangeerder();
        Trein t1 = setUp();
        Trein t2 = new Trein();
        t2.voegWagonToe(101, 1);
        t2.voegWagonToe(100, 1);
        t2.voegWagonToe(105, 3);
        t2.voegWagonToe(104, 3);

        r.verplaatsWagon(t1, t2, 999);
        String expected = "Trein{ lengte=4 } 1 2 10 12";
        String actual = t1.toString();
        assertEquals(expected, actual);

        expected = "Trein{ lengte=4 } 100 101 104 105";
        actual = t2.toString();
        assertEquals(expected, actual);

        r.verplaatsWagon(t1, t2, 2);
        expected = "Trein{ lengte=3 } 1 10 12";
        actual = t1.toString();
        assertEquals(expected, actual);

        expected = "Trein{ lengte=5 } 100 101 104 105 2";
        actual = t2.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void hangWagonAchterAndereWagon() {
        Rangeerder r = new Rangeerder();
        Trein t = setUp();

        r.hangWagonAchterAndereWagon(t, 20, 10);
        String expected = "Trein{ lengte=5 } 1 2 10 20 12";
        String actual = t.toString();
        assertEquals(expected, actual);

        r.hangWagonAchterAndereWagon(t, 25, 999);
        expected = "Trein{ lengte=5 } 1 2 10 20 12";
        actual = t.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void hangWagonVoorAndereWagon() {
        Rangeerder r = new Rangeerder();
        Trein t = setUp();

        r.hangWagonVoorAndereWagon(t, 15, 10);
        String expected = "Trein{ lengte=5 } 1 2 15 10 12";
        String actual = t.toString();
        assertEquals(expected, actual);

        r.hangWagonVoorAndereWagon(t, 30, 999);
        expected = "Trein{ lengte=5 } 1 2 15 10 12";
        actual = t.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void sorteerTreinenComparator() {
        Trein t1 = new Trein();
        t1.voegWagonToe(400, 1);
        t1.voegWagonToe(300, 2);
        t1.voegWagonToe(100, 3);

        Trein t2 = new Trein();
        t2.voegWagonToe(40, 1);
        t2.voegWagonToe(30, 2);
        t2.voegWagonToe(10, 3);
        t2.voegWagonToe(20, 4);

        Trein t3 = new Trein();
        t3.voegWagonToe(4, 1);
        t3.voegWagonToe(3, 2);

        Trein[] treinArray = new Trein[3];
        treinArray[0] = t1;
        treinArray[1] = t2;
        treinArray[2] = t3;

        Trein[] expected = new Trein[3];
        expected[0] = t3;
        expected[1] = t2;
        expected[2] = t1;

        Arrays.sort(treinArray, new comparator.SomWagonNummersComparator());

        assertArrayEquals(expected, treinArray);
    }

}
