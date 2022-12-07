/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//esto es una interface
package com.portafolio.apiPortafolio.Repository;
//
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//importo lo que cree
import com.portafolio.apiPortafolio.Model.SkillModel;

/**
 *
 * @author edgar
 */

@Repository //mapeamos como repositorio
//la interface  extiende  de JpaRepository(que maneja repositorio JPA)
//en los parametros "<>" deben ir: <clase a persistir , tipo de dato de su ID>
public interface SkilllRepository extends  JpaRepository<SkillModel, Integer>{
    
}
