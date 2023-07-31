/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.cuesta.cuzme.paul.fabian.examenfinal.idao;

import ec.edu.ups.cuesta.cuzme.paul.fabian.examenfinal.modelo.Persona;

/**
 *
 * @author ESTUDIANTE
 */
public interface IDAOPersona {
    public abstract void guardarPersona(Persona persona);
    
    public abstract long obtenerDatosPersonaMayor();
    
    public abstract double obtenerPromedioSueldo();
}
