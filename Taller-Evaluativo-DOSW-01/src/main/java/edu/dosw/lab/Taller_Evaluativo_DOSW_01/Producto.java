package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto {
    private int stock;
    private int precio;
    private String nombre;
    private String categoria;
}
