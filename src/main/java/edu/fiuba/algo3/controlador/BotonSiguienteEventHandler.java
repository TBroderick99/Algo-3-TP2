package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.preguntas.CreadorDePreguntas;
import edu.fiuba.algo3.vista.ContenedorIngresoJugadores;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonSiguienteEventHandler implements EventHandler {
    Stage stage;
    Partida partida;
    TextField nombreJugador;
    private final int CANTIDAD_JUGADORES = 2;

    public BotonSiguienteEventHandler(Stage stage, Partida partida, TextField nombreJugador) {
        this.stage = stage;
        this.partida = partida;
        this.nombreJugador = nombreJugador;
    }

    @Override
    public void handle(Event event) {
        if(!nombreJugadorEsValido(nombreJugador)) {
            cambiarColorTexto(nombreJugador);
            return;
        }
        partida.agregarJugador(nombreJugador.getText());
        if(partida.cantidadJugadoresAgregados() == partida.cantidadMaximaDeJugadores()){
            partida.inicializarPartida(CreadorDePreguntas.crearPreguntas());
            stage.setScene(new Scene(new ContenedorPrincipal(stage, partida)));
            stage.show();
            stage.setFullScreen(true);
            return;
        }
        stage.setScene(new Scene(new ContenedorIngresoJugadores(stage, partida),500,700));
        stage.show();
    }

    private boolean nombreJugadorEsValido(TextField nombreJugador) {
        if (nombreJugador.getText().isEmpty())
            return false;
        return true;
    }

    private void cambiarColorTexto(TextField nombreJugador) {
        nombreJugador.setStyle("-fx-prompt-text-fill: red");
    }
}
