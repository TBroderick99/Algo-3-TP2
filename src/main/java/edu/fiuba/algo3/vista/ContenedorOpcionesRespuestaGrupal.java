package edu.fiuba.algo3.vista;

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

public class ContenedorOpcionesRespuestaGrupal extends GridPane {

    private Stage stage;
    private Partida partida;

    public ContenedorOpcionesRespuestaGrupal(Stage stage, Partida partida) {
        super();
        this.stage = stage;
        this.partida = partida;
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

        Respuesta respuesta = partida.getTurnoActual().getRespuesta();
        for(Opcion opcion : partida.getPreguntaActual().getOpciones()){
            Button botonOpcion = new Button(opcion.getTexto());
            botonOpcion.setMinSize(this.getPrefHeight(), this.getPrefWidth());
            botonOpcion.setOnAction(new BotonMarcarRespuestaUnicaEventHandler(respuesta, opcion));
            botones.getChildren().add(botonOpcion);
        }

        Button botonEnviarRespuesta = new Button("Enviar");
        botonEnviarRespuesta.setOnAction(e -> {
            partida.enviarRespuesta();
            try {
                partida.siguienteTurno();
            }
            catch (NoHaySiguienteTurnoError turnoError) {
                partida.asignarPuntajes();
                try {
                    partida.siguienteRonda();
                }
                catch (NoHaySiguienteRondaError rondaError) {
                    stage.setScene(new Scene(new ContenedorFinalPartida()));
                }
            }
        });
        botones.getChildren().add(botonEnviarRespuesta);


        this.add(botones, 0, 2, 2, 1);

    }
}
