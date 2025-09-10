package edu.dosw.lab.Taller_Evaluativo_DOSW_01;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Controlador {
    private final Sistema sistema;
    private final AgenteLog agenteLog;
    private final AgenteAdvertencia agenteAdvertencia;
    @PostConstruct
    public void nose(){
        sistema.subscribir(agenteLog);
        sistema.subscribir(agenteAdvertencia);
    }
}
