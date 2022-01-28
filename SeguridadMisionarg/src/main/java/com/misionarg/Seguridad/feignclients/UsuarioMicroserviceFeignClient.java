package com.misionarg.Seguridad.feignclients;

import com.misionarg.Seguridad.Model.UsuarioMicroservice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service", url = "http://localhost:8001")
@RequestMapping("/user")
public interface UsuarioMicroserviceFeignClient {

    @PostMapping()
    UsuarioMicroservice save(@RequestBody UsuarioMicroservice usuarioMicroservice);

    @GetMapping
    List<UsuarioMicroservice> getUsuariosMicroservice();
}
