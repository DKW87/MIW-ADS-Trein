package nl.hva.miw.ads.trein;

/**
 * Rangeerder klasse.
 *
 * Kan met treinen omgaan.
 *
 * @author michel
 */
public class Rangeerder {

    /**
     * Haalt wagon met nr wagonNr uit trein1 en voegt ze achteraan trein2 toe.
     *
     * @param trein1
     * @param trein2
     * @param wagonNr
     */
    public void verplaatsWagon(Trein trein1, Trein trein2, int wagonNr) {
        int positie = trein1.geefPositie(wagonNr);
        if (positie != 0) {
            trein1.verwijderWagon(positie);
            trein2.voegWagonToe(wagonNr, trein2.getLengte() + 1);
        }
    }

    /**
     * Voegt een nieuwe wagon toe aan de trein achter wagon met nr wagonNr.
     *
     * Als wagon met wagonNr er niet in zit, dan wordt de wagon NIET toegvoegd.
     *
     * @param trein
     * @param nieuweWagonNr
     * @param wagonNr
     */
    public void hangWagonAchterAndereWagon(Trein trein, int nieuweWagonNr, int wagonNr) {
        int positie = trein.geefPositie(wagonNr);
        if (positie != 0) {
            trein.voegWagonToe(nieuweWagonNr, positie + 1);
        }
    }

    /**
     * Voegt een nieuwe wagon toe aan de trein voor wagon met nr wagonNr.
     *
     * Als wagon met wagonNr er niet in zit, dan wordt de wagon NIET toegvoegd.
     *
     * @param trein
     * @param nieuweWagonNr
     * @param wagonNr
     */
    public void hangWagonVoorAndereWagon(Trein trein, int nieuweWagonNr, int wagonNr) {
        int positie = trein.geefPositie(wagonNr);
        if (positie != 0) {
            trein.voegWagonToe(nieuweWagonNr, positie);
        }
    }

} // class
