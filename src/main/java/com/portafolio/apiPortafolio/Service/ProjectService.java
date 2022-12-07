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
import com.portafolio.apiPortafolio.Model.ProjectModel;
import com.portafolio.apiPortafolio.Repository.ProjectRepository;

/**
 *
 * @author edgar
 */

@Service
public class ProjectService implements IProject{
    
    @Autowired
    private ProjectRepository proyectRepository;

    @Override
    public List<ProjectModel> getProjects() { // traigo todos los proyect de la data base
        List<ProjectModel> proyects = proyectRepository.findAll();
        return  proyects;
    }

    @Override
    public void saveProject(ProjectModel proyect) { // guardo un proyect en la data base
        proyectRepository.save(proyect);
    }

    @Override
    public void deleteProject(int id) { // elemino un proyect de la data base by su id
        proyectRepository.deleteById(id);
    }

    @Override
    public ProjectModel findProject(int id) { // traigo un proyect de la data base by su id
        ProjectModel proyect = proyectRepository.findById(id).orElse(null);
        return proyect;
    }
    
}
