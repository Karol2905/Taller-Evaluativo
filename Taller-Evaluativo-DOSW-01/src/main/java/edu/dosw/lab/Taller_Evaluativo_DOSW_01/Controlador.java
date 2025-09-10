package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class Controlador {

    private final Sistema sistema;

    public Controlador(Sistema sistema) {
        this.sistema = sistema;
    }

    @GetMapping
    public ArrayList<Producto> obtenerProductos() {
        return sistema.getProductos();
    }

    @PostMapping
    public String agregarProducto(@RequestBody Producto producto) {
        sistema.agregarProducto(producto);
        return "Producto agregado: " + producto.getNombre();
    }

    @PutMapping("/{nombre}/comprar/{cantidadComprada}")
    public String comprarProducto(@PathVariable String nombre, @PathVariable int cantidadComprada) {
        sistema.comprarProducto(nombre, cantidadComprada);
        return "Se compraron " + cantidadComprada + " unidades de " + nombre;
    }

    @PutMapping("/{nombre}/vender/{cantidadVendida}")
    public String venderProducto(@PathVariable String nombre, @PathVariable int cantidadVendida) {
        sistema.venderProducto(nombre, cantidadVendida);
        return "Se vendieron " + cantidadVendida + " unidades de " + nombre;
    }
}
