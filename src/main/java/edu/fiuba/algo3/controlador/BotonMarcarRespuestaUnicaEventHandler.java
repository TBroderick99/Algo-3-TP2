package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Valor;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.event.Event;
import javafx.event.EventHandler;

public class BotonMarcarRespuestaUnicaEventHandler implements EventHandler {
    Partida partida;
    Respuesta respuesta;
    Opcion opcion;

    public BotonMarcarRespuestaUnicaEventHandler(Respuesta respuesta, Opcion opcion){
        this.respuesta = respuesta;
        this.opcion = opcion;
    }
    @Override
    public void handle(Event event) {
        respuesta.marcar(opcion, new Valor(true)); // En este caso sirve para un VoF
    }
}
