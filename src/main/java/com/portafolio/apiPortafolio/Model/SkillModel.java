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
@Table(name = "skill") // es el nombre que le pongo a mi tabla
public class SkillModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String name;
    private int percentage;
    private String colorName;
    private String colorpercentage;
    private String colorCircle;
    
    @NotBlank
    private String userName;// esto me servir para saber quien fue el usurio que lo creo

    public SkillModel() {
    }

    public SkillModel(String name, int percentage, String colorpercentage, String colorCircle) {
        this.name = name;
        this.percentage = percentage;
        this.colorpercentage = colorpercentage;
        this.colorCircle = colorCircle;
    }

    
    
}
