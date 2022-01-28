package com.misionarg.Seguridad.Repository;

import com.misionarg.Seguridad.Model.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    @Query("select u from Usuario u where u.username = :username")
    Usuario recuperarusuario(String username);
}
