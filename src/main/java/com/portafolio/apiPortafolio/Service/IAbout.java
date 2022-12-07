/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.apiPortafolio.Service;
//
import java.util.List;
import com.portafolio.apiPortafolio.Model.AboutModel;

/**
 *
 * @author edgar
 */
public interface IAbout {
    
    public List<AboutModel> getAbout(); //  trae todos los About("acerca de")
    
    public void saveAbout(AboutModel about); // guardo el about en la base de datos
    
    public void deleteAbout(int id); // borro el about por su id
    
    public AboutModel findAbout(int id); // busco el about por su id
    
}
