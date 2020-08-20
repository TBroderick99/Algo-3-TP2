package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Grupo;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

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

        BotonInicio botonEnviarRespuesta = new BotonInicio("Enviar", 100, 60, 110,60, Color.web("52658F"), Color.web("333A56"));
        botonEnviarRespuesta.setOnAction(new BotonEnviarEventHandler(stage, partida));
        botonEnviarRespuesta.setDisable(true);

        Respuesta respuesta = partida.getTurnoActual().getRespuesta();
        Pregunta pregunta = partida.getPreguntaActual();
        ArrayList<Grupo> grupos = pregunta.getGrupos();

        Grupo grupo1 = grupos.get(0);
        Grupo grupo2 = grupos.get(1);

        for(Opcion opcion : pregunta.getOpciones()){
            final ToggleGroup group = new ToggleGroup();

            BotonGrupo botonGrupo1 = new BotonGrupo(grupo1.getNombre(), 200, 100, 220, 100, Color.web("52658F"), Color.web("333A56"));
            BotonGrupo botonGrupo2 = new BotonGrupo(grupo2.getNombre(), 200, 100, 220, 100, Color.web("52658F"), Color.web("333A56"));
            botonGrupo1.setAlignment(Pos.CENTER);

            botonGrupo2.setAlignment(Pos.CENTER);


            botonGrupo1.setOnAction(new BotonMarcarRespuestaGrupalEventHandler(respuesta, opcion, botonEnviarRespuesta, botonGrupo1, botonGrupo2, grupo1));
            botonGrupo2.setOnAction(new BotonMarcarRespuestaGrupalEventHandler(respuesta, opcion, botonEnviarRespuesta, botonGrupo2, botonGrupo1, grupo2));

            BotonOpcion botonOpcion = new BotonOpcion(opcion.getTexto(), 250 , 70, 250, 70, Color.web("52658F"), Color.web("52658F"));
            botonOpcion.setMinSize(this.getPrefHeight(), this.getPrefWidth());

            HBox contenedorBotonesGrupoYOpcion = new HBox(botonGrupo1, botonOpcion, botonGrupo2);
            contenedorBotonesGrupoYOpcion.setSpacing(30);
            contenedorBotonesGrupoYOpcion.setAlignment(Pos.CENTER);

            botones.getChildren().add(contenedorBotonesGrupoYOpcion);
        }

        botones.getChildren().add(botonEnviarRespuesta);

        this.getChildren().addAll(botones);
    }

}
