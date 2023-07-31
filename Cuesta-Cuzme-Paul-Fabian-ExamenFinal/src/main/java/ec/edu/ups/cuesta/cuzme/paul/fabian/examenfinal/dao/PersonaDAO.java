/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.cuesta.cuzme.paul.fabian.examenfinal.dao;

import ec.edu.ups.cuesta.cuzme.paul.fabian.examenfinal.idao.IDAOPersona;
import ec.edu.ups.cuesta.cuzme.paul.fabian.examenfinal.modelo.Persona;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ESTUDIANTE
 */
public class PersonaDAO implements IDAOPersona {

    String ruta = "persona.dat";
    RandomAccessFile archivo;


    
    private long tamaño() {
        try {
            return this.archivo.length();
        } catch (IOException e) {
            return 0;
        }
    }

    @Override
    public void guardarPersona(Persona persona) {
        try {
     archivo = new RandomAccessFile(ruta, "rw");
            archivo.seek(archivo.length());

            archivo.writeLong(persona.getCodigo());
            archivo.writeInt(persona.getEdad());
            archivo.writeDouble(persona.getSueldo());

            archivo.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public long obtenerDatosPersonaMayor() {
        int i = 20;
        try {
            archivo = new RandomAccessFile(ruta, "rw");
            long codigo = archivo.readLong();
            
            int edad1= archivo.readInt();
            
            while (i <= tamaño()) {
                archivo.seek(8 + i);
                int edad2 = archivo.readInt();
                
                if(edad2==0){
                    
                }else{
                if(edad1 >edad2){
                    i = i + 20;
                }else if(edad1==edad2){
                    edad1=edad2;
                    archivo.seek(4+i);
                    
                    codigo =archivo.readLong();
                    i = i + 20;
                }else if(edad1< edad2){
                edad1=edad2;
                i = i + 20;
            }
                
            }
            }
            System.out.println(edad1);
            return codigo;
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return 0;
    }

    @Override
    public double obtenerPromedioSueldo() {
        int i = 20;
        int j=0;
        try{
            archivo = new RandomAccessFile(ruta, "rw");
            archivo.seek(12);
            int sueldo = archivo.readInt();
            j+=1;
            
            while(i<= tamaño()){
                archivo.seek(12+i);
                sueldo = sueldo + archivo.readInt();
                j+=1;
            }
            return sueldo/j;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return 0;
    }

}
