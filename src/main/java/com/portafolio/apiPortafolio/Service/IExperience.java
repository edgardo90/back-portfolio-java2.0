/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.apiPortafolio.Service;
//
import java.util.List;
import com.portafolio.apiPortafolio.Model.ExperienceModel;

/**
 *
 * @author edgar
 */


public interface IExperience {
    
    public List<ExperienceModel> getExperiences(); //  trae todas las Experience
    
    public void saveExperience(ExperienceModel experience); // guardo la Experience en la base de datos
    
    public void deleteExperience(int id); // borro la experience
    
    public ExperienceModel findExperience(int id); // busco la experience por su id
    
}
