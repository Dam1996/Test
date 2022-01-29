package com.misionarg.Seguridad.jwtconfig;


import com.misionarg.Seguridad.Model.Usuario;
import com.misionarg.Seguridad.Service.ServiceUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private ServiceUsuario serviceUsuario;

    @Autowired
    RestTemplate restTemplate;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Usuario u = serviceUsuario.recuperarUsuario(username);
        if (u.equals(null)){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }else{
            return new User(u.getUsername(),u.getPassword(),new ArrayList<>());
        }

    }
}