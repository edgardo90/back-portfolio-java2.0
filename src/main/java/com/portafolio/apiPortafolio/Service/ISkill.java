/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//esto es una interface
package com.portafolio.apiPortafolio.Service;
//
import java.util.List;
import com.portafolio.apiPortafolio.Model.SkillModel;

/**
 *
 * @author edgar
 */
public interface ISkill {
    
    public List<SkillModel> getSkills(); //  trae todas las Skills
    
    public void saveSkill (SkillModel skill); // guardo la skill en la base de datos
    
    public void deleteSkill(int id); // borro la skill
    
    public SkillModel findSkill(int id); // busco la skill por su id
    
}
