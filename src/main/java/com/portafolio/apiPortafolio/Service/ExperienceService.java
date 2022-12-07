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
import com.portafolio.apiPortafolio.Repository.ExperienceRepository;// traigo mi repository que cree
import com.portafolio.apiPortafolio.Model.ExperienceModel; // importo el modelo que cree

/**
 *
 * @author edgar
 */

@Service
public class ExperienceService implements IExperience{
    
    @Autowired
    private ExperienceRepository experienceRepository;

    @Override
    public List<ExperienceModel> getExperiences() { // traigo todos las experiences
        List<ExperienceModel> experiences = experienceRepository.findAll();
        return  experiences;
    }

    @Override
    public void saveExperience(ExperienceModel experience) { // guardo la experience en la data base
        experienceRepository.save(experience);
    }

    @Override
    public void deleteExperience(int id) { // elemino la experience en la data base por su id
        experienceRepository.deleteById(id);
    }

    @Override
    public ExperienceModel findExperience(int id) { // busco una experience por su id
        ExperienceModel experience = experienceRepository.findById(id).orElse(null);
        return experience;
    }
    
    
}
