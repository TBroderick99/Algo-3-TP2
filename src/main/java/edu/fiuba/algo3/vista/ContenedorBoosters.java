package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonConsumirBoosterExclusividadEventHandler;
import edu.fiuba.algo3.controlador.BotonConsumirBoosterX2EventHandler;
import edu.fiuba.algo3.controlador.BotonConsumirBoosterX3EventHandler;
import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ContenedorBoosters extends VBox {

    private Partida partida;
    public ContenedorBoosters(Partida partida){
        this.partida = partida;
        this.setSpacing(15);
        this.setAlignment(Pos.CENTER);

        inicializarContenedorBoosters();
    }

    private void inicializarContenedorBoosters() {
        Separator separator = new Separator();
        separator.setOrientation(Orientation.HORIZONTAL);

        Text textoBooster = new Text("Boosters:");
        textoBooster.setFont(Font.font("Calibri", FontWeight.BOLD,30));
        textoBooster.setFill(Color.web("333A56"));

        this.getChildren().addAll(separator, textoBooster);

        if (partida.getPreguntaActual().getTipoPuntaje().equals("Penalidad")) {
            for (int i = 0; i < partida.getJugadorActual().getCantidadBoosterMultiplicadorDisponibles(2); i++) {
                Button botonBooster = new BotonInicio("x2", 140, 40, 150, 40, Color.web("52658F"), Color.web("333A56"));
                botonBooster.setOnAction(new BotonConsumirBoosterX2EventHandler(botonBooster, partida.getTurnoActual()));
                this.getChildren().add(botonBooster);
            }

            for (int i = 0; i < partida.getJugadorActual().getCantidadBoosterMultiplicadorDisponibles(3); i++) {
                Button botonBooster = new BotonInicio("x3", 140, 40, 150, 40, Color.web("52658F"), Color.web("333A56"));
                botonBooster.setOnAction(new BotonConsumirBoosterX3EventHandler(botonBooster, partida.getTurnoActual()));
                this.getChildren().add(botonBooster);
            }
        }
        else {
            for (int i = 0; i < partida.getJugadorActual().getCantidadBoosterExclusividadDisponibles(); i++) {
                Button botonBooster = new BotonInicio("Exclusividad", 140, 40, 150, 40, Color.web("52658F"), Color.web("333A56"));
                botonBooster.setOnAction(new BotonConsumirBoosterExclusividadEventHandler(botonBooster, partida.getTurnoActual()));
                this.getChildren().add(botonBooster);
            }
        }
    }
}
