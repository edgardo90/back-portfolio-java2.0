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
import com.portafolio.apiPortafolio.Model.PersonaModel; //modelo crear la persona
import com.portafolio.apiPortafolio.Model.StatusRuta; //  // modelo que sirve para enviar un msg en formato json del estado de la ruta
import com.portafolio.apiPortafolio.Service.IPersonaService;
import com.portafolio.apiPortafolio.Dto.PersonaDto;//dto para utilizar el put de metodo persona
import org.springframework.security.access.prepost.PreAuthorize;


/**
 *
 * @author edgar
 */

@RestController // para emepezar hacer el ruteo
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) // configuro los corrs
public class PersonaController {
    
     @Autowired
     private IPersonaService interPersonaService; //aca traigo el servicio que cree
     
     @GetMapping("/persona/all") // trae todas las personas
     public List<PersonaModel> getPersonas(){
         List<PersonaModel> persons = interPersonaService.getPeronas();
         return persons;
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @PostMapping("/persona/create") // creo una persona
     public ResponseEntity<?> createPersona(@RequestBody PersonaModel person){
         interPersonaService.savePersona(person);
         return new ResponseEntity<>(person, HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @DeleteMapping("/persona/deleted/{id}") // elemino una persona
     public ResponseEntity<?> deletedPerson(@PathVariable int id){
         PersonaModel person = interPersonaService.findPersona(id);
         if(person == null){
             StatusRuta status = new StatusRuta("No se encontro ese id de persona para eleminar");
             return  new ResponseEntity<>(status , HttpStatus.BAD_REQUEST);
         }
         interPersonaService.deletePersona(id);
         StatusRuta status = new StatusRuta("Persona eleminada");
         return new ResponseEntity<>(status , HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @GetMapping("/persona/{id}") // buscona una persona por su id
     public ResponseEntity<Object> getPersonById(@PathVariable int id){
         PersonaModel person = interPersonaService.findPersona(id);
         if(person == null){
             StatusRuta status = new StatusRuta("No se encontro esa persona");
             return new  ResponseEntity<>(status , HttpStatus.BAD_REQUEST);
         }
         return new ResponseEntity<>(person , HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @PutMapping("/persona/edit/{id}")// modifico una persona por su id
     public ResponseEntity<Object> editPerson(@PathVariable int id , @RequestBody PersonaDto personaDto){
         PersonaModel person = interPersonaService.findPersona(id);
         if(person == null){
             StatusRuta status = new StatusRuta("No se encontra esa persona para modificar");
             return  new ResponseEntity<>(status , HttpStatus.BAD_REQUEST);
         }
         //System.out.println(personaDto.getName()); veo por consola lo que me trae por body personaDto.name
         if(personaDto.getName().length() > 0){ // si viene algo del body en el "name" y es mayor a 0 
             person.setName(personaDto.getName());  // que modifique lo que hay en person.name
         }
         if(personaDto.getSurname().length() > 0){ 
             person.setSurname(personaDto.getSurname());  
         }
         if(personaDto.getImagen().length() > 0){ 
             person.setImagen(personaDto.getImagen());  
         }
         if(personaDto.getPhone().length() > 0){ 
             person.setPhone(personaDto.getPhone());  
         }
         if(personaDto.getEmail().length() > 0){ 
             person.setEmail(personaDto.getEmail());  
         }
         if(personaDto.getCountry().length() > 0){ 
             person.setCountry(personaDto.getCountry());  
         }
         interPersonaService.savePersona(person);
         return new ResponseEntity<>(person , HttpStatus.OK);
     }
    
}
