package includes.Anweisungen;

import includes.Anweisungen.Rechnen.Rechnen;

/**
 * Anweisungsklasse
 */
public class Anweisung {


    /**
     * Konstruktor
     *
     * Hier wird die {@link TexteLesen#anweisung} gewählt.
     *
     * @param textOhneSpaces String
     * @param anweisung String
     */
    public Anweisung(String textOhneSpaces, String anweisung) {
        System.out.println("Die Anweisung ist: " + anweisung);

        switch (anweisung) {
            case "Rechnen":

                try {
                    System.out.println("Anweisung: Rechnen");
                    new Rechnen(textOhneSpaces);
                } catch (Exception e) {
                    System.out.println("Anweisung: Error!");
                    e.printStackTrace();
                }

                break;
        }


    }


}
