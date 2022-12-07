/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//este dto lo voy utilizar el put(modificacion) de experiencie
package com.portafolio.apiPortafolio.Dto;
//
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edgar
 */

@Getter @Setter
public class ExperienceDto {
    private String title;
    private String companyName;
    private String dateStart;
    private String dateEnd;
    private String logoCompany;
    private String description;

    public ExperienceDto() {
    }

    public ExperienceDto(String title, String companyName, String dateStart, String dateEnd, String logoCompany, String description) {
        this.title = title;
        this.companyName = companyName;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.logoCompany = logoCompany;
        this.description = description;
    }

    
    
    
    
}
