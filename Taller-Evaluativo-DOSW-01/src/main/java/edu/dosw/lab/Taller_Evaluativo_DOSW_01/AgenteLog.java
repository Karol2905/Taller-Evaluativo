package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import org.springframework.stereotype.Component;

/**
 * Clase que implementa el observador para registrar cambios en los productos.
 *
 * Cada vez que un producto cambia (compra o venta), este agente imprime
 * un mensaje en la consola con el nombre del producto y su nuevo stock.
 */

@Component
public class AgenteLog implements Observador{
    /**
     * Método que recibe la notificación de un cambio en el producto
     * y lo muestra en la consola.
     *
     * @param product el producto que cambió
     */
    @Override
    public void informe(Producto product){
        System.out.println("Producto "+product.getNombre()+" --> "+product.getStock());
    }

}
