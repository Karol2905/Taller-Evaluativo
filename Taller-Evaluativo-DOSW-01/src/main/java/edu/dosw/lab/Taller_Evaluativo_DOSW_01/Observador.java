package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

/**
 * Interfaz que representa a un observador del sistema.
 *
 * Los observadores reciben notificaciones cuando ocurre
 * un cambio en algún producto (por ejemplo, cambio en el stock).
 */
public interface Observador {
    /**
     * Método que recibe la notificación de un cambio en un producto.
     *
     * @param producto el producto que cambió
     */
    void informe(Producto producto);
}
