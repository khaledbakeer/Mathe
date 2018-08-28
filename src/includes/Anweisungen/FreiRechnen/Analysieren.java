package includes.Anweisungen.FreiRechnen;

/**
 * Analysieren Klasse
 */
public class Analysieren extends FreiRechnen {

    public int pos = -1;
    public int ch;
    public String str = super.getTextOhneSpaces();

    /**
     * Überprüft den nächsten Char.
     */
    void nextChar() {
        if (++pos < str.length()) {
            ch = str.charAt(pos);
        } else {
            ch = -1;
        }
    }

    /**
     * @param str
     * @return
     */
    public double analysieren(String str) {
        this.str = str;
        nextChar();
        return ausdruckAnalysieren();
    }

    /**
     * @param gerade
     * @return
     */
    boolean charIst(int gerade) {
        while (ch == ' ') nextChar();
        if (ch == gerade) {
            nextChar();
            return true;
        }
        return false;
    }


    /**
     * @return
     */
    double ausdruckAnalysieren() {
        double x = begriffAnalysieren();
        for (; ; ) {
            if (charIst('+')) x += begriffAnalysieren(); // +
            else if (charIst('-')) x -= begriffAnalysieren(); // -
            else return x;
        }
    }

    /**
     * @return
     */
    double begriffAnalysieren() {
        double x = factorAnalysieren();
        for (; ; ) {
            if (charIst('*')) x *= factorAnalysieren(); // *
            else if (charIst('/')) x /= factorAnalysieren(); // /
            else return x;
        }
    }

    /**
     * @return
     */
    double factorAnalysieren() {
        if (charIst('+')) return factorAnalysieren(); // unary plus
        if (charIst('-')) return -factorAnalysieren(); // unary minus

        double x;
        int startPos = this.pos;
        if (charIst('(')) { // parentheses
            x = ausdruckAnalysieren();
            charIst(')');
        } else if ((ch >= '0' && ch <= '9') || ch == '.') { // Nummern
            while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
            x = Double.parseDouble(str.substring(startPos, this.pos));
        } else if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') { // functions
            while (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') nextChar();
            String func = str.substring(startPos, this.pos);
            x = factorAnalysieren();
            if (func.equals("Sqrt")) x = Math.sqrt(x);
            else if (func.equals("Sin")) x = Math.sin(Math.toRadians(x));
            else if (func.equals("Cos")) x = Math.cos(Math.toRadians(x));
            else if (func.equals("Tan")) x = Math.tan(Math.toRadians(x));
            else throw new RuntimeException("Unknown function: " + func);
        } else {
            throw new RuntimeException("Unexpected: " + (char) ch);
        }

        if (charIst('^')) x = Math.pow(x, factorAnalysieren()); // exponentiation

        return x;
    }


    /**
     * @return
     */
    @Override
    public String Result() {
        return null;
    }
}
