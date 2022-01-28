package com.misionarg.Seguridad.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioMicroservice {
    private int id;
    private String name;
    private String email;
}
