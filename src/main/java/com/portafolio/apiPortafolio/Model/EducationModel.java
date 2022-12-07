/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.apiPortafolio.Model;
//
import javax.validation.constraints.NotBlank;
import javax.persistence.Entity;
import javax.persistence.Id ;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;// importo todo lo de persistence
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edgar
 */

@Getter @Setter // esto sirve para usar .get o el .set del model que cree
@Entity
@Table(name = "education") // es el nombre que le pongo a mi tabla
public class EducationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank // con esto le digo que este campo no puede estar en blanco
    private String institution;
    @NotBlank
    private String titleName;
    @NotBlank
    private String startDate;
    private String endDate;
    private String description;
    private String institutionLogo;
    private String certificateLink;
    
    @NotBlank
    private String userName;// esto me servir para saber quien fue el usurio que lo creo

    public EducationModel() {
    }

    public EducationModel(String institution, String titleName, String startDate, String endDate, String description, String certificateLink, String userName) {
        this.institution = institution;
        this.titleName = titleName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
        this.certificateLink = certificateLink;
        this.userName = userName;
    }
    
    
    
}