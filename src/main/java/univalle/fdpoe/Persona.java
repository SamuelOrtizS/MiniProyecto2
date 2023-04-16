package univalle.fdpoe;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Esta clase define objetos que representan Personas y contienen diferentes datos acerca de la persona
 * @author SamuelOrtizS
 * @version 15/04/2023/A
 */
public class Persona {
    private int id, edad, numHijos;
    private String nombre, departamentoNacimiento, municipioNacimiento, profesion, nivelAcademico, dondePosgrado, recursosPosgrado;
    private boolean casaPropia;
    private ArrayList<String> Hobbies;

    /**
     * Constructor para una persona sin definir los datos
     */
    public Persona(){
        this.id = 0;
        this.edad = 0;
        this.numHijos = 0;
        this.nombre = "";
        this.departamentoNacimiento = "";
        this.municipioNacimiento = "";
        this.profesion = "";
        this.nivelAcademico = "";

        this.dondePosgrado = "";
        this.recursosPosgrado = "";
        this.casaPropia = false;
        Hobbies = new ArrayList<String>();
    }

    /**
     * Constructor para una Persona definiendo sus datos
     * @param id Entero que define el número de identificación de la Persona
     * @param edad Entero que define la edad en años de la Persona
     * @param numHijos Entero que define el numero de hijos de la persona
     * @param nombre Cadena que define el nombre de la persona
     * @param departamentoNacimiento Cadena que define el departamento de nacimiento de la persona
     * @param municipioNacimiento Cadena que define el municipio de nacimiento de la persona
     * @param profesion Cadena que define la profesión de la persona
     * @param nivelAcademico Cadena que define el nivel académico de la persona
     * @param dondePosgrado Cadena que define el lugar en donde la persona hizo el posgrado, de tenerlo
     * @param recursosPosgrado Cadena que define el tipo de recursos con los que la persona hizo el posgrado, de tenerlo
     * @param casaPropia Booleano que define si la Persona tiene casa propia
     * @param hobbies Conjunto que contiene cadenas que definen los hobbies de la Persona
     */
    public Persona(int id, int edad, int numHijos, String nombre, String departamentoNacimiento, String municipioNacimiento, String profesion, String nivelAcademico, String dondePosgrado, String recursosPosgrado, boolean casaPropia, ArrayList<String> hobbies){
        this.id = id;
        this.edad = edad;
        this.numHijos = numHijos;
        this.nombre = nombre;
        this.departamentoNacimiento = departamentoNacimiento;
        this.municipioNacimiento = municipioNacimiento;
        this.profesion = profesion;
        this.nivelAcademico = nivelAcademico;

        this.dondePosgrado = dondePosgrado;
        this.recursosPosgrado = recursosPosgrado;
        this.casaPropia = casaPropia;
        Hobbies = hobbies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamentoNacimiento() {
        return departamentoNacimiento;
    }

    public void setDepartamentoNacimiento(String departamentoNacimiento) {
        this.departamentoNacimiento = departamentoNacimiento;
    }

    public String getMunicipioNacimiento() {
        return municipioNacimiento;
    }

    public void setMunicipioNacimiento(String municipioNacimiento) {
        this.municipioNacimiento = municipioNacimiento;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getNivelAcademico() {
        return nivelAcademico;
    }

    public void setNivelAcademico(String nivelAcademico) {
        this.nivelAcademico = nivelAcademico;
    }

    public String getDondePosgrado() {
        return dondePosgrado;
    }

    public void setDondePosgrado(String dondePosgrado) {
        this.dondePosgrado = dondePosgrado;
    }

    public String getRecursosPosgrado() {
        return recursosPosgrado;
    }

    public void setRecursosPosgrado(String recursosPosgrado) {
        this.recursosPosgrado = recursosPosgrado;
    }

    public boolean isCasaPropia() {
        return casaPropia;
    }

    public void setCasaPropia(boolean casaPropia) {
        this.casaPropia = casaPropia;
    }

    public ArrayList<String> getHobbies() {
        return Hobbies;
    }

    public void setHobbies(ArrayList<String> hobbies) {
        Hobbies = hobbies;
    }

    public int getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(int numHijos) {
        this.numHijos = numHijos;
    }
}
