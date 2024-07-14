package comparator;

import nl.hva.miw.ads.trein.Trein;

import java.util.Comparator;

/**
 * @author Danny KWANT
 * @project Trein
 * @created 14/07/2024 - 09:53
 */
public class SomWagonNummersComparator implements Comparator<Trein> {
    @Override
    public int compare(Trein t1, Trein t2) {
        return Integer.compare(t1.somWagonNummers(), t2.somWagonNummers());
    }
}
