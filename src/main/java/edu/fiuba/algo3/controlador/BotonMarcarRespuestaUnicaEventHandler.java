package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Valor;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonMarcarRespuestaUnicaEventHandler extends BotonMarcarEventHandler {


    public BotonMarcarRespuestaUnicaEventHandler(Respuesta respuesta, Opcion opcion, Button botonEnviar){
        super(respuesta, opcion, botonEnviar);

    }
    @Override
    public void handle(Event event) {

        if (respuesta.fueMarcada(opcion)) {
            respuesta.desmarcar(opcion);
        }

        else {
            respuesta.marcar(opcion, new Valor(true)); // En este caso sirve para un VoF
        }

        actualizarBotonEnviar();

    }
}
