/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//este dto lo voy utilizar el put(modificacion) de Education
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
public class EducationDto {
    @NotBlank
    private String institution;
    @NotBlank
    private String titleName;
    @NotBlank
    private String startDate;
    private String endDate;
    private String description;
    private String institutionLogo;
    private String certificateLink;

    public EducationDto() {
    }

    public EducationDto(String institution, String titleName, String startDate, String endDate, String description, String certificateLink) {
        this.institution = institution;
        this.titleName = titleName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.certificateLink = certificateLink;
    }
    
    
}
