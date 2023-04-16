package univalle.fdpoe;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Clase que extiende JFrame y contiene los diferentes elementos del programa
 * @author SamuelOrtizS
 * @version 16/04/2023/A
 */
public class Ventana extends JFrame {
    private JTabbedPane tpPaneles;
    private JPanel panel1;
    private JPanel panelDatosPersonales;
    private JPanel panelDatosAcademicos;
    private JPanel panelEstadisticas;
    private JButton buttonGuardar;
    private JButton buttonProcesarDatos;
    private JTextPane tpResultados;
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
    private JLabel labelID;
    private JLabel labelNombre;
    private JLabel lEdad;
    private JLabel lNumHijos;
    private JLabel labelDepartamento;
    private JLabel labelMunicipio;
    private JLabel labelCasa;
    private JLabel labelHobbies;
    private JLabel labelProfesion;
    private JLabel labelNivel;
    private JLabel labelPosgrado;
    private JLabel labelPosgradoDonde;
    private JLabel labelPosgradoRecursos;
    ArrayList<Persona> aPers;

    /**
     * Constructor de la ventana
     */
    public Ventana() {
        super("Cuestionario");
        setContentPane(panel1);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        //Arreglo dinámico que guarda los datos de cada persona
        aPers = new ArrayList<Persona>();

        //Cambio el mensaje de edad de acuerdo con el slider
        sliderEdad.addChangeListener(e -> {
            if (sliderEdad.getValue() == 1)
                labelEdad.setText(sliderEdad.getValue() + " año");
            else
                labelEdad.setText(sliderEdad.getValue() + " años");
        });

        //El control para el número de hijos se mantiene entre 0 y 10, con incrementos de 1 en 1
        spinnerNumHijos.setModel(new SpinnerNumberModel(0,0,10,1));

        //Arreglos que contiene el modelo para el combobox para cada departamento
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

        //Cambio el modelo del combobox a partir del departamento seleccionado y lo inicializo con el primer departamento
        cbMunNacimiento.setModel(new DefaultComboBoxModel(aCundinamarca));

        cbDepNacimiento.addItemListener(e -> {
            String departamentoSeleccionado = cbDepNacimiento.getSelectedItem().toString();
            switch (departamentoSeleccionado) {
                case "Cundinamarca" -> {
                    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(aCundinamarca);
                    cbMunNacimiento.setModel(modelo);
                }
                case "Antioquia" -> {
                    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(aAntioquia);
                    cbMunNacimiento.setModel(modelo);
                }
                case "Valle del Cauca" -> {
                    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(aValle);
                    cbMunNacimiento.setModel(modelo);
                }
                case "Santander" -> {
                    DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>(aSantander);
                    cbMunNacimiento.setModel(modelo);
                }
                case "Atlántico" -> {
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
        rButtonPosgrado.addItemListener(e -> {
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
        });

        //Asigno las funcionalidades de los botones Guardar y Procesar Datos
        buttonGuardar.addActionListener(e -> guardarDatos());
        buttonProcesarDatos.addActionListener(e -> procesarDatos());

        //Personalización de la interfaz
        personalizacion();
    }

    /**
     * Método de uso interno que contiene la funcionalidad del botón Guardar
     */
    public void guardarDatos(){
        try {
            //Verifico que se han ingresado todos los datos
            if (!tfIdentificacion.getText().equals("") && !tfNombre.getText().equals("") && (rButtonCasaSi.isSelected() || rButtonCasaNo.isSelected()) && (rButtonBachiller.isSelected() || rButtonTecnico.isSelected() || rButtonTecnologia.isSelected() || rButtonPregrado.isSelected() || rButtonPosgrado.isSelected())) {
                //Creo una nueva persona y le asigno los datos
                Persona per = new Persona();
                per.setId(Integer.parseInt(tfIdentificacion.getText()));
                per.setNombre(tfNombre.getText());
                per.setEdad(sliderEdad.getValue());
                per.setNumHijos(Integer.parseInt(spinnerNumHijos.getValue().toString()));
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
                //Agrego la nueva persona al arreglo dinámico de personas
                aPers.add(per);

                //Opcion para imprimir en consola los datos guardados durante la depuracion del programa
                //per.imprimirDatos();

                //Habilito el botón de procesar datos y muestro un mensaje al usuario
                buttonProcesarDatos.setEnabled(true);
                JOptionPane.showMessageDialog(null,"Registro almacenado");

                //Limpio los controles
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
                //Si falta un dato muestro un aviso al usuario sin hacer nada mas
                JOptionPane.showMessageDialog(null, "Debe ingresar todos los datos");
            }
        } catch (Exception e) {
            //Si se produce una excepción esperada, en este caso una identificacion que no es un número
            if (e.getClass().equals(NumberFormatException.class)){
                //Muestro un aviso al usuario para que lo corrija y no hago nada más
                JOptionPane.showMessageDialog(null,"La identificación debe ser un número");
            }
        }
    }

    /**
     * Método de uso interno que contiene la funcionalidad del botón Procesar Datos
     */
    public void procesarDatos(){
        //Variables locales para analizar los datos
        int sumEdad = 0, sumHijos = 0, sumCasaPropia = 0, sumMasTresHobbies = 0, sumPosgradoExterior = 0, sumBecaGobierno = 0;
        List lsDepartamentos = new ArrayList<String>();
        List lsMunicipios = new ArrayList<String>();
        List lsProfesiones = new ArrayList<String>();
        List lsNivelAcademico = new ArrayList<String>();
        String porDepartamento = "", porMunicipio = "", porProfesion = "", porNivelAcademico = "";

        //Recorro el arreglo de personas para extraer los datos relevantes
        for (Persona per2: aPers) {
            sumEdad += per2.getEdad();
            sumHijos += per2.getNumHijos();
            lsDepartamentos.add(per2.getDepartamentoNacimiento());
            lsMunicipios.add(per2.getMunicipioNacimiento());
            if (per2.isCasaPropia()) sumCasaPropia += 1;
            if (per2.getHobbies().size() > 3) sumMasTresHobbies += 1;
            lsProfesiones.add(per2.getProfesion());
            lsNivelAcademico.add(per2.getNivelAcademico());
            if (per2.getNivelAcademico().equals("Posgrado")) {
                if (per2.getDondePosgrado().equals("Exterior")) sumPosgradoExterior += 1;
                if (per2.getRecursosPosgrado().equals("Beca del gobierno")) sumBecaGobierno += 1;
            }
        }

        //Creo conjuntos y listas ordenadas sin duplicados a partir de las listas
        Set<String> cjDepartamentos = new HashSet<String>(lsDepartamentos);
        Set<String> cjMunicipios = new HashSet<String>(lsMunicipios);
        Set<String> cjProfesiones = new HashSet<String>(lsProfesiones);
        Set<String> cjNivelAcademico = new HashSet<String>(lsNivelAcademico);

        List<String> lsDepartamentosSinDuplicados = new ArrayList<>(cjDepartamentos);
        List<String> lsMunicipiosSinDuplicados = new ArrayList<>(cjMunicipios);
        List<String> lsProfesionesSinDuplicados = new ArrayList<>(cjProfesiones);
        List<String> lsNivelAcademicoSinDuplicados = new ArrayList<>(cjNivelAcademico);

        Collections.sort(lsDepartamentosSinDuplicados);
        Collections.sort(lsMunicipiosSinDuplicados);
        Collections.sort(lsProfesionesSinDuplicados);
        Collections.sort(lsNivelAcademicoSinDuplicados);

        //Recorro las listas y determino las cantidades por categoría
        for (String departamento: lsDepartamentosSinDuplicados) porDepartamento += departamento + ": " + Collections.frequency(lsDepartamentos, departamento) + "\n";
        for (String municipio: lsMunicipiosSinDuplicados) porMunicipio += municipio + ": " + Collections.frequency(lsMunicipios, municipio) + "\n";
        for (String profesion: lsProfesionesSinDuplicados) porProfesion += profesion + ": " + Collections.frequency(lsProfesiones, profesion) + "\n";
        for (String nivelAcademico: lsNivelAcademicoSinDuplicados) porNivelAcademico += nivelAcademico + ": " + Collections.frequency(lsNivelAcademico, nivelAcademico) + "\n";

        //Muestro los resultados de procesar los datos en el panel de texto
        tpResultados.setText(
                "RESULTADOS" +
                "\nNúmero de encuestados: " + aPers.size() +
                "\nPromedio de edad: " + (sumEdad/aPers.size()) +
                "\nPromedio de hijos: " + (sumHijos/aPers.size()) +
                "\nPersonas por departamento:\n" + porDepartamento +
                "Personas por municipio:\n" + porMunicipio +
                "Personas con casa propia: " + sumCasaPropia +
                "\nPersonas con más de tres hobbies: " + sumMasTresHobbies +
                "\nPersonas por profesión:\n" + porProfesion +
                "Personas por nivel académico:\n" + porNivelAcademico +
                "Personas posgrado en el exterior:" + sumPosgradoExterior +
                "\nPersonas con becas del gobierno:" + sumBecaGobierno
        );

        //Muestro la pestaña del panel y la enfoco
        tpPaneles.setSelectedIndex(2);
        tpResultados.requestFocus();
    }

    /**
     * Método de uso interno que contiene la personalización del programa
     */
    private void personalizacion(){
        //Uso un tono de azul como color principal para transmitir calma y seguridad en el manejo del programa y la información que contiene
        Color colorPrincipal = new Color(55, 73, 109);
        //Uso un tono de verde como color secundario por ser análogo del principal y enfatizar el botón de guardado como algo positivo
        Color colorSecundario = new Color(93, 168, 100);
        //Diferentes fuentes para los elementos de la interfaz
        Font fuenteTitulos = new Font("JetBrains Mono",Font.BOLD,13);
        Font fuenteSubtitulos = new Font("JetBrains Mono",Font.BOLD,12);
        Font fuenteRegular = new Font("Arial",Font.PLAIN,12);
        Font fuenteConsolas = new Font("Consolas",Font.PLAIN,12);

        //Cambio los colores de los botones y algunas de sus propiedades
        buttonGuardar.setBackground(colorSecundario);
        buttonGuardar.setForeground(Color.WHITE);
        buttonGuardar.setFocusPainted(false);
        buttonGuardar.setBorderPainted(false);

        buttonProcesarDatos.setBackground(colorPrincipal);
        buttonProcesarDatos.setForeground(Color.WHITE);
        buttonProcesarDatos.setFocusPainted(false);
        buttonProcesarDatos.setBorderPainted(false);

        //Asigno las fuentes
        tpPaneles.setFont(fuenteTitulos);
        labelEdad.setFont(fuenteSubtitulos);
        labelID.setFont(fuenteSubtitulos);
        labelNombre.setFont(fuenteSubtitulos);
        lEdad.setFont(fuenteSubtitulos);
        lNumHijos.setFont(fuenteSubtitulos);
        labelDepartamento.setFont(fuenteSubtitulos);
        labelMunicipio.setFont(fuenteSubtitulos);
        labelCasa.setFont(fuenteSubtitulos);
        labelHobbies.setFont(fuenteSubtitulos);
        labelProfesion.setFont(fuenteSubtitulos);
        labelNivel.setFont(fuenteSubtitulos);
        labelPosgrado.setFont(fuenteSubtitulos);
        labelPosgradoDonde.setFont(fuenteSubtitulos);
        labelPosgradoRecursos.setFont(fuenteSubtitulos);

        buttonGuardar.setFont(fuenteTitulos);
        buttonProcesarDatos.setFont(fuenteTitulos);

        tpResultados.setFont(fuenteConsolas);

        tfIdentificacion.setFont(fuenteRegular);
        tfNombre.setFont(fuenteRegular);
        sliderEdad.setFont(fuenteRegular);
        spinnerNumHijos.setFont(fuenteRegular);
        cbDepNacimiento.setFont(fuenteRegular);
        cbMunNacimiento.setFont(fuenteRegular);
        rButtonCasaSi.setFont(fuenteRegular);
        rButtonCasaNo.setFont(fuenteRegular);
        chBHobbieTV.setFont(fuenteRegular);
        chBHobbieRRSS.setFont(fuenteRegular);
        chBHobbieEscMusica.setFont(fuenteRegular);
        chBHobbieDeportes.setFont(fuenteRegular);
        chBHobbieCine.setFont(fuenteRegular);
        chBHobbieCompras.setFont(fuenteRegular);
        cbProfesion.setFont(fuenteRegular);
        rButtonBachiller.setFont(fuenteRegular);
        rButtonTecnico.setFont(fuenteRegular);
        rButtonTecnologia.setFont(fuenteRegular);
        rButtonPregrado.setFont(fuenteRegular);
        rButtonPosgrado.setFont(fuenteRegular);
        rButtonColombia.setFont(fuenteRegular);
        rButtonExterior.setFont(fuenteRegular);
        rButtonPropios.setFont(fuenteRegular);
        rButtonBecaGobierno.setFont(fuenteRegular);
        rButtonBecaFundacion.setFont(fuenteRegular);
    }
}
