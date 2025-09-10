package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
/**
 * Clase principal que maneja la lógica del sistema de productos.
 *
 * Se encarga de:
 * - Guardar los productos registrados
 * - Vender y comprar productos (actualizar el stock)
 * - Notificar a los observadores cuando cambia un producto
 */
@Getter
@Service

public class Sistema {
    /** Lista de productos del sistema */
    private ArrayList<Producto> productos;

    /** Observadores que reciben notificaciones cuando cambia un producto */
    private ArrayList<Observador> observadores;
    public Sistema(java.util.List<Observador> observadores){
        productos = new ArrayList<>();
        this.observadores = new ArrayList<>(observadores);
    }

    /** Agrega un producto nuevo al sistema */
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    /** Vende cierta cantidad de un producto y actualiza su stock */
    public void venderProducto(String nombre,int cantidadVendida){
        for (Producto producto : productos){
            if(producto.getNombre().equals(nombre)){
                int cantidad=producto.getStock()-cantidadVendida;
                producto.setStock(cantidad);
                notificacionCambio(producto);
            }
        }
    }

    /** Compra cierta cantidad de un producto y actualiza su stock */
    public void comprarProducto(String nombre,int cantidadComprada){
        for (Producto producto : productos){
            if(producto.getNombre().equals(nombre)){
                int cantidad=producto.getStock()+cantidadComprada;
                producto.setStock(cantidad);
                notificacionCambio(producto);
            }
        }
    }

    /** Notifica a todos los observadores sobre cambios en un producto */
    public void notificacionCambio(Producto producto){
        for (Observador observador : observadores){
            observador.informe(producto);
        }
    }


}
