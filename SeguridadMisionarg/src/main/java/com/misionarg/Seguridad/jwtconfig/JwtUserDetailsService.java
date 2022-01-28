package com.misionarg.Seguridad.jwtconfig;


import com.misionarg.Seguridad.Model.Usuario;
import com.misionarg.Seguridad.Model.UsuarioMicroservice;
import com.misionarg.Seguridad.Service.ServiceUsuario;
import com.misionarg.Seguridad.feignclients.UsuarioMicroserviceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private ServiceUsuario serviceUsuario;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    UsuarioMicroserviceFeignClient usuarioMicroserviceFeignClient;

    @RequestMapping(method = RequestMethod.GET, value ="/user")
    public List<UsuarioMicroservice> getUsuariosMicroservice() {
        List<UsuarioMicroservice> usuarioMicroservice = restTemplate.getForObject("http://user-service/user", List.class);
        return usuarioMicroservice;
    }

    @RequestMapping(method = RequestMethod.POST, value ="/user")
    public UsuarioMicroservice saveUsuarioMicroservice(UsuarioMicroservice usuarioMicroservice) {
        UsuarioMicroservice usuarioMicroserviceNew = usuarioMicroserviceFeignClient.save(usuarioMicroservice);
        return usuarioMicroserviceNew;
    }


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