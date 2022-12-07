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
@Table(name = "project") // es el nombre que le pongo a mi tabla
public class ProjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String title;
    @NotBlank
    private String image;
    @NotBlank
    private String description;
    private String linkFront;
    private String linkBack;
    private String linkProject;
    private String userName;// esto me servir para saber quien fue el usurio que lo creo

    public ProjectModel() {
    }

    public ProjectModel(String title, String image, String description, String linkFront, String linkBack) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.linkFront = linkFront;
        this.linkBack = linkBack;
    }
    
    
}
