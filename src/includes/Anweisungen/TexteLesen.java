package includes.Anweisungen;

/**
 * hier wird das gesamte Textinhalt gespeichert.
 */
public class TexteLesen {

    public String[] anweisung = new String[100];
    public String textOhneSpaces = "";

    /**
     * Konstruktor.
     */
    public TexteLesen() {

    }

    /**
     * hier wird Anweisungen / Befehle gegeben.
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
     * Das gesamte Text ohne Leerzeichen wird hier gegeben.
     *
     * @return String
     */
    public String getTextOhneSpaces() {
        return textOhneSpaces;
    }

}
