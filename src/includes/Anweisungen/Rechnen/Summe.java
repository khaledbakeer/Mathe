package includes.Anweisungen.Rechnen;

import java.util.stream.IntStream;

/**
 * Anweisung: Rechnen.Summe
 */
public class Summe {
    private int summeWert;

    /**
     * Konstruktor
     *
     * @param doit etwas zu rechnen in String.
     */
    public Summe(int[] doit) {
        summeWert = IntStream.of(doit).sum();
    }

    public int Result() {

        return summeWert;
    }
}
