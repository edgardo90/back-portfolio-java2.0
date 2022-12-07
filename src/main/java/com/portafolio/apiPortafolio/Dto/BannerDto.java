/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.apiPortafolio.Dto;
//
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edgar
 */

@Getter @Setter
public class BannerDto {
    private String imagenLink;

    public BannerDto() {
    }

    public BannerDto(String imagenLink) {
        this.imagenLink = imagenLink;
    }
    
    
}
