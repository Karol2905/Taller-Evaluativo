package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@NoArgsConstructor
public class Sistema {
    private ArrayList<Producto> productos;
    private ArrayList<Observador> observadores;

    public void agregarProducto(String nombreProducto,String categoriaProducto, int cantidadStock, int precio){
        productos.add(new Producto(cantidadStock,precio,nombreProducto,categoriaProducto));
    }

}
