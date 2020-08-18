package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Valor;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.event.Event;
import javafx.event.EventHandler;

public class BotonMarcarRespuestaOrdenadaEventHandler  implements EventHandler {

    Respuesta respuesta;
    Opcion opcion;

    public BotonMarcarRespuestaOrdenadaEventHandler(Respuesta respuesta, Opcion opcion){
        this.respuesta = respuesta;
        this.opcion = opcion;
    }

    @Override
    public void handle(Event event) {

        if (respuesta.fueMarcada(opcion)) {
            respuesta.desmarcar(opcion);
        }

        else { respuesta.marcar(opcion, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        }


    }
}
