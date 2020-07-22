package edu.fiuba.algo3.modelo.Respuesta;

public class RespuestaMultiple extends TipoRespuesta{

    public RespuestaMultiple() {}

    public RespuestaMultiple(String[] opcion_) {
        this.opcion = opcion_;
    }

    public Boolean[] esCorrecta(TipoRespuesta respuestaMultiple) {
        Boolean[] returnValue = new Boolean[this.opcion.length];
        for (int i = 0; i < this.opcion.length; i++) {
            returnValue[i] = this.opcion[i].equals(respuestaMultiple.getOpcion()[i]);
        }
        return returnValue;
    }
}
