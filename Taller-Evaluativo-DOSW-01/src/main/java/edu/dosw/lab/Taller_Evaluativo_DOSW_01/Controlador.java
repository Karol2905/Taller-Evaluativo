package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.*;

@RestController
@RequestMapping("/productos")
public class Controlador{

    private final Sistema stockManager;

    public ProductoController(Sistema stockManager) {
        this.stockManager = stockManager;
    }

    @PostMapping
    public String agregarProducto(@RequestBody Producto producto) {
        stockManager.agregarProducto(producto);
        return "Producto agregado: " + producto.getNombre();
    }

    @PutMapping("/{nombre}/stock/{nuevoStock}")
    public String actualizarStock(@PathVariable String nombre, @PathVariable int nuevoStock) {
        stockManager.actualizarStock(nombre, nuevoStock);
        return "Stock actualizado para: " + nombre;
    }
}
