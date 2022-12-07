/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//este dto lo voy utilizar el put(modificacion) de about
package com.portafolio.apiPortafolio.Dto;
//
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edgar
 */

@Getter @Setter
public class AboutDto {
    private String title;
    private String summary;

    public AboutDto() {
    }

    public AboutDto(String title, String summary) {
        this.title = title;
        this.summary = summary;
    }
    
    
    
}
