package includes;

import includes.Anweisungen.Anweisung;
import includes.Anweisungen.TexteLesen;
import includes.Views.MainView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Main Frame:
 */
public class MainFrame extends MainView {


    private TexteLesen texteLesen;

    /**
     * Konstruktor.
     * <p>
     * Hier wird das folgendes gemacht:
     * <ol>
     * <li>{@link TexteLesen} importiert.</li>
     * <li>Add Action Listener für btnsolu {@link #btnSolu}</li>
     * <li>Bekommen eines neues String ohne Leerzeichen. Sieh {@link TexteLesen#textOhneSpaces}</li>
     * <li>Anweisung wissen {@link TexteLesen#anweisung}</li>
     * <li>Überleitung zu {@link Anweisung}</li>
     * </ol>
     */
    public MainFrame() {
        texteLesen = new TexteLesen();
        getBtnSolu().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                texteLesen.setTextOhneSpaces(getTxtFunc().getText().trim().replaceAll("\\s+", ""));
                try {
                    texteLesen.setAnweisung(texteLesen.getTextOhneSpaces().split("\\."));
                    new Anweisung(texteLesen.getTextOhneSpaces(), texteLesen.getAnweisung()[0]);
                } catch (Exception ee) {
                    ee.printStackTrace();
                    System.out.println("MainFrame: Syntax Error! e.g. Rechnen");
                }
            }
        });
    }

}
