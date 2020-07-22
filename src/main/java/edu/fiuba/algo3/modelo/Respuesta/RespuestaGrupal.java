package edu.fiuba.algo3.modelo.Respuesta;

import java.util.Arrays;

public class RespuestaGrupal extends TipoRespuesta{
    private String[] grupoA;
    private String[] grupoB;

    public RespuestaGrupal() {}

    public RespuestaGrupal(String[] opciones_) {
        this.opcion = opciones_;
        this.grupoA = this.parsearGrupoA(opciones_);
        this.grupoB = this.parsearGrupoB(opciones_);
    }

    private String[] parsearGrupoA(String[] grupos) {
        /*
        * Se considera que los grupos son del mismo tamaño.
        * */
        return Arrays.copyOfRange(grupos, 0, grupos.length/2);
    }

    private String[] parsearGrupoB(String[] grupos) {
        /*
         * Se considera que los grupos son del mismo tamaño.
         * */
        return Arrays.copyOfRange(grupos, grupos.length/2, grupos.length);
    }

    public Boolean[] esCorrecta(TipoRespuesta respuestaGrupal) {
        Boolean[] returnValue = new Boolean[2];
        returnValue[0] = Arrays.equals(this.grupoA, this.parsearGrupoA(respuestaGrupal.getOpcion()));
        returnValue[1] = Arrays.equals(this.grupoB, this.parsearGrupoB(respuestaGrupal.getOpcion()));
        return returnValue;
    }
}
