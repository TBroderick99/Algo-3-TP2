package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonSiguienteEventHandler;
import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorIngresoJugadores extends VBox {
    private Stage stage;

    public ContenedorIngresoJugadores(Stage stage) {
    super();
    this.stage = stage;
    this.setAlignment(Pos.CENTER);
    this.setPadding(new Insets(20,20,20,20));
    this.setBackground(new Background(new BackgroundFill(Color.web("F7F5E6"), CornerRadii.EMPTY, Insets.EMPTY)));
    this.setSpacing(20);

    Text titulo = new Text("Ingrese su nombre:");
    titulo.setFont(Font.font("Calibri", FontWeight.BOLD,40));
    titulo.setFill(Color.web("333A56"));

    Text etiquetaJugador = new Text("Jugador "+ (Partida.getInstance().cantidadJugadoresAgregados()+1) +":");
    etiquetaJugador.setFont(Font.font("Calibri", FontWeight.BOLD,16));
    etiquetaJugador.setFill(Color.web("333A56"));

    TextField nombreJugador = new TextField();
    nombreJugador.setPromptText("Ingrese un nombre.");
    HBox jugador1 = new HBox(20, etiquetaJugador, nombreJugador);
    jugador1.setAlignment(Pos.CENTER);

    // Este es un separador
    Region region = new Region();
    region.setPrefHeight(100);

    Button botonSiguiente = new Button("Siguiente");
    botonSiguiente.setOnAction(new BotonSiguienteEventHandler(stage, nombreJugador));
    botonSiguiente.setPrefSize(140,70);
    botonSiguiente.setBackground(new Background(new BackgroundFill(Color.web("52658F"), CornerRadii.EMPTY, Insets.EMPTY)));
    botonSiguiente.setFont(Font.font("Calibri", FontWeight.BOLD,18));
    botonSiguiente.setTextFill(Paint.valueOf("FFFFFF"));
    botonSiguiente.setDefaultButton(true);

    this.getChildren().addAll(titulo, region, jugador1, botonSiguiente);

    }

}
