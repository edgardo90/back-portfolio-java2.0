/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//esto es una interface
package com.portafolio.apiPortafolio.Service;
//
import java.util.List;
import com.portafolio.apiPortafolio.Model.EducationModel;

/**
 *
 * @author edgar
 */


public interface IEducation {
    
    public List<EducationModel> getEducations(); //  trae todas las Educations
    
    public void saveEducation (EducationModel education); // guardo la Education en la base de datos
    
    public void deleteEducation(int id); // borro la education
    
    public EducationModel findEducation(int id); // busco la education por su id
    
}
