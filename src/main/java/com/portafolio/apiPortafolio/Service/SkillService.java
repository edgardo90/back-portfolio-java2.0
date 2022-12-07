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
import com.portafolio.apiPortafolio.Model.SkillModel;
import com.portafolio.apiPortafolio.Repository.SkilllRepository;

/**
 *
 * @author edgar
 */

@Service
public class SkillService implements ISkill {
    
    @Autowired
    private SkilllRepository skilllRepository;

    @Override
    public List<SkillModel> getSkills() { // trae todos los skills
        List<SkillModel> skills = skilllRepository.findAll();
        return  skills;
    }

    @Override
    public void saveSkill(SkillModel skill) { // guardo una skill en la base de datos
        skilllRepository.save(skill);
    }

    @Override
    public void deleteSkill(int id) { // elemino una skill en la base de datos por su id
        skilllRepository.deleteById(id);
    }

    @Override
    public SkillModel findSkill(int id) { // traigo una skill por su id
        SkillModel skill = skilllRepository.findById(id).orElse(null);
        return  skill;
    }
    
    
}
