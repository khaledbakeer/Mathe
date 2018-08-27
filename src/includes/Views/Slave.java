package includes.Views;

import includes.Configurations.Constatnts;

import javax.swing.*;
import java.awt.*;

public class Slave extends JFrame implements Constatnts {

    private JPanel slavePanel;
    private JLabel drawBox;

    private JPanel leftPanel;
    private JPanel centerPanel;
    private JPanel rightPanel;

    private JLabel lblAnweisung;

    private JTable dataTable = new JTable();


    public Slave() {

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Mathe Slave");
        setBounds(100, 100, MainFram_Width, MainFram_Height);
        setLayout(new BorderLayout());


        slavePanel = new JPanel();
        slavePanel.setLayout(new BorderLayout());
        slavePanel.setBounds(10, 10, MainFram_Width - 150, MainFram_Height);
        add(slavePanel);

        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        leftPanel.setBackground(getBackground());
//        leftPanel.setPreferredSize(new Dimension(300, 500));
        slavePanel.add(leftPanel, BorderLayout.WEST);


        lblAnweisung = new JLabel();
        lblAnweisung.setBounds(30, 13, 300, 200);
        lblAnweisung.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));
        lblAnweisung.setBackground(getBackground());
        lblAnweisung.setFont(getFont());
        leftPanel.add(lblAnweisung, BorderLayout.NORTH);


        leftPanel.add(dataTable);


        centerPanel = new JPanel();
        centerPanel.setBackground(getBackground());
        slavePanel.add(centerPanel, BorderLayout.EAST);


        rightPanel = new JPanel();
        rightPanel.setBackground(getBackground());
        slavePanel.add(rightPanel, BorderLayout.CENTER);

        setContentPane(slavePanel);
        setVisible(true);
    }

   public void getSumme(String anweisung, int ergebnis) {
       lblAnweisung.setText("<html><body style='width:350px;padding:15px;display:block;'><p><b>Anweisung: </b>" + anweisung + "</p><p>ist gleich: </p>" + "<p><b>" + ergebnis + "</b></p></body></html>");
       rightPanel.setVisible(false);
       centerPanel.setVisible(false);
       dataTable.setVisible(false);
       lblAnweisung.setMaximumSize(new Dimension(350,400));


       setBounds(150,150,500,200);
       setResizable(true);
       setContentPane(slavePanel);
       setVisible(true);
   }


}
