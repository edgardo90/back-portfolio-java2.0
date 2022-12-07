/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//dto para el post de crear usuario
package com.portafolio.apiPortafolio.Security.Dto;
//
import javax.validation.constraints.NotBlank; 
import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edgar
 */
@Getter @Setter
public class NewUserDto {
    
    @NotBlank
    private String name;
    @NotBlank
    private String userName;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();
    
}
