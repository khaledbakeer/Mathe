package includes.Anweisungen.Rechnen;

/**
 * Sin Klasse
 */
public class Sin extends Rechnen {
    private Double sinWert;

    /**
     * @param sin
     */
    public Sin(double sin) {
        sinWert = Math.sqrt(sin);
    }

    /**
     * @return
     */
    @Override
    public String Result() {
        setResult(sinWert.toString());
        return getResult();
    }
}
