package nl.hva.miw.ads.trein;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

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
        Rangeerder rangeerder = new Rangeerder();
        Trein trein1 = setUp();
        Trein trein2 = new Trein();
        trein2.voegWagonToe(101, 1);
        trein2.voegWagonToe(100, 1);
        trein2.voegWagonToe(105, 3);
        trein2.voegWagonToe(104, 3);

        rangeerder.verplaatsWagon(trein1, trein2, 999);
        String expected = "Trein{ lengte=4 } 1 2 10 12";
        String actual = trein1.toString();
        assertEquals(expected, actual);

        expected = "Trein{ lengte=4 } 100 101 104 105";
        actual = trein2.toString();
        assertEquals(expected, actual);

        rangeerder.verplaatsWagon(trein1, trein2, 2);
        expected = "Trein{ lengte=3 } 1 10 12";
        actual = trein1.toString();
        assertEquals(expected, actual);

        expected = "Trein{ lengte=5 } 100 101 104 105 2";
        actual = trein2.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void hangWagonAchterAndereWagon() {
        Rangeerder rangeerder = new Rangeerder();
        Trein trein = setUp();

        rangeerder.hangWagonAchterAndereWagon(trein, 20, 10);
        String expected = "Trein{ lengte=5 } 1 2 10 20 12";
        String actual = trein.toString();
        assertEquals(expected, actual);

        rangeerder.hangWagonAchterAndereWagon(trein, 25, 999);
        expected = "Trein{ lengte=5 } 1 2 10 20 12";
        actual = trein.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void hangWagonVoorAndereWagon() {
        Rangeerder rangeerder = new Rangeerder();
        Trein trein = setUp();

        rangeerder.hangWagonVoorAndereWagon(trein, 15, 10);
        String expected = "Trein{ lengte=5 } 1 2 15 10 12";
        String actual = trein.toString();
        assertEquals(expected, actual);

        rangeerder.hangWagonVoorAndereWagon(trein, 30, 999);
        expected = "Trein{ lengte=5 } 1 2 15 10 12";
        actual = trein.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void sorteerTreinenComparator() {
        Trein trein1 = new Trein();
        trein1.voegWagonToe(400, 1);
        trein1.voegWagonToe(300, 2);
        trein1.voegWagonToe(100, 3);

        Trein trein2 = new Trein();
        trein2.voegWagonToe(40, 1);
        trein2.voegWagonToe(30, 2);
        trein2.voegWagonToe(10, 3);
        trein2.voegWagonToe(20, 4);

        Trein trein3 = new Trein();
        trein3.voegWagonToe(4, 1);
        trein3.voegWagonToe(3, 2);

        Trein[] treinArray = new Trein[3];
        treinArray[0] = trein1;
        treinArray[1] = trein2;
        treinArray[2] = trein3;

        Trein[] expected = new Trein[3];
        expected[0] = trein3;
        expected[1] = trein2;
        expected[2] = trein1;

        Arrays.sort(treinArray, new comparator.SomWagonNummersComparator());

        assertArrayEquals(expected, treinArray);
    }

} // class
