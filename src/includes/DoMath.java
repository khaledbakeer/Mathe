package includes;

import includes.Anweisungen.Anweisung;

/**
 * Main Class:
 */
public class DoMath {

    public String[] anweisung = new String[100];
    public String textOhneSpaces = "";
    public String mathResult;

    /**
     * Konstruktor
     */
    public DoMath() {
    }

    /**
     * Main Methode, die das String ohne Leerzeichen schaft, und das erste Wort vor dem Punk nimmt, was wir als Anweisung später betrachten.
     *
     * @param str String
     * @return String
     */
    public String getSolution(String str) {
        setTextOhneSpaces(str.trim().replaceAll("\\s+", ""));
        setAnweisung(getTextOhneSpaces().split("\\."));
        mathResult = new Anweisung().machen(getTextOhneSpaces(), getAnweisung()[0]);
        return mathResult;
    }

    /**
     * hier wird Anweisungen / Befehle angegeben.
     *
     * @param anweisung String[]
     */
    public void setAnweisung(String[] anweisung) {
        this.anweisung = anweisung;
    }

    /**
     * es wird Texte ohne Leerzeichen gesetzt.
     *
     * @param textOhneSpaces
     */
    public void setTextOhneSpaces(String textOhneSpaces) {
        this.textOhneSpaces = textOhneSpaces;
    }

    /**
     * Die Anweisungen werden hier erhalten.
     *
     * @return String[]
     */
    public String[] getAnweisung() {
        return anweisung;
    }

    /**
     * Das gesamte Text ohne Leerzeichen wird angegeben.
     *
     * @return String
     */
    public String getTextOhneSpaces() {
        return textOhneSpaces;
    }

}