package includes.Anweisungen.Rechnen;

import includes.Views.Slave;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Anweisung: Rechnen.
 */
public class Rechnen {

    private String textOhneSpaces;
    private String doIt = "";


    /**
     * hier wird die {@link includes.Anweisungen.TexteLesen#anweisung} mehr detalisiert.
     *
     * @param textOhneSpaces {@link includes.Anweisungen.TexteLesen#textOhneSpaces}
     */
    public Rechnen(String textOhneSpaces) {
        this.textOhneSpaces = textOhneSpaces;

        System.out.println("Text Ohne Spaces: " + getTextOhneSpaces());


        Pattern p = Pattern.compile("\\.(.*?)\\[");
        Matcher m = p.matcher(getTextOhneSpaces());

        while (m.find()) {

            switch (m.group(1)) {
                case "Summe":
                    System.out.println("Case: Summe");
                    try {
                        getSlaveRechnenSumme();
                    } catch (Exception e) {
                        System.out.println("Rechnen: Error!");
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

    private void getSlaveRechnenSumme() {
        new Slave().getSumme(getTextOhneSpaces(), new Summe(getDoIt()).Result());
    }

    public String getTextOhneSpaces() {
        return textOhneSpaces;
    }

    public int[] getDoIt() {
        // zwischen [ - ]
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(getTextOhneSpaces());

        while (m.find()) {
            doIt = m.group(1);
        }

        String resault[] = doIt.split(",");


        int[] integers = new int[resault.length];

        for (int i = 0; i < integers.length; i++) {
            integers[i] = Integer.parseInt(resault[i]);
        }

        return integers;
    }
}
