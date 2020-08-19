package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonEnviarEventHandler;
import edu.fiuba.algo3.controlador.BotonMarcarRespuestaMultipleEventHandler;
import edu.fiuba.algo3.controlador.BotonOpcionZoomInEventHandler;
import edu.fiuba.algo3.controlador.BotonOpcionZoomOutEventHandler;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorOpcionesRespuestaMultiple extends VBox {

    private Stage stage;
    private Partida partida;

    public ContenedorOpcionesRespuestaMultiple(Stage stage, Partida partida) {
        super();
        this.partida = partida;
        this.stage = stage;
        this.setPadding(new Insets(50,0,50,0));
        this.setSpacing(100);
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(100, 150);
        inicializarOpciones();
    }

    private void inicializarOpciones(){

        VBox botones = new VBox();
        botones.setAlignment(Pos.CENTER);
        botones.setSpacing(10);

        Button botonEnviarRespuesta = new Button("Enviar");
        botonEnviarRespuesta.setOnAction(new BotonEnviarEventHandler(stage, partida));
        botonEnviarRespuesta.setDisable(true);

        Respuesta respuesta = partida.getTurnoActual().getRespuesta();

        for(Opcion opcion : partida.getPreguntaActual().getOpciones()){
            BotonOpcion botonOpcion = new BotonOpcion(opcion.getTexto());
            botonOpcion.setMinSize(this.getPrefHeight(), this.getPrefWidth());

            botonOpcion.setOnMouseEntered(new BotonOpcionZoomInEventHandler(botonOpcion));
            botonOpcion.setOnMouseExited(new BotonOpcionZoomOutEventHandler(botonOpcion));

            botonOpcion.setOnAction(new BotonMarcarRespuestaMultipleEventHandler(respuesta, opcion, botonOpcion, botones, botonEnviarRespuesta));
            botones.getChildren().add(botonOpcion);
        }

        botones.getChildren().add(botonEnviarRespuesta);

        this.getChildren().addAll(botones);
    }
}