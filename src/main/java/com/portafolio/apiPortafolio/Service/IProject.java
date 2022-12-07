/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//esto es una interface
package com.portafolio.apiPortafolio.Service;
//
import java.util.List;
import com.portafolio.apiPortafolio.Model.ProjectModel;

/**
 *
 * @author edgar
 */
public interface IProject {
    
    public List<ProjectModel> getProjects(); //  trae todos los Projects
    
    public void saveProject (ProjectModel proyect); // guardo el Project en la base de datos
    
    public void deleteProject(int id); // borro el project por su id
    
    public ProjectModel findProject(int id); // busco el project por su id
    
}
