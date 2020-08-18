package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Valor;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonMarcarRespuestaOrdenadaEventHandler  extends BotonMarcarEventHandler {


    public BotonMarcarRespuestaOrdenadaEventHandler(Respuesta respuesta, Opcion opcion, Button botonEnviar){
        super(respuesta, opcion, botonEnviar);

    }

    @Override
    public void handle(Event event) {

        if (respuesta.fueMarcada(opcion)) {
            respuesta.desmarcar(opcion);
        }

        else { respuesta.marcar(opcion, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        }

        actualizarBotonEnviar();
    }
}
