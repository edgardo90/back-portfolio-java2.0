/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//este dto lo voy utilizar el put(modificacion) de skill
package com.portafolio.apiPortafolio.Dto;
//
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author edgar
 */

@Getter @Setter
public class SkillDto {
    
    @NotBlank
    private String name;
    private int percentage;
    private String colorName;
    private String colorpercentage;
    private String colorCircle;
    

    public SkillDto() {
    }

    public SkillDto(String name, String colorName, String colorpercentage, String colorCircle) {
        this.name = name;
        this.colorName = colorName;
        this.colorpercentage = colorpercentage;
        this.colorCircle = colorCircle;
    }

    
    
    
}
