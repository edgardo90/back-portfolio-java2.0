/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.apiPortafolio.Controller;

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
import com.portafolio.apiPortafolio.Model.AboutModel;  //modelo del about
import com.portafolio.apiPortafolio.Model.StatusRuta; //modelo que sirve para enviar un msg en formato json del estado de la ruta
import com.portafolio.apiPortafolio.Service.IAbout;
import com.portafolio.apiPortafolio.Dto.AboutDto; // // dto para el put del about
import org.springframework.security.access.prepost.PreAuthorize;

/**
 *
 * @author edgar
 */

@RestController // para emepezar hacer el ruteo
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) // configuro los corrs
public class AboutController {
    
    @Autowired
    private IAbout interAbout;
    
    @GetMapping("/about/all") // trae todas los about
    public List<AboutModel> getAbout(){
        List<AboutModel> abouts = interAbout.getAbout();
        return abouts;
    }
    
    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @PostMapping("/about/create") // crea el about
    public ResponseEntity<Object> createAbout(@RequestBody AboutModel about ){
        interAbout.saveAbout(about);
        return new ResponseEntity<>(about , HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @DeleteMapping("/about/deleted/{id}")// elemina un about por su id
    public  ResponseEntity<Object> deletedAbout(@PathVariable int id){
        AboutModel about = interAbout.findAbout(id);
        if(about == null){
            return new ResponseEntity<>(new StatusRuta("No se encontro ese About para eleminar"), HttpStatus.BAD_REQUEST);
        }
        interAbout.deleteAbout(id);
        return new ResponseEntity<>(new StatusRuta("About eleminado con exito") , HttpStatus.OK );
    }
    
    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @GetMapping("about/{id}")//traigo un about por su id
    public  ResponseEntity<Object> getAboutById(@PathVariable int id){
        AboutModel about = interAbout.findAbout(id);
        if(about == null){
            return new ResponseEntity<>(new StatusRuta("No se encontro ese About"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(about , HttpStatus.OK);
    }
    
    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @PutMapping("about/edit/{id}")//modifico un about por su id
    public ResponseEntity<Object> editBout(@PathVariable int id , @RequestBody AboutDto aboutDto){
        AboutModel about = interAbout.findAbout(id);
        if(about == null){
            return new ResponseEntity<>(new StatusRuta("No se encontro ese About para modificar"), HttpStatus.BAD_REQUEST);
        }
        if(aboutDto.getTitle().length() > 0){ // si viene algo del body en el "title" y es mayor a 0 
             about.setTitle(aboutDto.getTitle());  // que modifique lo que hay en about.title
         }
        if(aboutDto.getSummary().length() > 0){ 
             about.setSummary(aboutDto.getSummary());  
         }
        interAbout.saveAbout(about);
        return new ResponseEntity<>(about , HttpStatus.OK);
    }
    
    
}
