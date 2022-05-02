/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.io.*;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author egarduno
 */
public class LecturaDeArchivos {
    
    //--------------------------------------------------------------------------
    //Atributos
    //--------------------------------------------------------------------------
    private Estudiante estudiante;
    private Vector vectorPrincipal;
    File archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    FileWriter escribir;
    PrintWriter linea;
    DefaultTableModel modeloTabla;
    
    //--------------------------------------------------------------------------
    //Constructor
    //--------------------------------------------------------------------------
    public LecturaDeArchivos() 
    {
        vectorPrincipal = new Vector();
    }
    
    //--------------------------------------------------------------------------
    //Metodos
    //--------------------------------------------------------------------------    
    public void registrarEstudiante(String nombre, String matricula, String semestre)
    {
        estudiante = new Estudiante(nombre, matricula, semestre);
        
        vectorPrincipal.add(estudiante);
        crearArchivo();
    }
    
    
    public void crearArchivo()
    {
        File archivo = new File("Estudiantes.txt");//Creacion de un archivo de tipo File
        String Documento;
        if(!archivo.exists())
        {
            try {
                archivo.createNewFile();
                Documento = estudiante.getMatricula() + "|" + estudiante.getNombre() + "|" + estudiante.getSemestre();
                guardarArchivo(archivo, Documento);
                
            } catch (IOException ex) {
                   
            }
        } else {
            
                Documento = estudiante.getMatricula() + "|" + estudiante.getNombre() + "|" + estudiante.getSemestre();
                registrarDatos(archivo, Documento);
            
            }
        
    }
    
    public void registrarDatos(File archivo, String Documento){
        
        try {
            FileWriter escribir = new FileWriter(archivo, true);//Clase para escribir con parametros de String
            BufferedWriter buffer = new BufferedWriter(escribir);
            PrintWriter linea = new PrintWriter(escribir);//Clase que permite escribir los caracteres en pantalla apartir del objeto escribir
            linea.println(Documento);
            linea.close();
            escribir.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e);
            
        }
   
    }
    
    public void guardarArchivo(File archivo, String documento)
    {
        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
        } catch (Exception e){
            
        }
    }
    
    
    
    public DefaultTableModel listaEstudiantes()
    {
        //Vector cabeceras = new Vector();
        vectorPrincipal.addElement("Matricula");
        vectorPrincipal.addElement("Nombre");
        vectorPrincipal.addElement("Semestre");
        
        modeloTabla = new DefaultTableModel(vectorPrincipal, 0);
        
        try{
            FileReader leer = new FileReader("Alumnos.txt");
            BufferedReader bufferLeer = new BufferedReader(leer);
            
            String d;
            while((d = bufferLeer.readLine())!=null)
            {
                StringTokenizer datos = new StringTokenizer(d,"|");
                Vector x = new Vector();
                while(datos.hasMoreTokens())  
                {
                    x.addElement((datos.nextToken()));  
                }
                modeloTabla.addRow(x);
            }  
            
        } catch (Exception e){
            
        }
        
        return modeloTabla;
    }
        
    
}
