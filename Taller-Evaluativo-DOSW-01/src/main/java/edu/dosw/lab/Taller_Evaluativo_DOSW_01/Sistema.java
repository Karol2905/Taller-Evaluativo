package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Getter
@Service

public class Sistema {
    private ArrayList<Producto> productos;
    private ArrayList<Observador> observadores;
    public Sistema(java.util.List<Observador> observadores){
        productos = new ArrayList<>();
        this.observadores = new ArrayList<>(observadores);
    }
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }
    public void venderProducto(String nombre,int cantidadVendida){
        for (Producto producto : productos){
            if(producto.getNombre().equals(nombre)){
                int cantidad=producto.getStock()-cantidadVendida;
                producto.setStock(cantidad);
                notificacionCambio(producto);
            }
        }
    }
    public void comprarProducto(String nombre,int cantidadComprada){
        for (Producto producto : productos){
            if(producto.getNombre().equals(nombre)){
                int cantidad=producto.getStock()+cantidadComprada;
                producto.setStock(cantidad);
                notificacionCambio(producto);
            }
        }
    }
    public void notificacionCambio(Producto producto){
        for (Observador observador : observadores){
            observador.informe(producto);
        }
    }


}
