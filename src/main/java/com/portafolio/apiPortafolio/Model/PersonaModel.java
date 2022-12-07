/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.apiPortafolio.Model;
//
import javax.persistence.Entity;
import javax.persistence.Id ;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edgar
 */
@Getter @Setter // esto sirve para usar .get o el .set del model que cree
@Entity
public class PersonaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private String surname;
    private String imagen;
    private String phone;
    private String email;
    private String country;
    private String userName; // esto me servir para saber que usurio lo creo

    public PersonaModel() {
    }

    public PersonaModel(String name, String surname, String imagen, String phone, String email, String userName , String country) {
        this.name = name;
        this.surname = surname;
        this.imagen = imagen;
        this.phone = phone;
        this.email = email;
        this.userName = userName;
        this.country = country;
    }
    
    
    
}
