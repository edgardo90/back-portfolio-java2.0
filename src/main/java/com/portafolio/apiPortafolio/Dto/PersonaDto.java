/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//este dto lo voy utilizar el put(modificacion) de persona
package com.portafolio.apiPortafolio.Dto;
//
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edgar
 */

@Getter @Setter
public class PersonaDto {
    private String name;
    private String surname;
    private String imagen;
    private String phone;
    private String email;
    private String country;

    public PersonaDto() {
    }

    public PersonaDto(String name, String surname, String imagen, String phone, String email) {
        this.name = name;
        this.surname = surname;
        this.imagen = imagen;
        this.phone = phone;
        this.email = email;
    }
    
    
    
}
