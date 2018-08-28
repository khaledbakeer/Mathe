package includes.Anweisungen.Rechnen;

import java.util.stream.DoubleStream;

/**
 * Anweisung: Rechnen.Summe
 */
public class Summe extends Rechnen {

    private Double summeWert;

    /**
     * Konstruktor
     *
     * @param doit etwas zu rechnen in String.
     */
    public Summe(double[] doit) {
        summeWert = DoubleStream.of(doit).sum();
    }


    /**
     * @return
     */
    @Override
    public String Result() {
        setResult(summeWert.toString());
        return getResult();
    }
}
