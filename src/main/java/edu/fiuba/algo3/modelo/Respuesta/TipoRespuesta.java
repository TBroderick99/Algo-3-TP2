package edu.fiuba.algo3.modelo.Respuesta;

public abstract class TipoRespuesta {

    protected String[] opcion;

    public abstract Boolean[] esCorrecta(TipoRespuesta respuesta);

    public String[] getOpcion() {
        return this.opcion;
    }
}
