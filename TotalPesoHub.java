/*
    MIRIAM GONZÁLEZ PÉREZ
 */

import javax.swing.*;

public class TotalPesoHub extends JFrame {
    private JTextArea texto;
    private JPanel panel;

    public TotalPesoHub(String pesTot){

        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        setContentPane(panel);
        texto.setText(pesTot);
    }


}
