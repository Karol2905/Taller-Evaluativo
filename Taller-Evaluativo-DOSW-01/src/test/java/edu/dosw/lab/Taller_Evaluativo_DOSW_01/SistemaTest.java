package edu.dosw.lab.Taller_Evaluativo_DOSW_01;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class SistemaTest {

    private Sistema sistema;

    @BeforeEach
    void setUp() {
        sistema = new Sistema(List.of(new AgenteAdvertencia(), new AgenteLog()));
        sistema.agregarProducto(new Producto(10, 2000, "Arroz", "Granos"));
    }

    @Test
    void testAgregarProducto() {
        assertEquals(1, sistema.getProductos().size());
        assertEquals("Arroz", sistema.getProductos().get(0).getNombre());
    }

    @Test
    void testComprarProducto() {
        sistema.comprarProducto("Arroz", 5);
        assertEquals(15, sistema.getProductos().get(0).getStock());
    }

    @Test
    void testVenderProducto() {
        sistema.venderProducto("Arroz", 3);
        assertEquals(7, sistema.getProductos().get(0).getStock());
    }

    @Test
    void testNotificacionCambio() {
        Producto arroz = sistema.getProductos().get(0);
        arroz.setStock(2);
        assertDoesNotThrow(() -> sistema.notificacionCambio(arroz));
    }
}
