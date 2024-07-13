package nl.hva.miw.ads.trein;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreinTest {

    @Test
    public void voegWagonToe() {
        Trein t = new Trein();

        t.voegWagonToe( 2, 1 );
        t.voegWagonToe( 1, 1 );
        t.voegWagonToe( 5, 3 );
        t.voegWagonToe( 4, 3 );

        String expected = "Trein{ lengte=4 } 1 2 4 5";
        String actual = t.toString();
        assertEquals( expected, actual );

        expected = "Trein{ lengte=4 } 5 4 2 1";
        actual = t.omgekeerdeTrein();
        assertEquals( expected, actual );
    }

    @Test
    public void geefWagonNr() {
        Trein t = new Trein();

        // Test lege trein
        assertEquals( -1, t.geefWagonNr(1) );

        t.voegWagonToe( 2, 1 );
        t.voegWagonToe( 1, 1 );
        t.voegWagonToe( 5, 3 );
        t.voegWagonToe( 4, 3 );

        assertEquals( 1, t.geefWagonNr(1) );
        assertEquals( 2, t.geefWagonNr(2) );
        assertEquals( 4, t.geefWagonNr(3) );
        assertEquals( 5, t.geefWagonNr(4) );
        assertEquals( -1, t.geefWagonNr(5) );
        assertEquals( -1, t.geefWagonNr(0) );
    }


    @Test
    public void geefPositie() {
        Trein t = new Trein();

        // Test lege trein
        assertEquals( 0, t.geefPositie(1) );

        t.voegWagonToe( 2, 1 );
        t.voegWagonToe( 1, 1 );
        t.voegWagonToe( 5, 3 );
        t.voegWagonToe( 4, 3 );

        assertEquals( 1, t.geefPositie(1) );
        assertEquals( 2, t.geefPositie(2) );
        assertEquals( 3, t.geefPositie(4) );
        assertEquals( 4, t.geefPositie(5) );
        assertEquals( 0, t.geefPositie(3) );
    }

    @Test
    public void verwijderWagon() {
        Trein t = new Trein();

        // Test lege trein
        t.verwijderWagon(1);
        String expected = "Trein{ lengte=0 }";
        String actual = t.toString();
        assertEquals( expected, actual );

        t.voegWagonToe( 2, 1 );
        t.voegWagonToe( 1, 1 );
        t.voegWagonToe( 5, 3 );
        t.voegWagonToe( 4, 3 );

        t.verwijderWagon(1);
        expected = "Trein{ lengte=3 } 2 4 5";
        actual = t.toString();
        assertEquals( expected, actual );

        t.verwijderWagon(2);
        expected = "Trein{ lengte=2 } 2 5";
        actual = t.toString();
        assertEquals( expected, actual );

        t.verwijderWagon(2);
        expected = "Trein{ lengte=1 } 2";
        actual = t.toString();
        assertEquals( expected, actual );

        t.verwijderWagon(1);
        expected = "Trein{ lengte=0 }";
        actual = t.toString();
        assertEquals( expected, actual );
    }
}