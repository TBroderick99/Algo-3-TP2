package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Valor;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorOpciones extends GridPane {

    private Stage stage;

    public ContenedorOpciones(Stage stage, Partida partida) {
        super();
        this.stage = stage;
        inicializarOpciones();
    }

    private void inicializarOpciones(){
        this.setAlignment(Pos.CENTER);
        this.setPrefSize(100, 200);

        ColumnConstraints columna1 = new ColumnConstraints();
        columna1.setHalignment(HPos.RIGHT);
        this.getColumnConstraints().add(columna1);

        ColumnConstraints columna2 = new ColumnConstraints();
        columna2.setHalignment(HPos.LEFT);
        this.getColumnConstraints().add(columna2);

        this.setVgap(20);
        this.setHgap(20);

        VBox botones = new VBox();
        botones.setSpacing(10);

        var ref = new Object() {
            Respuesta respuesta = null;
        };
        for(Opcion opcion : Partida.getInstance().getPreguntaActual().getOpciones()){
            Button botonOpcion = new Button(opcion.getTexto());
            botonOpcion.setMinSize(this.getPrefHeight(), this.getPrefWidth());
            botonOpcion.setOnAction(e -> {
                ref.respuesta = new Respuesta(Partida.getInstance().getJugadorActual(), Partida.getInstance().getPreguntaActual());
                ref.respuesta.marcar(opcion, new Valor(true)); // En este caso sirve para un VoF
            });
            botones.getChildren().add(botonOpcion);
        }

        Button botonEnviarRespuesta = new Button("Enviar Respuesta");
        botonEnviarRespuesta.setOnAction(e ->
                Partida.getInstance().guardarRespuesta(ref.respuesta)
                );
        botones.getChildren().add(botonEnviarRespuesta);

        Button botonSiguienteJugador = new Button("Siguiente Jugador");
        botonSiguienteJugador.setOnAction(e ->
                Partida.getInstance().siguienteTurno()        //estaba siguiente jugador cambie a siguiente turno;
        );
        botones.getChildren().add(botonSiguienteJugador);

        Button botonSiguienteRonda = new Button("Siguiente Ronda");
        botonSiguienteRonda.setOnAction(e ->
                Partida.getInstance().siguienteRonda()
        );
        botones.getChildren().add(botonSiguienteRonda);

/*        Button opcion1 = new Button(Partida.getInstance().getPreguntaActual().getOpciones().get(0).getTexto());
        Button opcion2 = new Button("1821");
        Button opcion3 = new Button("1817");
        Button opcion4 = new Button("1831");
*/
        // opcion1.setOnAction( );
/*
        opcion1.setMinSize(this.getPrefHeight(), this.getPrefWidth());
        opcion2.setMinSize(this.getPrefHeight(), this.getPrefWidth());
        opcion3.setMinSize(this.getPrefHeight(), this.getPrefWidth());
        opcion4.setMinSize(this.getPrefHeight(), this.getPrefWidth());

        botones.getChildren().addAll(opcion1,opcion2,opcion3,opcion4);
*/
        this.add(botones, 0, 2, 2, 1);

    }
}
