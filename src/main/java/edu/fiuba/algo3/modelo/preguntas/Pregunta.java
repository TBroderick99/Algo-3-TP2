package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Respuesta.TipoRespuesta;

/*TO DO: hacer abstracto, sacar constructor*/
public class Pregunta{

    private String textoPregunta;
    private String[] opciones;
    private ModoDePuntaje modoDePuntaje;
    private TipoRespuesta respuestaCorrecta;

   /**/
    public Pregunta(String textoPregunta, String[] opciones , TipoRespuesta respuestaCorrecta){
        this.textoPregunta = textoPregunta;
        this.opciones = opciones;
        this.respuestaCorrecta = respuestaCorrecta;
        this.modoDePuntaje = new PuntajeClasico();

    }

    public String getTextoPregunta(){
        return textoPregunta;
    }


    public String[] getOpciones(){
        return opciones;
    }


    public TipoRespuesta getRespuestaCorrecta(){
        return respuestaCorrecta;
    }


    public void asignarPuntajes(TipoRespuesta[] respuestasUsuarios, Jugador[] jugadores){

        for (int i = 0; i < respuestasUsuarios.length; i++){
            _asignarPuntaje(respuestasUsuarios[i], jugadores[i]);
        }
    }

    private void _asignarPuntaje(TipoRespuesta respuestaUsuario, Jugador unJugador){
        Boolean[] aciertos = respuestaUsuario.esCorrecta(respuestaCorrecta);
        modoDePuntaje.asignarPuntaje(aciertos, unJugador);
    }

}