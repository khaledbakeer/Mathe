/*
 * MIT License
 *
 * Copyright (c) 2018 Khaled Bakeer
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package includes.Anweisungen;

import includes.Anweisungen.FreiRechnen.Analysieren;
import includes.Anweisungen.FreiRechnen.FreiRechnen;
import includes.Anweisungen.Rechnen.Rechnen;
import includes.Anweisungen.Rechnen.Sin;
import includes.Anweisungen.Rechnen.Sqrt;
import includes.Anweisungen.Rechnen.Summe;
import includes.DoMath;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Anweisungsklasse
 */
public class Anweisung {

    private String textOhneSpaces;
    private String doIt = "";
    private String result;

    /**
     * Konstruktoz
     */
    public Anweisung() {

    }

    /**
     * Machen Methode
     * <p>
     * Anweisungen Lesen
     *
     * @param textOhneSpaces {@link #getTextOhneSpaces()}
     * @param anweisung      {@link DoMath#getAnweisung()}
     * @return
     */
    public String machen(String textOhneSpaces, String anweisung) {
        this.textOhneSpaces = textOhneSpaces;

        switch (anweisung) {
            case "Rechnen":
                return rechnenAnalysieren(textOhneSpaces);
            default:
                return freiRechnenAnalysieren(textOhneSpaces);
        }
    }

    /**
     * Frei Rechnen Analysieren
     * <p>
     * {@link FreiRechnen#FreiRechnen()} abrufen
     *
     * @param textOhneSpaces {@link #getTextOhneSpaces()}
     * @return String
     */
    public String freiRechnenAnalysieren(String textOhneSpaces) {
        Analysieren an = new Analysieren();
        String s = String.valueOf(an.analysieren(textOhneSpaces));
        return s;
    }

    /**
     * Rechnen Analysieren
     * <p>
     * {@link Rechnen#Rechnen()}
     *
     * @param textOhneSpaces {@link #getTextOhneSpaces()}
     * @return String
     */
    public String rechnenAnalysieren(String textOhneSpaces) {
        this.textOhneSpaces = textOhneSpaces;

        Pattern p = Pattern.compile("\\.(.*?)\\[");
        Matcher m = p.matcher(getTextOhneSpaces());

        while (m.find()) {
            switch (m.group(1)) {
                case "Summe":
                    result = new Summe(summeZahlen()).Result();
                    break;
                case "Sqrt":
                    result = new Sqrt(einZahl()).Result();
                    break;
                case "Sin":
                    result = new Sin(einZahl()).Result();
                    break;
                default:
                    break;
            }
        }
        return result;
    }


    /**
     * @return
     */
    public String getTextOhneSpaces() {
        return textOhneSpaces;
    }

    /**
     * @return
     */
    public double einZahl() {
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(getTextOhneSpaces());
        while (m.find()) {
            doIt = m.group(1);
        }
        double num = Double.parseDouble(doIt);
        return num;
    }

    /**
     * @return
     */
    public double[] summeZahlen() {
        Pattern p = Pattern.compile("\\[(.*?)\\]");
        Matcher m = p.matcher(getTextOhneSpaces());
        while (m.find()) {
            doIt = m.group(1);
        }
        String resault[] = doIt.split(",");
        double[] nummern = new double[resault.length];
        for (int i = 0; i < nummern.length; i++) {
            nummern[i] = Double.parseDouble(resault[i]);
        }
        return nummern;
    }

    /**
     * @return
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }

}




