package edu.fiuba.algo3.modelo.selecciones;

import edu.fiuba.algo3.modelo.opciones.OpcionVerdaderoFalso;

public class SeleccionVerdaderoFalso {
    private OpcionVerdaderoFalso opcion;
    private Boolean fueMarcada;

    public SeleccionVerdaderoFalso(OpcionVerdaderoFalso opcion){
        this.opcion = opcion;
        fueMarcada = false;

    }

    public Boolean esCorrecta(){
        return opcion.esCorrecta();
    }

    public void seleccionar(){
        fueMarcada = !fueMarcada;
    }

    public Boolean fueMarcada(){
        return fueMarcada;
    }
}
