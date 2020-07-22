package edu.fiuba.algo3.modelo.Respuesta;

public class RespuestaSimple extends TipoRespuesta{

    public RespuestaSimple() {}

    public RespuestaSimple(String[] opcion_) {
        this.opcion = opcion_;
    }

    public Boolean[] esCorrecta(TipoRespuesta respuestaSimple) {
        return new Boolean[] {respuestaSimple.getOpcion()[0].equals(this.opcion[0])};
    }

}
