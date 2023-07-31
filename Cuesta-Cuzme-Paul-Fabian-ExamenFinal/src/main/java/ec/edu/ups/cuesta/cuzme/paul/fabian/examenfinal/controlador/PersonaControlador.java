/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.cuesta.cuzme.paul.fabian.examenfinal.controlador;

import ec.edu.ups.cuesta.cuzme.paul.fabian.examenfinal.dao.PersonaDAO;
import ec.edu.ups.cuesta.cuzme.paul.fabian.examenfinal.idao.IDAOPersona;
import ec.edu.ups.cuesta.cuzme.paul.fabian.examenfinal.modelo.Persona;

/**
 *
 * @author ESTUDIANTE
 */
public class PersonaControlador {

    private IDAOPersona personaDAO;

    public PersonaControlador(IDAOPersona personaDAO) {
        this.personaDAO = personaDAO;
    }

    public void crear(Persona persona) {
        personaDAO.guardarPersona(persona);
    }

    public long edadMaxima() {
        return personaDAO.obtenerDatosPersonaMayor();
    }

    public double promedioSueldo() {
        return personaDAO.obtenerPromedioSueldo();
    }

}
