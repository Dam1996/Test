package com.misionarg.Seguridad.Service;

import com.misionarg.Seguridad.Model.Usuario;
import com.misionarg.Seguridad.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceUsuario {

@Autowired
private UsuarioRepository usuarioRepository;



public  Usuario recuperarUsuario(String username){
    return usuarioRepository.recuperarusuario(username);
}


}
