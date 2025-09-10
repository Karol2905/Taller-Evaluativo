package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import org.springframework.stereotype.Component;

/**
 * Observador que se encarga de generar alertas cuando
 * el stock de un producto es bajo.
 *
 * Si el stock de un producto es menor a 5 unidades,
 * se muestra un mensaje de advertencia en la consola.
 */
@Component
public class AgenteAdvertencia implements Observador{
    /**
     * Revisa el stock del producto y genera una alerta si es muy bajo.
     *
     * @param producto el producto que cambió
     */
    @Override
    public void informe(Producto producto) {
        if(producto.getStock()<5){
            System.out.println("ALERTA!! El stock del producto: "+producto.getNombre()+" es muy bajo, solo quedan "+producto.getStock()+" unidades");
        }
    }
}
