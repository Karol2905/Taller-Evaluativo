package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class ControladorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testAgregarProducto() throws Exception {
        String json = """
            {"stock":5,"precio":2000,"nombre":"Huevos","categoria":"Granja"}
        """;

        mockMvc.perform(post("/productos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().string("Producto agregado: Huevos"));
    }

    @Test
    void testComprarProducto() throws Exception {
        testAgregarProducto(); // primero agregamos

        mockMvc.perform(put("/productos/Huevos/comprar/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("Se compraron 3 unidades de Huevos"));
    }

    @Test
    void testVenderProducto() throws Exception {
        testAgregarProducto(); // primero agregamos

        mockMvc.perform(put("/productos/Huevos/vender/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("Se vendieron 2 unidades de Huevos"));
    }
}
