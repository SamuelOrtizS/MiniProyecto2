package univalle.fdpoe;

import javax.swing.*;

public class Ventana extends JFrame {
    private JTabbedPane tpPaneles;
    private JPanel panel1;
    private JPanel panelDatosPersonales;
    private JPanel panelDatosAcademicos;
    private JPanel panelEstadisticas;
    private JButton buttonGuardar;
    private JButton buttonProcesarDatos;
    private JTextPane textPane1;
    private JTextField tfIdentificacion;
    private JTextField tfNombre;
    private JSlider sliderEdad;
    private JLabel labelEdad;
    private JSpinner spinnerNumHijos;
    private JComboBox cbDepNacimiento;
    private JComboBox cbMunNacimiento;
    private JRadioButton rButtonCasaSi;
    private JRadioButton rButtonCasaNo;
    private JCheckBox chBHobbieTV;
    private JCheckBox chBHobbieDeportes;
    private JCheckBox chBHobbieRRSS;
    private JCheckBox chBHobbieCine;
    private JCheckBox chBHobbieEscMusica;
    private JCheckBox chBHobbieCompras;
    private JComboBox cbProfesion;
    private JRadioButton rButtonBachiller;
    private JRadioButton rButtonTecnico;
    private JRadioButton rButtonTecnologia;
    private JRadioButton rButtonPregrado;
    private JRadioButton rButtonPosgrado;
    private JRadioButton rButtonColombia;
    private JRadioButton rButtonExterior;
    private JRadioButton rButtonPropios;
    private JRadioButton rButtonBecaFundacion;
    private JRadioButton rButtonBecaGobierno;

    public Ventana() {
        super("Cuestionario");
        setContentPane(panel1);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
    }
}
