/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.apiPortafolio.Controller;
//

import com.portafolio.apiPortafolio.Dto.SkillDto;
import org.springframework.web.bind.annotation.CrossOrigin;//configura los coors
import org.springframework.web.bind.annotation.RequestMethod;// sirve para configurar los coors
import org.springframework.web.bind.annotation.GetMapping; // esto lo importo yo
import org.springframework.web.bind.annotation.PathVariable; // esto para que sea por params
import org.springframework.web.bind.annotation.RequestParam; // esto sirve para venir por query
import org.springframework.web.bind.annotation.RestController; // esto lo importo yo
import org.springframework.http.HttpStatus; // le doy el status si esta ok (creo que tambien si esta todo mal)
import org.springframework.http.ResponseEntity; //para enviar datos o un mensaje en formato json
import org.springframework.web.bind.annotation.PostMapping;//ruta para el post
import org.springframework.web.bind.annotation.RequestBody; // esto sirve para traer las variables del post
import org.springframework.web.bind.annotation.DeleteMapping; // ruta para el deleted
import org.springframework.web.bind.annotation.PutMapping; // ruta para el put
import org.springframework.beans.factory.annotation.Autowired;//// para el service , en este caso IPersonaService
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid; // esto sirve para la validacion
import org.springframework.validation.BindingResult; // esto sirve para la validacion
import java.util.List; //
import java.util.ArrayList;// esto sirve para crear un array
import java.util.*;
import java.util.stream.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
//importo lo que cree
import com.portafolio.apiPortafolio.Model.StatusRuta; // modelo que sirve para enviar un msg en formato json del estado de la ruta
import com.portafolio.apiPortafolio.Model.ProjectModel;
import com.portafolio.apiPortafolio.Dto.ProjectDto; // //dto para utilizar el put de metodo Proyect
import com.portafolio.apiPortafolio.Service.IProject;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author edgar
 */
@RestController
@RequestMapping("/project") // con esto todas las rutas de abajo empieza con /auth
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) // configuro los corrs
public class ProjectController {

    @Autowired
    private IProject interProyect; //aca traigo el servicio que cree

    @GetMapping("/all") // ruta que trae todas los Projects
    public List<ProjectModel> getProjects() {
        List<ProjectModel> proyect = interProyect.getProjects();
        return proyect;
    }

    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @PostMapping("/create") // creo un project
    public ResponseEntity<Object> createProject(@Valid @RequestBody ProjectModel proyect, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new StatusRuta("Campos mal puestos , titulo del proyecto , imagen o descripcion esta vacio"), HttpStatus.BAD_REQUEST);
        }
        interProyect.saveProject(proyect);
        return new ResponseEntity<>(proyect, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @DeleteMapping("/deleted/{id}") // elemino un project
    public ResponseEntity<Object> deletedProject(@PathVariable int id) {
        ProjectModel proyect = interProyect.findProject(id);
        if (proyect == null) {
            StatusRuta status = new StatusRuta("No se encontro ese id de ese proyecto para eleminar");
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }
        interProyect.deleteProject(id);
        StatusRuta status = new StatusRuta("Proyecto eleminado");
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @GetMapping("/{id}") // buscona un proyect por su id
    public ResponseEntity<Object> getProjectById(@PathVariable int id) {
        ProjectModel proyect = interProyect.findProject(id);
        if (proyect == null) {
            StatusRuta status = new StatusRuta("No se encontro ese proyecto");
            return new ResponseEntity<>(status, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(proyect, HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @PutMapping("/edit/{id}") // modifico un Proyect por su id
    public ResponseEntity<Object> editProyect(@PathVariable int id, @Valid @RequestBody ProjectDto proyectDto, BindingResult bindingResult) {
        ProjectModel proyect = interProyect.findProject(id);
        if (proyect == null) {
            return new ResponseEntity<>(new StatusRuta("No se encontro ese proyecto , para editar"), HttpStatus.BAD_REQUEST);
        }
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new StatusRuta("Campos mal puestos , titulo del proyecto , imagen o descripcion esta vacio"), HttpStatus.BAD_REQUEST);
        }
        proyect.setTitle(proyectDto.getTitle());
        proyect.setImage(proyectDto.getImage());
        proyect.setDescription(proyectDto.getDescription());
        proyect.setLinkBack(proyectDto.getLinkBack());
        proyect.setLinkFront(proyectDto.getLinkFront());
        proyect.setLinkProject(proyectDto.getLinkProject());
        interProyect.saveProject(proyect);
        return new ResponseEntity<>(proyect, HttpStatus.OK);
    }

}
//
