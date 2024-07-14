package nl.hva.miw.ads.trein;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TreinTest {

    @Test
    public void voegWagonToe() {
        Trein trein = new Trein();

        trein.voegWagonToe( 2, 1 );
        trein.voegWagonToe( 1, 1 );
        trein.voegWagonToe( 5, 3 );
        trein.voegWagonToe( 4, 3 );

        String expected = "Trein{ lengte=4 } 1 2 4 5";
        String actual = trein.toString();
        assertEquals( expected, actual );

        expected = "Trein{ lengte=4 } 5 4 2 1";
        actual = trein.omgekeerdeTrein();
        assertEquals( expected, actual );
    }

    @Test
    public void geefWagonNr() {
        Trein trein = new Trein();

        // Test lege trein
        assertEquals( -1, trein.geefWagonNr(1) );

        trein.voegWagonToe( 2, 1 );
        trein.voegWagonToe( 1, 1 );
        trein.voegWagonToe( 5, 3 );
        trein.voegWagonToe( 4, 3 );

        assertEquals( 1, trein.geefWagonNr(1) );
        assertEquals( 2, trein.geefWagonNr(2) );
        assertEquals( 4, trein.geefWagonNr(3) );
        assertEquals( 5, trein.geefWagonNr(4) );
        assertEquals( -1, trein.geefWagonNr(5) );
        assertEquals( -1, trein.geefWagonNr(0) );
    }


    @Test
    public void geefPositie() {
        Trein trein = new Trein();

        // Test lege trein
        assertEquals( 0, trein.geefPositie(1) );

        trein.voegWagonToe( 2, 1 );
        trein.voegWagonToe( 1, 1 );
        trein.voegWagonToe( 5, 3 );
        trein.voegWagonToe( 4, 3 );

        assertEquals( 1, trein.geefPositie(1) );
        assertEquals( 2, trein.geefPositie(2) );
        assertEquals( 3, trein.geefPositie(4) );
        assertEquals( 4, trein.geefPositie(5) );
        assertEquals( 0, trein.geefPositie(3) );
    }

    @Test
    public void verwijderWagon() {
        Trein trein = new Trein();

        // Test lege trein
        trein.verwijderWagon(1);
        String expected = "Trein{ lengte=0 }";
        String actual = trein.toString();
        assertEquals( expected, actual );

        trein.voegWagonToe( 2, 1 );
        trein.voegWagonToe( 1, 1 );
        trein.voegWagonToe( 5, 3 );
        trein.voegWagonToe( 4, 3 );

        trein.verwijderWagon(1);
        expected = "Trein{ lengte=3 } 2 4 5";
        actual = trein.toString();
        assertEquals( expected, actual );

        trein.verwijderWagon(2);
        expected = "Trein{ lengte=2 } 2 5";
        actual = trein.toString();
        assertEquals( expected, actual );

        trein.verwijderWagon(2);
        expected = "Trein{ lengte=1 } 2";
        actual = trein.toString();
        assertEquals( expected, actual );

        trein.verwijderWagon(1);
        expected = "Trein{ lengte=0 }";
        actual = trein.toString();
        assertEquals( expected, actual );
    }
} // class
