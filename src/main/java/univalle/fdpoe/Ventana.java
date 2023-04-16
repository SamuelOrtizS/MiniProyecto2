package univalle.fdpoe;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

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
    ArrayList<Persona> aPers;
    private Persona per;

    public Ventana() {
        super("Cuestionario");
        setContentPane(panel1);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        //Arreglo dinámico que guarda los datos de cada persona
        aPers = new ArrayList<Persona>();

        //Cambio el mensaje de edad de acuerdo con el slider
        sliderEdad.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sliderEdad.getValue() == 1)
                    labelEdad.setText("" + sliderEdad.getValue() + " año");
                else
                    labelEdad.setText("" + sliderEdad.getValue() + " años");
            }
        });

        //Mantengo el numero de hijos entre 0 y 10, con incrementos de 1 en 1
        spinnerNumHijos.setModel(new SpinnerNumberModel(0,0,10,1));

        //Arreglos que crean el combobox para cada departamento
        String[] aCundinamarca = new String[3];
        aCundinamarca[0] = "Bogotá";
        aCundinamarca[1] = "Soacha";
        aCundinamarca[2] = "Fusagasugá";

        String[] aAntioquia = new String[3];
        aAntioquia[0] = "Medellín";
        aAntioquia[1] = "Bello";
        aAntioquia[2] = "Itagüí";

        String[] aValle = new String[3];
        aValle[0] = "Cali";
        aValle[1] = "Palmira";
        aValle[2] = "Buenaventura";

        String[] aSantander = new String[3];
        aSantander[0] = "Bucaramanga";
        aSantander[1] = "Floridablanca";
        aSantander[2] = "Barrancabermeja";

        String[] aAtlantico = new String[3];
        aAtlantico[0] = "Barranquilla";
        aAtlantico[1] = "Soledad";
        aAtlantico[2] = "Malambo";

        //Creo los combobox a partir del departamento seleccionado y lo inicializo con el primer departamento
        cbMunNacimiento.setModel(new DefaultComboBoxModel(aCundinamarca));

        cbDepNacimiento.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String departamentoSeleccionado = cbDepNacimiento.getSelectedItem().toString();
                if (departamentoSeleccionado == "Cundinamarca"){
                    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(aCundinamarca);
                    cbMunNacimiento.setModel(modelo);
                } else if (departamentoSeleccionado == "Antioquia"){
                    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(aAntioquia);
                    cbMunNacimiento.setModel(modelo);
                }else if(departamentoSeleccionado =="Valle del Cauca"){
                    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(aValle);
                    cbMunNacimiento.setModel(modelo);
                }else if (departamentoSeleccionado == "Santander"){
                    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(aSantander);
                    cbMunNacimiento.setModel(modelo);
                }else if (departamentoSeleccionado == "Atlántico"){
                    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(aAtlantico);
                    cbMunNacimiento.setModel(modelo);
                }
            }
        });

        //Deshabilito al inicio los botones de posgrado
        rButtonColombia.setEnabled(false);
        rButtonExterior.setEnabled(false);

        rButtonPropios.setEnabled(false);
        rButtonBecaGobierno.setEnabled(false);
        rButtonBecaFundacion.setEnabled(false);

        //Los habilito si se selecciona Posgrado y deshabilito si no
        rButtonPosgrado.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (rButtonPosgrado.isSelected()){
                    rButtonColombia.setEnabled(true);
                    rButtonExterior.setEnabled(true);

                    rButtonPropios.setEnabled(true);
                    rButtonBecaGobierno.setEnabled(true);
                    rButtonBecaFundacion.setEnabled(true);
                } else {
                    rButtonColombia.setEnabled(false);
                    rButtonExterior.setEnabled(false);

                    rButtonPropios.setEnabled(false);
                    rButtonBecaGobierno.setEnabled(false);
                    rButtonBecaFundacion.setEnabled(false);
                }
            }
        });
        buttonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
        buttonProcesarDatos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                procesarDatos();
            }
        });
    }
    public void guardarDatos(){
        try {
            if (!tfIdentificacion.getText().equals("") && !tfNombre.getText().equals("") && (rButtonCasaSi.isSelected() || rButtonCasaNo.isSelected()) && (rButtonBachiller.isSelected() || rButtonTecnico.isSelected() || rButtonTecnologia.isSelected() || rButtonPregrado.isSelected() || rButtonPosgrado.isSelected())) {
                per = new Persona();
                per.setId(Integer.parseInt(tfIdentificacion.getText()));
                per.setNombre(tfNombre.getText());
                per.setEdad(sliderEdad.getValue());
                per.setNumHijos(Integer.valueOf(spinnerNumHijos.getValue().toString()));
                per.setDepartamentoNacimiento(cbDepNacimiento.getSelectedItem().toString());
                per.setMunicipioNacimiento(cbMunNacimiento.getSelectedItem().toString());
                if (rButtonCasaSi.isSelected())
                    per.setCasaPropia(true);
                else if (rButtonCasaNo.isSelected())
                    per.setCasaPropia(false);

                ArrayList<String> hobbies = new ArrayList<String>();
                if (chBHobbieTV.isSelected())
                    hobbies.add(chBHobbieTV.getText());
                if (chBHobbieRRSS.isSelected())
                    hobbies.add(chBHobbieRRSS.getText());
                if (chBHobbieEscMusica.isSelected())
                    hobbies.add(chBHobbieEscMusica.getText());
                if (chBHobbieDeportes.isSelected())
                    hobbies.add(chBHobbieDeportes.getText());
                if (chBHobbieCine.isSelected())
                    hobbies.add(chBHobbieCine.getText());
                if (chBHobbieCompras.isSelected())
                    hobbies.add(chBHobbieCompras.getText());
                per.setHobbies(hobbies);
                per.setProfesion(cbProfesion.getSelectedItem().toString());
                if (rButtonBachiller.isSelected())
                    per.setNivelAcademico(rButtonBachiller.getText());
                else if (rButtonTecnico.isSelected())
                    per.setNivelAcademico(rButtonTecnico.getText());
                else if (rButtonTecnologia.isSelected())
                    per.setNivelAcademico(rButtonTecnologia.getText());
                else if (rButtonPregrado.isSelected())
                    per.setNivelAcademico(rButtonPregrado.getText());
                else if (rButtonPosgrado.isSelected())
                    per.setNivelAcademico(rButtonPosgrado.getText());
                if (rButtonPosgrado.isSelected()){
                    if (rButtonColombia.isSelected())
                        per.setDondePosgrado(rButtonColombia.getText());
                    else if (rButtonExterior.isSelected())
                        per.setDondePosgrado(rButtonExterior.getText());

                    if (rButtonPropios.isSelected())
                        per.setRecursosPosgrado(rButtonPropios.getText());
                    else if (rButtonBecaGobierno.isSelected())
                        per.setRecursosPosgrado(rButtonBecaGobierno.getText());
                    else if (rButtonBecaFundacion.isSelected())
                        per.setRecursosPosgrado(rButtonBecaFundacion.getText());
                }
                aPers.add(per);

                buttonProcesarDatos.setEnabled(true);
                JOptionPane.showMessageDialog(null,"Registro almacenado");

                tfIdentificacion.setText("");
                tfNombre.setText("");
                sliderEdad.setValue(1);
                spinnerNumHijos.setValue(0);
                cbDepNacimiento.setSelectedIndex(0);
                cbMunNacimiento.setSelectedIndex(0);
                rButtonCasaSi.setSelected(false);
                rButtonCasaNo.setSelected(false);
                chBHobbieTV.setSelected(false);
                chBHobbieRRSS.setSelected(false);
                chBHobbieEscMusica.setSelected(false);
                chBHobbieDeportes.setSelected(false);
                chBHobbieCine.setSelected(false);
                chBHobbieCompras.setSelected(false);
                cbProfesion.setSelectedIndex(0);
                rButtonBachiller.setSelected(true);
                rButtonTecnico.setSelected(false);
                rButtonTecnologia.setSelected(false);
                rButtonPregrado.setSelected(false);
                rButtonPosgrado.setSelected(false);
                rButtonColombia.setSelected(false);
                rButtonExterior.setSelected(false);
                rButtonPropios.setSelected(false);
                rButtonBecaGobierno.setSelected(false);
                rButtonBecaFundacion.setSelected(false);
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos");
            }
        } catch (Exception e) {
            if (e.getClass().equals(NumberFormatException.class)){
                JOptionPane.showMessageDialog(null,"La identificación debe ser un numero");
            }
        }
    }
    public void procesarDatos(){

    }
}
