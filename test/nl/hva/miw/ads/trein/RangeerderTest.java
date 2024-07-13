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

        System.out.println(trein);

        return trein;
    }

    @Test
    public void verplaatsWagon() {

        Rangeerder r = new Rangeerder();

        Trein t1 = setUp();

        Trein t2 = new Trein();
        t2.voegWagonToe( 101, 1 );
        t2.voegWagonToe( 100, 1 );
        t2.voegWagonToe( 105, 3 );
        t2.voegWagonToe( 104, 3 );

        r.verplaatsWagon( t1, t2, 999 );
        String expected = "Trein{ lengte=4 } 1 2 10 12";
        String actual = t1.toString();
        assertEquals( expected, actual );

        expected = "Trein{ lengte=4 } 100 101 104 105";
        actual = t2.toString();
        assertEquals( expected, actual );


        r.verplaatsWagon( t1, t2, 2 );
        expected = "Trein{ lengte=3 } 1 10 12";
        actual = t1.toString();
        assertEquals( expected, actual );

        expected = "Trein{ lengte=5 } 100 101 104 105 2";
        actual = t2.toString();
        assertEquals( expected, actual );

    }

    @Test
    public void sorteerTreinen() {
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
        expected[1] = t1;
        expected[2] = t2;

        Arrays.sort( treinArray );

        assertArrayEquals( treinArray, expected);
    }

    @Test
    public void sorteerTreinenComparator() {
        // Schrijf je eigen test die een Comparator gebruikt om
        // een trein te sorteren op inhoud (de som van de wagonnummers).
        fail();
    }

    @Test
    public void hangWagonAchterAndereWagon() {
        // Schrijf je eigen test.
        fail();
    }

    @Test
    public void hangWagonVoorAndereWagon() {
        // Schrijf je eigen test
        fail();
    }

}