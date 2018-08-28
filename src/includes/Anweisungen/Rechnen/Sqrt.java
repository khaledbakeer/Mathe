package includes.Anweisungen.Rechnen;

/**
 * Sqrt Klasse
 */
public class Sqrt extends Rechnen {
    private Double sqrtWert;

    /**
     * @param sqrt
     */
    public Sqrt(double sqrt) {
        sqrtWert = Math.sqrt(sqrt);
    }

    @Override
    public String Result() {
        setResult(sqrtWert.toString());
        return getResult();
    }
}
