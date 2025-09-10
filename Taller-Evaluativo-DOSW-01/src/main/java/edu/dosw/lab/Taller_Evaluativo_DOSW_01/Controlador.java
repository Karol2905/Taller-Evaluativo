package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

/**
 * Controlador REST para manejar las operaciones de productos.
 *
 * Expone endpoints para:
 * - Ver la lista de productos
 * - Agregar un producto
 * - Comprar (aumentar stock)
 * - Vender (disminuir stock)
 */
@RestController
@RequestMapping("/productos")
public class Controlador {

    /** Lógica del sistema que maneja los productos */
    private final Sistema sistema;

    /** Constructor que recibe la lógica del sistema */
    public Controlador(Sistema sistema) {
        this.sistema = sistema;
    }

    /**
     * Devuelve la lista de todos los productos registrados.
     * @return lista de productos
     */
    @GetMapping
    public ArrayList<Producto> obtenerProductos() {
        return sistema.getProductos();
    }

    /**
     * Agrega un producto nuevo al sistema.
     * @param producto producto recibido en formato JSON
     * @return mensaje de confirmación
     */
    @PostMapping
    public String agregarProducto(@RequestBody Producto producto) {
        sistema.agregarProducto(producto);
        return "Producto agregado: " + producto.getNombre();
    }

    /**
     * Aumenta el stock de un producto (compra).
     * @param nombre nombre del producto
     * @param cantidadComprada cantidad a comprar
     * @return mensaje de confirmación
     */

    @PutMapping("/{nombre}/comprar/{cantidadComprada}")
    public String comprarProducto(@PathVariable String nombre, @PathVariable int cantidadComprada) {
        sistema.comprarProducto(nombre, cantidadComprada);
        return "Se compraron " + cantidadComprada + " unidades de " + nombre;
    }

    /**
     * Disminuye el stock de un producto (venta).
     * @param nombre nombre del producto
     * @param cantidadVendida cantidad a vender
     * @return mensaje de confirmación
     */

    @PutMapping("/{nombre}/vender/{cantidadVendida}")
    public String venderProducto(@PathVariable String nombre, @PathVariable int cantidadVendida) {
        sistema.venderProducto(nombre, cantidadVendida);
        return "Se vendieron " + cantidadVendida + " unidades de " + nombre;
    }
}
