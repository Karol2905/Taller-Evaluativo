package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/**
 * Clase que representa un producto en el sistema.
 * Contiene información básica como:
 * - stock (cantidad disponible)
 * - precio
 * - nombre
 * - categoría
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Producto {
    /** Cantidad disponible del producto */
    private int stock;
    /**
     * Precio unitario del producto.
     */
    private int precio;
    /**
     * Nombre del producto.
     */
    private String nombre;
    /**
     * Categoría a la que pertenece el producto.
     */
    private String categoria;
}
