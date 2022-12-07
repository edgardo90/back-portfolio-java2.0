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
import com.portafolio.apiPortafolio.Repository.AboutRepository;
import com.portafolio.apiPortafolio.Model.AboutModel;

/**
 *
 * @author edgar
 */

@Service
public class AboutService implements IAbout{
    
    @Autowired
    private  AboutRepository aboutRepository;

    @Override
    public List<AboutModel> getAbout() { // traigo todos los about
        List<AboutModel> abouts = aboutRepository.findAll();
        return abouts;
    }

    @Override
    public void saveAbout(AboutModel about) { // guardo el about en la base de datos
        aboutRepository.save(about);
    }

    @Override
    public void deleteAbout(int id) { // elemino el about por su id
        aboutRepository.deleteById(id);
    }

    @Override
    public AboutModel findAbout(int id) { // busca el about por su id
        AboutModel about = aboutRepository.findById(id).orElse(null);
        return about;
    }
    
}
