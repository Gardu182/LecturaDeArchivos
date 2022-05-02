/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author egarduno
 */
public class Estudiante {
    
    //--------------------------------------------------------------------------
    //Atributos
    //--------------------------------------------------------------------------
    private String nombre;
    private String matricula;
    private String semestre;

    //--------------------------------------------------------------------------
    //Constructor
    //--------------------------------------------------------------------------
    public Estudiante(String nombre, String matricula, String semestre) {    
        this.nombre = nombre;
        this.matricula = matricula;
        this.semestre = semestre;
    }

    //--------------------------------------------------------------------------
    //Metodos
    //--------------------------------------------------------------------------
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    } 
    
}
