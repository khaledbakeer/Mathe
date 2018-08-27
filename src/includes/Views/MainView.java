package includes.Views;

import includes.Configurations.Constatnts;

import javax.swing.*;

public class MainView extends JFrame implements Constatnts {
    private JTextField txtFunc;
    private JButton btnSolu;



    private JButton addFunc;

    private JPanel mainPanel;

    private int count = 0;


    protected MainView() {
        initMainFrame();
        initComponents();
        showMainFrame();
    }


    private void initMainFrame() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Mathe");
        setBounds(100, 100, MainFram_Width, MainFram_Height);
        setLayout(null);


        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(10, 10, MainFram_Width - 150, MainFram_Height);
        add(mainPanel);


    }


    private void initComponents() {
        addFunc = new JButton(AddFuncButton_Text);
        addFunc.setBounds(AddFuncButton_XPos, AddFuncButton_YPos, 100, 20);
        addFunc.setFont(StyleFont);

        add(addFunc);


        txtFunc = new JTextField();
        txtFunc.setName("txtFunc" + count);
        txtFunc.setFont(StyleFont);
        txtFunc.setBounds(0, count * 50, MainFram_Width - 300, 20);
        txtFunc.setBackground(getBackground());
        mainPanel.add(txtFunc);


        btnSolu = new JButton("->");
        btnSolu.setName("btnSolu" + count);
        btnSolu.setFont(StyleFont);
        btnSolu.setBounds(MainFram_Width - 300, count * 50, 50, 20);
        btnSolu.setBackground(getBackground());

        mainPanel.add(btnSolu);




        mainPanel.revalidate();
        mainPanel.repaint();
        count++;


    }

    public JTextField getTxtFunc() {
        return txtFunc;
    }

    public JButton getBtnSolu() {
        return btnSolu;
    }



    public JButton getAddFunc() {
        return addFunc;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public int getCount() {
        return count;
    }

    /**
     * Show the <code>Frame</code>
     */
    public void showMainFrame() {
        setVisible(true);
    }
}
