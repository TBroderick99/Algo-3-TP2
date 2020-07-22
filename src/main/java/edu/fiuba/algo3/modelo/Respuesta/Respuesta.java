package edu.fiuba.algo3.modelo.Respuesta;


public class Respuesta {

    /*
    * Consideraciones de I/O:
    * Las respuestas reciben un único parametro de tipo String[], y devuelven Boolean[].
    * Las respuestas grupales reciben grupoA y grupoB concatenados, luego se parsean internamente.
    * Se pone como presuposicion que ambos grupos tienen el mismo tamaño.
    *
    * */

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
