import javax.swing.*;

public class VentanaContenedor extends JFrame{
    private JTextField txtIdentificador;
    private JTextField txtPeso;
    private JTextArea txtDescripcion;
    private JTextField txtRemitente;
    private JTextField txtReceptor;
    private JRadioButton a1RadioButton;
    private JRadioButton a2RadioButton;
    private JRadioButton a3RadioButton;
    private JCheckBox inspeccionadoEnAduanasCheckBox;
    private JTextField txtPais;
    private JPanel PanelPuerto2;
    private JLabel lbIdentificador;
    private JLabel lbPeso;
    private JLabel lbDescripcion;
    private JLabel lbRemitente;
    private JLabel lbReceptor;
    private JLabel lbPais;
    private JLabel lbPrioridad;

    public VentanaContenedor() {
        setTitle("Gestion de contenedores");
        setContentPane(PanelPuerto2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
    }


}
