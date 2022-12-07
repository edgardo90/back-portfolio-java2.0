/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.apiPortafolio.Controller;
//

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
import java.util.List; //
import java.util.ArrayList;// esto sirve para crear un array
import java.util.*;
import java.util.stream.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
//importo lo que cree
import com.portafolio.apiPortafolio.Model.ExperienceModel; //modelo de Experience
import com.portafolio.apiPortafolio.Model.StatusRuta; // modelo que sirve para enviar un msg en formato json del estado de la ruta
import com.portafolio.apiPortafolio.Service.IExperience;
import com.portafolio.apiPortafolio.Dto.ExperienceDto;//dto para utilizar el put de metodo Experience
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author edgar
 */

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) // configuro los corrs
public class ExperienceController {
    
    @Autowired
    private IExperience interExperience; //aca traigo el servicio que cree
    
    @GetMapping("/experience/all") // trae todas las experiencias
    public List<ExperienceModel> getExperiences(){
        List<ExperienceModel> experiences = interExperience.getExperiences();
        return experiences;
    }
    
    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @PostMapping("/experience/create") // creo una experience
     public ResponseEntity<Object> createPersona(@RequestBody ExperienceModel experience){
         interExperience.saveExperience(experience);
         return new ResponseEntity<>(experience, HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @DeleteMapping("/experience/deleted/{id}") // elemino una experience
     public ResponseEntity<?> deletedExperience(@PathVariable int id){
         ExperienceModel experience = interExperience.findExperience(id);
         if(experience == null){
             StatusRuta status = new StatusRuta("No se encontro ese id de esa experiencia para eleminar");
             return  new ResponseEntity<>(status , HttpStatus.BAD_REQUEST);
         }
         interExperience.deleteExperience(id);
         StatusRuta status = new StatusRuta("Experiencia eleminada");
         return new ResponseEntity<>(status , HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @GetMapping("/experience/{id}") // buscona una experience por su id
     public ResponseEntity<Object> getExperienceById(@PathVariable int id){
         ExperienceModel experience = interExperience.findExperience(id);
         if(experience == null){
             StatusRuta status = new StatusRuta("No se encontro esa experiencia");
             return new  ResponseEntity<>(status , HttpStatus.BAD_REQUEST);
         }
         return new ResponseEntity<>(experience , HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @PutMapping("/experience/edit/{id}") // modifico una experience por su id
     public ResponseEntity<Object> editExperience(@PathVariable int id , @RequestBody ExperienceDto experienceDto){
         ExperienceModel experience = interExperience.findExperience(id);
         if(experience == null){
             return new ResponseEntity<>(new StatusRuta("No se encontro esa experiencia para modificar") , HttpStatus.BAD_REQUEST);
         }
         System.out.println(experienceDto.getTitle()); 
         if(experienceDto.getTitle().length() > 0){ // si viene algo del body en el "title" y es mayor a 0 
             experience.setTitle(experienceDto.getTitle());  // que modifique lo que hay en experience.title
         }
         if(experienceDto.getCompanyName().length() > 0){ 
             experience.setCompanyName(experienceDto.getCompanyName());  
         }
         if(experienceDto.getLogoCompany().length() > 0){ 
             experience.setLogoCompany(experienceDto.getLogoCompany());  
         }
         if(experienceDto.getDateStart().length() > 0){ 
             experience.setDateStart(experienceDto.getDateStart());  
         }
         if(experienceDto.getDateEnd().length() > 0){
             experience.setDateEnd(experienceDto.getDateEnd() );
         }
         if(experienceDto.getDescription().length() > 0){ 
             experience.setDescription(experienceDto.getDescription());  
         }
         interExperience.saveExperience(experience);
         return new ResponseEntity<>(experience , HttpStatus.OK);
     }
    
}
