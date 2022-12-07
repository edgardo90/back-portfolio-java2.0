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
import com.portafolio.apiPortafolio.Repository.EducationRepository;// traigo mi repository que cree
import com.portafolio.apiPortafolio.Model.EducationModel; // importo el modelo que cree


/**
 *
 * @author edgar
 */

@Service
public class EducationService implements  IEducation{
    
    @Autowired
    private EducationRepository educationRepository;

    @Override
    public List<EducationModel> getEducations() { // traigo todas las educations
        List<EducationModel> educations = educationRepository.findAll();
        return  educations;
    }

    @Override
    public void saveEducation(EducationModel education) { // guardo la education de la data base
        educationRepository.save(education);
    }

    @Override
    public void deleteEducation(int id) { // elemino la education por su id de la data base
        educationRepository.deleteById(id);
    }

    @Override
    public EducationModel findEducation(int id) { // traigo una education por su id de la data base
        EducationModel education = educationRepository.findById(id).orElse(null);
        return education;
    }
    
    
}
