package com.misionarg.Seguridad.Model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "userrol")
@Access(AccessType.FIELD)
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "rol")
    private String rol;

    @Column(name = "tiposistema")
    private String modulo;

    /*@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idmodulo")
    private List<Modulo> rolmodulos;



    public List<Modulo> getRolmodulos() {
        return rolmodulos;
    }

    public void setRolmodulos(List<Modulo> rolmodulos) {
        this.rolmodulos = rolmodulos;
    }*/


    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
