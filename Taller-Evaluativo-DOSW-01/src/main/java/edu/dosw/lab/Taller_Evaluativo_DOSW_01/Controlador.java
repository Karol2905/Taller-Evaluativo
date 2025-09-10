package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import java.util.ArrayList;
import java.util.List;

import edu.dosw.lab.Taller_Evaluativo_DOSW_01.Producto;
import edu.dosw.lab.Taller_Evaluativo_DOSW_01.Sistema;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class Controlador {

    private final Sistema stockManager;

    public Controlador(Sistema stockManager) {
        this.stockManager = stockManager;
    }

    @GetMapping
    public ArrayList<Producto> obtenerProductos() {
        return stockManager.getProductos();
    }

    @PostMapping
    public String agregarProducto(@RequestBody Producto producto) {
        stockManager.agregarProducto(producto);
        return "Producto agregado: " + producto.getNombre();
    }

    @PutMapping("/{nombre}/comprar/{cantidadComprada}")
    public String comprarProducto(@PathVariable String nombre, @PathVariable int cantidadComprada) {
        stockManager.comprarProducto(nombre, cantidadComprada);
        return "Se compraron " + cantidadComprada + " unidades de " + nombre;
    }

    @PutMapping("/{nombre}/vender/{cantidadVendida}")
    public String venderProducto(@PathVariable String nombre, @PathVariable int cantidadVendida) {
        stockManager.venderProducto(nombre, cantidadVendida);
        return "Se vendieron " + cantidadVendida + " unidades de " + nombre;
    }
}
