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
    TextField nombreJugador;
    private final int CANTIDAD_JUGADORES = 2;

    public BotonSiguienteEventHandler(Stage stage, TextField nombreJugador) {
        this.stage = stage;
        this.nombreJugador = nombreJugador;
    }

    @Override
    public void handle(Event event) {
        if(!nombreJugadorEsValido(nombreJugador)) {
            cambiarColorTexto(nombreJugador);
            return;
        }
        Partida.getInstance().agregarJugador(nombreJugador.getText());
        if(Partida.getInstance().cantidadJugadoresAgregados() == Partida.getInstance().cantidadMaximaDeJugadores()){
            Partida.getInstance().inicializarPartida(CreadorDePreguntas.crearPreguntas());
            stage.setScene(new Scene(new ContenedorPrincipal(stage)));
            stage.show();
            stage.setFullScreen(true);
            return;
        }
        stage.setScene(new Scene(new ContenedorIngresoJugadores(stage),500,700));
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
