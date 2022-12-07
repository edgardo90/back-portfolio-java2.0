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
import com.portafolio.apiPortafolio.Model.EducationModel; //modelo de Education
import com.portafolio.apiPortafolio.Service.IEducation; //
import com.portafolio.apiPortafolio.Dto.EducationDto; //dto para utilizar el put de metodo Education
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author edgar
 */

@RestController
@RequestMapping("/education") // con esto todas las rutas de abajo empieza con /auth
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) // configuro los corrs
public class EducationController {
    
    @Autowired
    private IEducation interEducation; //aca traigo el servicio que cree
    
    @GetMapping("/all") // ruta que trae todas las educations
    public List<EducationModel> getEducations(){
        List<EducationModel> educations = interEducation.getEducations();
        return educations;
    }
    
    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @PostMapping("/create") // creo una education
     public ResponseEntity<Object> createEducation(@Valid  @RequestBody EducationModel education , BindingResult bindingResult){
         if(bindingResult.hasErrors()){
            return new ResponseEntity(new StatusRuta("Campos mal puestos , institucion , titulo o fecha de incio estan vacio"),HttpStatus.BAD_REQUEST);
        }
         interEducation.saveEducation(education);
         return new ResponseEntity<>(education, HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @DeleteMapping("/deleted/{id}") // elemino una education
     public ResponseEntity<Object> deletedEducation(@PathVariable int id){
         EducationModel education = interEducation.findEducation(id);
         if(education == null){
             StatusRuta status = new StatusRuta("No se encontro ese id de esa educacion para eleminar");
             return  new ResponseEntity<>(status , HttpStatus.BAD_REQUEST);
         }
         interEducation.deleteEducation(id);
         StatusRuta status = new StatusRuta("Educacion eleminada");
         return new ResponseEntity<>(status , HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @GetMapping("/{id}") // buscona una experience por su id
     public ResponseEntity<Object> getEducationById(@PathVariable int id){
         EducationModel education = interEducation.findEducation(id);
         if(education == null){
             StatusRuta status = new StatusRuta("No se encontro esa educacion");
             return new  ResponseEntity<>(status , HttpStatus.BAD_REQUEST);
         }
         return new ResponseEntity<>(education , HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @PutMapping("/edit/{id}") // modifico una experience por su id
     public ResponseEntity<Object> editEducation( @PathVariable int id , @Valid  @RequestBody EducationDto educationDto, BindingResult bindingResult){
         EducationModel education = interEducation.findEducation(id);
         if(education == null){
             return new ResponseEntity<>(new StatusRuta("No se encontro esa experiencia para modificar") , HttpStatus.BAD_REQUEST);
         }
         if(bindingResult.hasErrors()){
            return new ResponseEntity(new StatusRuta("Campos mal puestos , institucion, titulo ,o fecha de incio estan vacio"),HttpStatus.BAD_REQUEST);
        }
         education.setInstitution(educationDto.getInstitution());
         education.setTitleName(educationDto.getTitleName());
         education.setStartDate(educationDto.getStartDate());
         education.setEndDate(educationDto.getEndDate());
         education.setDescription(educationDto.getDescription());
         education.setCertificateLink(educationDto.getCertificateLink());
         education.setInstitutionLogo(educationDto.getInstitutionLogo());
         interEducation.saveEducation(education);
         return new ResponseEntity<>(education , HttpStatus.OK);
     }
    
}
