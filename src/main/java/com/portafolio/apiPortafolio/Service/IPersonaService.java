/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// esto es una interface
package com.portafolio.apiPortafolio.Service;
//
import java.util.List;
import com.portafolio.apiPortafolio.Model.PersonaModel;

/**
 *
 * @author edgar
 */
public interface IPersonaService {
    
    public List<PersonaModel> getPeronas(); //  trae las personas
    
    public void savePersona(PersonaModel persona); // guardo la persona en la base de datos
    
    public void deletePersona(int id); // borro la persona
    
    public PersonaModel findPersona(int id); // busco la persona por su id
    
}
