/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//este dto lo voy utilizar el put(modificacion) de proyect
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
public class ProjectDto {
    
    @NotBlank
    private String title;
    @NotBlank
    private String image;
    @NotBlank
    private String description;
    private String linkFront;
    private String linkBack;
    private String linkProject;

    public ProjectDto() {
    }

    public ProjectDto(String title, String image, String description, String linkFront, String linkBack, String linkProject) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.linkFront = linkFront;
        this.linkBack = linkBack;
        this.linkProject = linkProject;
    }

    
}
