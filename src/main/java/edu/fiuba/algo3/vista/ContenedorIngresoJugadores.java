package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Partida;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorIngresoJugadores extends VBox {
    private Stage stage;

    public ContenedorIngresoJugadores(Stage stage) {
    super();
    this.stage = stage;

    Label titulo = new Label("Ingrese el nombre de cada jugador:");

    Label etiquetaJugador1 = new Label("Jugador 1:");
    TextField nombreJugador1 = new TextField();
    nombreJugador1.setPromptText("Ingrese un nombre.");
    HBox jugador1 = new HBox(20, etiquetaJugador1, nombreJugador1);

    TextField nombreJugador2 = new TextField();
    nombreJugador2.setPromptText("Ingrese un nombre.");

    this.getChildren().addAll(titulo,jugador1);

    }

}
