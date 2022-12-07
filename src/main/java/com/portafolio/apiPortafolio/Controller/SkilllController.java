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
import com.portafolio.apiPortafolio.Model.SkillModel;
import com.portafolio.apiPortafolio.Service.ISkill;
import com.portafolio.apiPortafolio.Dto.SkillDto;
import org.springframework.security.access.prepost.PreAuthorize;


/**
 *
 * @author edgar
 */

@RestController
@RequestMapping("/skill") // con esto todas las rutas de abajo empieza con /auth
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) // configuro los corrs
public class SkilllController {
    
    @Autowired
    private ISkill interSkill; //aca traigo el servicio que cree
    
    @GetMapping("/all") // ruta que trae todas las skills
    public List<SkillModel> getSkills(){
        List<SkillModel> skills = interSkill.getSkills();
        return skills;
    }
    
    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @PostMapping("/create") // creo una skill
     public ResponseEntity<Object> createSkill(@Valid  @RequestBody SkillModel skill , BindingResult bindingResult){
         if(bindingResult.hasErrors()){
            return new ResponseEntity(new StatusRuta("Campos mal puestos , titulo del skill vacio  "),HttpStatus.BAD_REQUEST);
        }
         if(skill.getPercentage() <= 0 || skill.getPercentage() > 100){
             return new ResponseEntity<>(new StatusRuta("el porcentaje tiene que ser mayor a 0 y menor que 100"), HttpStatus.BAD_REQUEST );
         }
         if(skill.getColorpercentage() == null){
             skill.setColorpercentage("#175d9c");
         }
         if(skill.getColorCircle() == null){
             skill.setColorCircle("#20a8d8");
         }
         interSkill.saveSkill(skill);
         return new ResponseEntity<>(skill, HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @DeleteMapping("/deleted/{id}") // elemino una skill
     public ResponseEntity<Object> deletedSkill(@PathVariable int id){
         SkillModel skill = interSkill.findSkill(id);
         if(skill == null){
             StatusRuta status = new StatusRuta("No se encontro ese id de ese skill para eleminar");
             return  new ResponseEntity<>(status , HttpStatus.BAD_REQUEST);
         }
         interSkill.deleteSkill(id);
         StatusRuta status = new StatusRuta("skill eleminado");
         return new ResponseEntity<>(status , HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @GetMapping("/{id}") // buscona un skill por su id
     public ResponseEntity<Object> getSkillById(@PathVariable int id){
         SkillModel skill = interSkill.findSkill(id);
         if(skill == null){
             StatusRuta status = new StatusRuta("No se encontro ese skill");
             return new  ResponseEntity<>(status , HttpStatus.BAD_REQUEST);
         }
         return new ResponseEntity<>(skill , HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @PutMapping("/edit/{id}") // modifico un skill por su id
     public ResponseEntity<Object> editSkill( @PathVariable int id , @Valid  @RequestBody SkillDto skillDto, BindingResult bindingResult){
         SkillModel skill = interSkill.findSkill(id);
         if(skill == null){
             return new ResponseEntity<>(new StatusRuta("No se encontro ese skill para modificar") , HttpStatus.BAD_REQUEST);
         }
         if(bindingResult.hasErrors()){
            return new ResponseEntity(new StatusRuta("Campos mal puestos , titulo del skill vacio"),HttpStatus.BAD_REQUEST);
        }
         if(skillDto.getPercentage() <= 0 || skillDto.getPercentage() > 100 ){
             return new ResponseEntity<>(new StatusRuta("el porcentaje tiene que ser mayor a 0 y menor que 100"), HttpStatus.BAD_REQUEST );
         }
         skill.setName(skillDto.getName());
         skill.setPercentage(skillDto.getPercentage());
         skill.setColorName(skillDto.getColorName());
         skill.setColorpercentage(skillDto.getColorpercentage());
         skill.setColorCircle(skillDto.getColorCircle());
         interSkill.saveSkill(skill);
         return new ResponseEntity<>(skill , HttpStatus.OK);
     }
    
}
