package nl.hva.miw.ads.trein;


/**
 * Trein klasse. Een Trein is een keten van wagons.
 * Elke wagon heeft een nr.
 *
 * Wagons hebben een positie in de Trein. De posities beginnen bij 1 (niet 0!)
 *
 */
public class Trein {
    private int lengte;

    private Wagon kop;


    public Trein() {
        this.lengte = 0;
        kop = null;
    }

    public int getLengte() {
        return lengte;
    }

    /**
     * Geeft de wagonnr van de wagon op gegeven positie.
     *
     * Als er geen wagon op die positie niet bestaat wordt -1 teruggegeven.
     *
     * Let op: de eerste wagon zit op positie 1.
     *
     * @param positie
     * @return
     */
    public int geefWagonNr(int positie) {
        // Implementeer deze methode
        return -1;
    }

    /**
     * Zoek de wagon met wagonNr in deze Trein en retourneert de positie van de wagon.
     * Als de wagon er niet in zit, dan wordt 0 geretourneerd.
     *
     * @param wagonNr
     * @return
     */
    public int geefPositie( int wagonNr ) {
        // Implementeer deze methode

        return 0;
    }

    /**
     * Voegt een wagon met wagonNr toe aan de Trein op de gegeven positie.
     * Let op eerste wagon zit op postie 1. Als positie groter is dan de lengte van de
     * Trein dan wordt een wagon aan het einde toegevoegd.
     *
     * @param wagonNr - wagon nummer.
     */
    public void voegWagonToe( int wagonNr, int positie ) {
//        System.out.println("voegWagonToe: " + wagonNr + " op positie " + positie );

        // Implementeer deze methode.

    }

    /**
     * haalt een wagon op een gegeven positie uit een Trein.
     * Let op eerste wagon zit op postie 1.
     *
     * @param positie - positie.
     */
    public void verwijderWagon( int positie ) {
//        System.out.println("verwijderWagon op positie " + positie );

        // Implementeer deze methode.

    }

    /**
     * Hulp methode.
     *
     * @param w
     * @return
     */
    private Wagon geefVolgende(Wagon w) {
        return w.getVolgende();
    }

    /**
     * Hulp methode.
     *
     * @param w
     * @return
     */
    private Wagon geefVorige(Wagon w) {
        return w.getVorige();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Trein{ lengte=" + lengte + " }");
        Wagon w = kop;
        while (w != null ) {
            sb.append( " " + w.getNr() );
            w = geefVolgende(w);
        }

        return sb.toString();
    }

    /**
     * Geef de trein in omgekeerde volgorde.
     * @return
     */
    public String omgekeerdeTrein() {
        StringBuffer sb = new StringBuffer();
        sb.append("Trein{ lengte=" + lengte + " }");
        Wagon w = kop;
        // Loop naar de laatste wagon
        while (w != null && geefVolgende(w) != null ) {
            w = geefVolgende(w);
        }

        while (w != null ) {
            sb.append( " " + w.getNr() );
            w = geefVorige(w);
        }

        return sb.toString();
    }
}
