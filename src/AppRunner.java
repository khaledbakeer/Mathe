import includes.MainFrame;

/**
 * Mathe Programm
 *
 * @author Khaled Bakeer
 * @version 0.1
 */
public class AppRunner {

    /**
     * es beginnt hier eine neue Frame zu laden.
     */
    private AppRunner() {
        new MainFrame();
    }

    /**
     * es muss hier alles anfangen.
     *
     * @param args Strings
     */
    public static void main(String[] args) {
        new AppRunner();
    }
}
