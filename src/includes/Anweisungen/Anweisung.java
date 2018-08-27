package includes.Anweisungen;

import includes.Anweisungen.Rechnen.Rechnen;

/**
 * Anweisungsklasse
 */
public class Anweisung {

    private CallClass callClass = new CallClass();
    private String textOhneSpaces;

    /**
     * Konstruktor
     * <p>
     * Hier wird die {@link TexteLesen#anweisung} gewählt.
     *
     * @param textOhneSpaces String
     * @param anweisung      String
     */
    public Anweisung(String textOhneSpaces, String anweisung) {
        this.textOhneSpaces = textOhneSpaces;
        System.out.println("Die Anweisung ist: " + anweisung);

        switch (anweisung) {
            case "Rechnen":
                callClass.Rechnen();
                break;

            case "":
                callClass.FreiRechnen();
                break;
        }


    }


    class CallClass {
        public CallClass() {

        }

        private void Rechnen() {
            try {
                new Rechnen(textOhneSpaces);
            } catch (Exception e) {
                System.out.println("Anweisung: Error! -> Rechnen");
                e.printStackTrace();
            }
        }

        private void FreiRechnen() {
            System.out.println("FreiRechnen");
            try {
                new FreiRechnen(textOhneSpaces);
            } catch (Exception e) {
                System.out.println("Anweisung: Error! -> FreiRechnen");
                e.printStackTrace();
            }
        }
    }


}
