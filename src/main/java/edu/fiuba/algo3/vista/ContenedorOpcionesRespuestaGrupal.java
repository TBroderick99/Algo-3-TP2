package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonEnviarEventHandler;
import edu.fiuba.algo3.controlador.BotonMarcarRespuestaUnicaEventHandler;
import edu.fiuba.algo3.modelo.Excepciones.NoHaySiguienteRondaError;
import edu.fiuba.algo3.modelo.Excepciones.NoHaySiguienteTurnoError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorOpcionesRespuestaGrupal extends VBox {

    private Stage stage;
    private Partida partida;

    public ContenedorOpcionesRespuestaGrupal(Stage stage, Partida partida) {
        super();
        this.stage = stage;
        this.partida = partida;
        this.setSpacing(30);
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
            botonOpcion.setOnAction(new BotonMarcarRespuestaUnicaEventHandler(respuesta, opcion, botonOpcion, botones, botonEnviarRespuesta));
            botones.getChildren().add(botonOpcion);
        }

        botones.getChildren().add(botonEnviarRespuesta);

        this.getChildren().addAll(botones);
    }
}
