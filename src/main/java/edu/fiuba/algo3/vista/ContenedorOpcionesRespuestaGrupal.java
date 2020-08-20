package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Grupo;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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

        Button botonEnviarRespuesta = new Button("Enviar");
        botonEnviarRespuesta.setOnAction(new BotonEnviarEventHandler(stage, partida));
        botonEnviarRespuesta.setDisable(true);

        Respuesta respuesta = partida.getTurnoActual().getRespuesta();
        Pregunta pregunta = partida.getPreguntaActual();
        ArrayList<Grupo> grupos = pregunta.getGrupos();

        Grupo grupo1 = grupos.get(0);
        Grupo grupo2 = grupos.get(1);

        for(Opcion opcion : pregunta.getOpciones()){
            final ToggleGroup group = new ToggleGroup();

            RadioButton radioButton1 = new RadioButton(grupo1.getNombre());
            RadioButton radioButton2 = new RadioButton(grupo2.getNombre());

            radioButton1.setFont(Font.font("Calibri", FontWeight.BOLD,18));
            radioButton1.setTextFill(Paint.valueOf("FFFFFF"));
            radioButton1.setBackground(new Background(new BackgroundFill(Color.web("333A56"), new CornerRadii(4), Insets.EMPTY)));
            radioButton1.setPrefSize(200,100);
            radioButton1.setAlignment(Pos.CENTER);

            radioButton2.setFont(Font.font("Calibri", FontWeight.BOLD,18));
            radioButton2.setTextFill(Paint.valueOf("FFFFFF"));
            radioButton2.setBackground(new Background(new BackgroundFill(Color.web("333A56"), new CornerRadii(4), Insets.EMPTY)));
            radioButton2.setPrefSize(200,100);
            radioButton2.setAlignment(Pos.CENTER);

            radioButton1.setToggleGroup(group);
            radioButton2.setToggleGroup(group);

            radioButton1.setOnAction(new CheckBoxMarcarGrupoEventHandler(respuesta, opcion, botonEnviarRespuesta, radioButton1, grupo1));
            radioButton2.setOnAction(new CheckBoxMarcarGrupoEventHandler(respuesta, opcion, botonEnviarRespuesta, radioButton2, grupo2));

            BotonOpcion botonOpcion = new BotonOpcion(opcion.getTexto(), 250 , 70, 270, 100, Color.web("52658F"), Color.web("333A56"));
            botonOpcion.setMinSize(this.getPrefHeight(), this.getPrefWidth());

            HBox contenedorCheckBoxesYOpcion = new HBox(radioButton1, botonOpcion, radioButton2);
            contenedorCheckBoxesYOpcion.setSpacing(20);
            contenedorCheckBoxesYOpcion.setAlignment(Pos.CENTER);

            botones.getChildren().add(contenedorCheckBoxesYOpcion);
        }

        botones.getChildren().add(botonEnviarRespuesta);

        this.getChildren().addAll(botones);
    }

}
