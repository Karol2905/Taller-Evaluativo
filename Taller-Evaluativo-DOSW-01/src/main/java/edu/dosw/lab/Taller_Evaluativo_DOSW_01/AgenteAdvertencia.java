package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

public class AgenteAdvertencia implements Observador{
    @Override
    public void informe(Producto producto) {
        if(producto.getStock()<5){
            System.out.println("ALERTA!! El stock del producto: "+producto.getNombre()+" es muy bajo,solo quedan "+producto.getStock()+" unidades");
        }
    }
}
