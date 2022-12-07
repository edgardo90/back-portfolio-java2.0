/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.apiPortafolio.Service;
//
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired ;//
import java.util.List;
//traigo lo que cree
import com.portafolio.apiPortafolio.Repository.PersonaRepository; // traigo mi repository que cree
import com.portafolio.apiPortafolio.Model.PersonaModel; // importo el modelo que cree 

/**
 *
 * @author edgar
 */
@Service
public class PersonaService implements IPersonaService{
    
    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public List<PersonaModel> getPeronas() { // trae todos las personas
        List<PersonaModel> listPersons = personaRepository.findAll();
        return listPersons;
    }

    @Override
    public void savePersona(PersonaModel persona) { // guarda la persona en la base de datos
        personaRepository.save(persona);
    }

    @Override
    public void deletePersona(int id) { // elemina la persona por su id
        personaRepository.deleteById(id);
    }

    @Override
    public PersonaModel findPersona(int id) { // busca la persona por su id
        PersonaModel person = personaRepository.findById(id).orElse(null);
        return person;
    }
    
}
