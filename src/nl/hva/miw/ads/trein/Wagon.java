package nl.hva.miw.ads.trein;

/**
 * Wagon klasse.
 *
 * Elke wagon heeft een nummer en een link naar de volgende / vorige Wagon.
 *
 * @author michel
 *
 */
public class Wagon {
    private int nr;

    private Wagon volgende = null;
    private Wagon vorige = null;


    public Wagon(int nr) {
        this.nr = nr;
    }

    public int getNr() {
        return nr;
    }

    public Wagon getVolgende() {
        return volgende;
    }

    public void setVolgende(Wagon volgende) {
        this.volgende = volgende;
    }

    public Wagon getVorige() {
        return vorige;
    }

    public void setVorige(Wagon vorige) {
        this.vorige = vorige;
    }

    @Override
    public String toString() {
        return "Wagon{" +
                "nr=" + nr +
                '}';
    }
}
