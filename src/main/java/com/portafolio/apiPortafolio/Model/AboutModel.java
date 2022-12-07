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
import javax.persistence.*;// importo todo lo de persistence
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edgar
 */

@Getter @Setter // esto sirve para usar .get o el .set del model que cree
@Entity
@Table(name = "about") // es el nombre que le pongo a mi tabla
public class AboutModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String title;
    private String summary;
    private String userName;// esto me servir para saber quien fue el usurio que lo creo
}
