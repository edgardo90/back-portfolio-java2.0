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
import com.portafolio.apiPortafolio.Model.Banner; //modelo crear el banner
import com.portafolio.apiPortafolio.Model.StatusRuta; //modelo que sirve para enviar un msg en formato json del estado de la ruta
import com.portafolio.apiPortafolio.Service.IBanner;
import com.portafolio.apiPortafolio.Dto.BannerDto; // dto para el put del banner
import org.springframework.security.access.prepost.PreAuthorize;
/**
 *
 * @author edgar
 */

@RestController // para emepezar hacer el ruteo
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE}) // configuro los corrs
public class BannerController {
    
    @Autowired
    private IBanner interBanner ;
    
    @GetMapping("/banner/all")
    public List<Banner> getBarrnes(){
        List<Banner> banners = interBanner.getBanners();
        return banners;
    }
    
    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @PostMapping("banner/create")
    public ResponseEntity<Object>  createBanner(@RequestBody Banner banner){
        interBanner.saveBanner(banner);
        return  new ResponseEntity<>(new StatusRuta("banner creado") , HttpStatus.OK );
    }
    
    @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
    @DeleteMapping("/banner/deleted/{id}") // elemino un banner
     public ResponseEntity<?> deletedBanner(@PathVariable int id){
         Banner banner = interBanner.findBanner(id);
         if(banner == null){
             StatusRuta status = new StatusRuta("No se encontro ese id del banner para eleminar");
             return  new ResponseEntity<>(status , HttpStatus.BAD_REQUEST);
         }
         interBanner.deleteBanner(id);
         StatusRuta status = new StatusRuta("Banner eleminado");
         return new ResponseEntity<>(status , HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @GetMapping("/banner/{id}") // buscona un banner por su id
     public ResponseEntity<Object> getBannerById(@PathVariable int id){
         Banner banner = interBanner.findBanner(id);
         if(banner == null){
             StatusRuta status = new StatusRuta("No se encontro ese banner");
             return new  ResponseEntity<>(status , HttpStatus.BAD_REQUEST);
         }
         return new ResponseEntity<>(banner , HttpStatus.OK);
     }
     
     @PreAuthorize("hasRole('ADMIN')") // con esto solo van poder ingresar esta ruta si esta logueado y tiene como rol "ADMIN"
     @PutMapping("/banner/edit/{id}")// modifico una persona por su id
     public ResponseEntity<Object> editBanner(@PathVariable int id , @RequestBody BannerDto bannerDto){
         Banner banner = interBanner.findBanner(id);
         if(banner == null){
             StatusRuta status = new StatusRuta("No se encontra ese banner para modificar");
             return  new ResponseEntity<>(status , HttpStatus.BAD_REQUEST);
         }
         if(bannerDto.getImagenLink().length() > 0){ // si viene algo del body en el "imagenLink" y es mayor a 0 
             banner.setImagenLink(bannerDto.getImagenLink());  // que modifique lo que hay en banner.imagenLink
         }
         interBanner.saveBanner(banner);
         return new ResponseEntity<>(banner , HttpStatus.OK);
     }
    
}
