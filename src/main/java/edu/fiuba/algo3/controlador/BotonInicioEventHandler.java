package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.ContenedorIngresoJugadores;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonInicioEventHandler implements EventHandler {
    Stage stage;
    Scene proximaEscena;

    public BotonInicioEventHandler(Stage stage, Scene proximaEscena) {
        super();
        this.stage = stage;
        this.proximaEscena = proximaEscena;
    }

    @Override
    public void handle(Event event) {
        stage.setScene(this.proximaEscena);
    }
}
