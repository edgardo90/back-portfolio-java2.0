/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.apiPortafolio.Model;
//
import lombok.Getter; // esto lo importo
import lombok.Setter; // esto lo importo

/**
 *
 * @author edgar
 */

@Getter @Setter
public class StatusRuta {
    
    private String msg;

    public StatusRuta() {
    }

    public StatusRuta(String msg) {
        this.msg = msg;
    }
    
    
    
}
