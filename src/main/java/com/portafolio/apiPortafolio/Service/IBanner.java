/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.apiPortafolio.Service;
//
import java.util.List;
import com.portafolio.apiPortafolio.Model.Banner;

/**
 *
 * @author edgar
 */
public interface IBanner {
    
    public List<Banner> getBanners(); //  trae todas los Banner
    
    public void saveBanner(Banner banner); // guardo el baner en la base de datos
    
    public void deleteBanner(int id); // borro la banner
    
    public Banner findBanner(int id); // busco el banner por su id
}
