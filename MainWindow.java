import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;


public class MainWindow extends JFrame {
    private JCheckBox inspeccionadoEnAduanasCheckBox;
    private JTextField txtIdentificador;
    private JTextField txtPeso;
    private JTextField txtRemitente;
    private JTextField txtReceptora;
    private JLabel lbIdentificador;
    private JLabel lbPeso;
    private JLabel lbPaisPro;
    private JLabel lbPrioridad;
    private JLabel lbDescripcion;
    private JLabel lbEmpresaEnvi;
    private JLabel lbEmpresareci;
    private JPanel PanelPuerto;
    private JButton btGuardar;
    private JRadioButton rb1;
    private JRadioButton rb2;
    private JRadioButton rb3;
    private JTextArea txtDescripcion;
    private JComboBox<String> BoxPais;
    private JTextArea txtEstado;
    private JButton apilarButton;
    private JButton desapilarButton;
    private JButton mostrarDatosContenedorButton;
    private JButton cuantasButton;
    private JTextField numeroColumnaTextField;
    private JTextField IDContenedorTextField;
    private JComboBox BoxCuantas;
    private JTextField txtCuantas;
    private JLabel lbOperacion;
    private JLabel lbEstado;
    private JTextArea estadoText;//Poner en la interfaz
    private JLabel erroresJField; //Poner en la interfaz
    private JLabel estadoJLabel; //Poner en la interfaz

//---------------------------------------------------------

    private Puerto puerto;
    private int valor=3;
    private Locale[] locales = Locale.getAvailableLocales();
    private String[] paises = new String[locales.length];
    private Hub matriz;
    private int nHub;




    public MainWindow() {
        for (int i = 0; i < locales.length; i++) {
            if (locales[i] != null) paises[i] = locales[i].getDisplayCountry();
        }

        setTitle("Gestion de contenedores");
        setContentPane(PanelPuerto);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();

        BoxPais.setModel(new DefaultComboBoxModel(paises));
        txtEstado.setText(matriz.toString());

        rb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rb1.isSelected()){
                    rb2.setEnabled(false);
                    rb3.setEnabled(false);
                    valor=1;
                }else if (!rb1.isSelected()){
                    rb2.setEnabled(true);
                    rb3.setEnabled(true);
                }
            }
        });
        rb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rb2.isSelected()){
                    rb1.setEnabled(false);
                    rb3.setEnabled(false);
                    valor=2;
                }else if (!rb2.isSelected()){
                    rb1.setEnabled(true);
                    rb3.setEnabled(true);
                }
            }
        });
        rb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rb3.isSelected()){
                    rb1.setEnabled(false);
                    rb2.setEnabled(false);
                    valor=3;
                }else if (!rb3.isSelected()){
                    rb1.setEnabled(true);
                    rb2.setEnabled(true);
                }
            }
        });

        apilarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int prioridad;

                //Aquí sabremos la prioridad que tenga segun lo que han seleccionado.

                if (rb1.isSelected()) {
                    prioridad = 1;
                } else if (rb2.isSelected()) {
                    prioridad = 2;
                } else {
                    prioridad = 3;
                }

                int id,pesoC;
                String pais,empresa,empresaRecibe,contenido;
                boolean inspeccionado;
                id=Integer.parseInt(((!txtPeso.getText().isEmpty()) ? txtPeso.getText() : "0"));
                /**
                Aqui en id lo que estamos haciendo es preguntar que si es vacío, si lo es pone en peso 0.
                 **/
                pesoC=Integer.parseInt(txtPeso.getText());
                pais= String.valueOf(BoxPais.getSelectedItem());
                empresa=txtRemitente.getText();
                empresaRecibe=txtReceptora.getText();
                contenido=txtDescripcion.getText();
                inspeccionado=inspeccionadoEnAduanasCheckBox.isSelected();

                Contenedores cont = new Contenedores(id,pesoC,prioridad,pais,contenido,empresa,empresaRecibe,inspeccionado);

                nHub = puerto.insertaEnHub(cont) +1 ;
                if (nHub != -1) {
                    erroresJField.setText("¡Contenedor apilado!");
                    estadoText.setText(puerto.getHub(nHub-1).toString());
                    txtIdentificador.setText("" +Hub.getNContenedor());
                    estadoJLabel.setText("Estado-> (Libre u Ocupado) -- Hub " + (nHub));
                } else {
                    erroresJField.setText("*Error* No queda espacio para apilar");
                }
            }
        }
        );
    }
}

