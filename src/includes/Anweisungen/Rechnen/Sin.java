package includes.Anweisungen.Rechnen;

/**
 * Sin Klasse
 */
public class Sin extends Rechnen {
    private Double sinWert;

    /**
     * @param x
     */
    public Sin(double x) {
        sinWert = Math.sin(Math.toRadians(x));
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
