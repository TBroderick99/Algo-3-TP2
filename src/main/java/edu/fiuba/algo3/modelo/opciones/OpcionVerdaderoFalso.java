package edu.fiuba.algo3.modelo.opciones;

public class OpcionVerdaderoFalso extends Opcion{

    private Boolean esCorrecta;

    public OpcionVerdaderoFalso(String textoOpcion, Boolean esCorrecta) {
        super(textoOpcion);
        this.esCorrecta = esCorrecta;
    }

    public Boolean esCorrecta(){
        return this.esCorrecta;
    }



}
