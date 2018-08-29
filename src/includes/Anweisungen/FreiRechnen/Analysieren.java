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
