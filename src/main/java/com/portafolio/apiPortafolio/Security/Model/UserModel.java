/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//este es mi modelo que se va crear la tabla en la base de datos
package com.portafolio.apiPortafolio.Security.Model;
//
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.persistence.*;// importo todo lo de persistence
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author edgar
 */
@Getter @Setter // esto sirve para usar .get o el .set del model que cree
@Entity
@Table(name = "user") // es el nombre que le pongo a mi tabla
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @NotNull
    @Column(unique = true)
    private String userName;
    @NotNull
    private String email;
    @NotNull
    private String password;
    
    //esto es una prueba de relacion con la tabla RolModel
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name ="usuario_id"), inverseJoinColumns = @JoinColumn(name = "rol_id")) // aca hice la tabla de relacion con roles
    private Set<RolModel> roles = new HashSet<>();

    public UserModel() {
    }

    public UserModel(String name, String userName, String email, String password) {
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }
    
    public Set<RolModel> getRoles() {
        return roles;
    }

    public void setRoles(Set<RolModel> roles) {
        this.roles = roles;
    }
    
}
