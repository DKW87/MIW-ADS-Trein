package nl.hva.miw.ads.trein;


/**
 * Trein klasse. Een Trein is een keten van wagons.
 * Elke wagon heeft een nr.
 * <p>
 * Wagons hebben een positie in de Trein. De posities beginnen bij 1 (niet 0!)
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
     * <p>
     * Als er geen wagon op die positie niet bestaat wordt -1 teruggegeven.
     * <p>
     * Let op: de eerste wagon zit op positie 1.
     *
     * @param positie
     * @return
     */
    public int geefWagonNr(int positie) {
        if (positie < 1 || positie > this.lengte) return -1;

        Wagon huidigeWagon = this.kop;
        for (int i = 1; i < positie; i++) {
            if (huidigeWagon == null) return -1;
            huidigeWagon = huidigeWagon.getVolgende();
        }

        if (huidigeWagon != null) {
            return huidigeWagon.getNr();
        } else {
            return -1;
        }
    }

    /**
     * Zoek de wagon met wagonNr in deze Trein en retourneert de positie van de wagon.
     * Als de wagon er niet in zit, dan wordt 0 geretourneerd.
     *
     * @param wagonNr
     * @return
     */
    public int geefPositie(int wagonNr) {
        Wagon huidigeWagon = this.kop;
        int positie = 1;

        while (huidigeWagon != null) {
            if (huidigeWagon.getNr() == wagonNr) {
                return positie;
            }
            huidigeWagon = huidigeWagon.getVolgende();
            positie++;
        }
        return 0;
    }


    /**
     * Voegt een wagon met wagonNr toe aan de Trein op de gegeven positie.
     * Let op eerste wagon zit op postie 1. Als positie groter is dan de lengte van de
     * Trein dan wordt een wagon aan het einde toegevoegd.
     *
     * @param wagonNr - wagon nummer.
     */
    public void voegWagonToe(int wagonNr, int positie) {
        Wagon nieuweWagon = new Wagon(wagonNr);

        if (positie <= 1) {
            voegWagonAanKopToe(nieuweWagon);
        } else {
            voegWagonOpPositieToe(nieuweWagon, positie);
        }
        this.lengte++;
    }

    /**
     * hulpmethode voor voegWagonToe
     *
     * @param nieuweWagon
     */
    private void voegWagonAanKopToe(Wagon nieuweWagon) {
        nieuweWagon.setVolgende(this.kop);

        if (this.kop != null) {
            this.kop.setVorige(nieuweWagon);
        }

        this.kop = nieuweWagon;
    }

    /**
     * hulpmethode voor voegWagonToe
     *
     * @param nieuweWagon
     * @param positie
     */
    private void voegWagonOpPositieToe(Wagon nieuweWagon, int positie) {
        Wagon huidigeWagon = this.kop;
        for (int i = 1; i < positie - 1 && huidigeWagon != null; i++) {
            huidigeWagon = huidigeWagon.getVolgende();
        }

        if (huidigeWagon != null) {
            nieuweWagon.setVolgende(huidigeWagon.getVolgende());
            if (huidigeWagon.getVolgende() != null) {
                huidigeWagon.getVolgende().setVorige(nieuweWagon);
            }
            huidigeWagon.setVolgende(nieuweWagon);
            nieuweWagon.setVorige(huidigeWagon);
        } else {
            voegWagonAanEindeToe(nieuweWagon);
        }
    }

    /**
     * hulpmethode voor voegWagonToe
     *
     * @param nieuweWagon
     */
    private void voegWagonAanEindeToe(Wagon nieuweWagon) {
        Wagon huidigeWagon = this.kop;

        while (huidigeWagon.getVolgende() != null) {
            huidigeWagon = huidigeWagon.getVolgende();
        }

        huidigeWagon.setVolgende(nieuweWagon);
        nieuweWagon.setVorige(huidigeWagon);
    }

    /**
     * haalt een wagon op een gegeven positie uit een Trein.
     * Let op eerste wagon zit op postie 1.
     *
     * @param positie - positie.
     */
    public void verwijderWagon(int positie) {
        if (positie < 1 || positie > this.lengte) return;

        if (positie == 1) {
            verwijderEersteWagon();
        }
        else {
            verwijderWagonOpPositie(positie);
        }
        this.lengte--;
    }

    /**
     * hulpmethode voor verwijderWagon
     */
    private void verwijderEersteWagon() {
        if (this.kop != null) {
            this.kop = this.kop.getVolgende();
            if (this.kop != null) {
                this.kop.setVorige(null);
            }
        }
    }

    /**
     * hulpmethode voor verwijderWagon
     *
     * @param positie
     */
    private void verwijderWagonOpPositie(int positie) {
        Wagon huidigeWagon = this.kop;
        for (int i = 1; i < positie; i++) huidigeWagon = huidigeWagon.getVolgende();

        if (huidigeWagon != null) {
            Wagon vorigeWagon = huidigeWagon.getVorige();
            Wagon volgendeWagon = huidigeWagon.getVolgende();
            if (vorigeWagon != null) {
                vorigeWagon.setVolgende(volgendeWagon);
            }
            if (volgendeWagon != null) {
                volgendeWagon.setVorige(vorigeWagon);
            }
        }
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
        while (w != null) {
            sb.append(" " + w.getNr());
            w = geefVolgende(w);
        }

        return sb.toString();
    }

    /**
     * Geef de trein in omgekeerde volgorde.
     *
     * @return
     */
    public String omgekeerdeTrein() {
        StringBuffer sb = new StringBuffer();
        sb.append("Trein{ lengte=" + lengte + " }");
        Wagon w = kop;
        // Loop naar de laatste wagon
        while (w != null && geefVolgende(w) != null) {
            w = geefVolgende(w);
        }

        while (w != null) {
            sb.append(" " + w.getNr());
            w = geefVorige(w);
        }

        return sb.toString();
    }

    /**
     * Methode die gebruikt wordt in de comparator unit-test om de som van wagonnrs te berekenen.
     * @return
     */
    public int somWagonNummers() {
        int som = 0;
        Wagon huidigeWagon = this.kop;
        while (huidigeWagon != null) {
            som += huidigeWagon.getNr();
            huidigeWagon = huidigeWagon.getVolgende();
        }
        return som;
    }

}
