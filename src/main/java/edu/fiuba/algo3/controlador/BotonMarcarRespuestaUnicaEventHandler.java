package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Valor;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.vista.BotonOpcion;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonMarcarRespuestaUnicaEventHandler extends BotonMarcarEventHandler {
    private final int VALOR_MARCADA = 1;
    public BotonMarcarRespuestaUnicaEventHandler(Respuesta respuesta, Opcion opcion, BotonOpcion botonOpcion, VBox botones, Button botonEnviar){
        super(respuesta, opcion, botonOpcion, botones, botonEnviar);

    }
    @Override
    public void handle(Event event) {

        Valor valor = new Valor(VALOR_MARCADA);
        marcarDesmarcar(valor);
        actualizarBotonEnviar();

    }

    public void marcarDesmarcar(Valor valor){
        if (respuesta.fueMarcada(opcion)) {
            respuesta.desmarcar(opcion);
            botonOpcion.desmarcar();
            botones.getChildren().forEach(e->{
                e.setDisable(false);
            });
        }
        else {
            respuesta.marcar(opcion, valor);
            botonOpcion.marcar();
            botones.getChildren().forEach(e->{
                if(!e.equals(botonOpcion)){
                    e.setDisable(true);
                }
            });
        }
    }
}
