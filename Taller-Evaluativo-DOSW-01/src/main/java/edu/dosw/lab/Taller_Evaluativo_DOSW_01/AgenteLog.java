package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import org.springframework.stereotype.Component;

@Component
public class AgenteLog implements Observador{
    @Override
    public void informe(Producto product){
        System.out.println("Producto"+product.getNombre()+"->"+product.getStock());
    }

}
