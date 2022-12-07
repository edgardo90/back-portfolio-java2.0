/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.portafolio.apiPortafolio.Service;
//
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired ;//
import java.util.List;
//traigo lo que cree
import com.portafolio.apiPortafolio.Repository.BannerRepository; // traigo mi repository que cree
import com.portafolio.apiPortafolio.Model.Banner; // importo el modelo que cree 

/**
 *
 * @author edgar
 */

@Service
public class BannerService implements IBanner{
    
    @Autowired
    private BannerRepository bannerRepository;
    

    @Override
    public List<Banner> getBanners() { // traigo todos los banner
        List<Banner> banners = bannerRepository.findAll();
        return banners;
    }

    @Override
    public void saveBanner(Banner banner) { // guarda el banner en la base de datos
        bannerRepository.save(banner);
    }

    @Override
    public void deleteBanner(int id) { // elemino el banner por su id en la base de datos
        bannerRepository.deleteById(id);
    }

    @Override
    public Banner findBanner(int id) { // busca el banner por su id
        Banner banner = bannerRepository.findById(id).orElse(null);
        return banner;
    }
    
}
