package edu.fiuba.algo3.modelo.Respuesta;


public class Respuesta {

    private TipoRespuesta respuesta;

    public Respuesta() {}

    public Respuesta(TipoRespuesta respuesta_) {
        this.respuesta = respuesta_;
    }

    public Boolean[] esCorrecta(Respuesta respuesta) {
        return this.respuesta.esCorrecta(respuesta.respuesta);
    }

    public String[] getOpcion() {
        return respuesta.getOpcion();
    }
    /*FIXME*/
    /*
    * Hacer un Factory?
    **/
    public static Respuesta crearRespuestaSimple(String[] opcion) {
        return new Respuesta(new RespuestaSimple(opcion));
    }
    public static Respuesta crearRespuestaMultiple (String[] opciones) {
        return new Respuesta(new RespuestaMultiple(opciones));
    }
    public static Respuesta crearRespuestaGrupal(String[] opciones) {
        return new Respuesta(new RespuestaGrupal(opciones));
    }

}
