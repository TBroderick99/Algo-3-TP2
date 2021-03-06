package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.ContenedorFinalPartida;
import edu.fiuba.algo3.vista.ContenedorIngresoJugadores;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonInicioEventHandler implements EventHandler {
    Stage stage;

    public BotonInicioEventHandler(Stage stage) {
        super();
        this.stage = stage;

    }

    @Override
    public void handle(Event event) {
        stage.setScene( new Scene(new ContenedorIngresoJugadores(stage, new Partida()), 500,700));
    }
}
