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