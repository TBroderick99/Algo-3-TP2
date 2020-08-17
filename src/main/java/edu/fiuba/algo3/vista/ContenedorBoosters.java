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
    public ContenedorBoosters(){
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

        for(int i = 0; i< Partida.getInstance().getJugadorActual().getCantidadBoosterMultiplicadorDisponibles(2); i++){
            Button botonBooster = new BotonInicio("x2");
            botonBooster.setPrefSize(140,40);
            botonBooster.setFont(Font.font("Calibri", FontWeight.BOLD,16));
            botonBooster.setOnAction(new BotonConsumirBoosterX2EventHandler(botonBooster));
            this.getChildren().add(botonBooster);
        }

        for(int i=0; i<Partida.getInstance().getJugadorActual().getCantidadBoosterMultiplicadorDisponibles(3); i++){
            Button botonBooster = new BotonInicio("x3");
            botonBooster.setPrefSize(140,40);
            botonBooster.setFont(Font.font("Calibri", FontWeight.BOLD,16));
            botonBooster.setOnAction(new BotonConsumirBoosterX3EventHandler(botonBooster));
            this.getChildren().add(botonBooster);
        }
        for(int i=0; i<Partida.getInstance().getJugadorActual().getCantidadBoosterExclusividadDisponibles(); i++){
            Button botonBooster = new BotonInicio("Exclusividad");
            botonBooster.setPrefSize(140,40);
            botonBooster.setFont(Font.font("Calibri", FontWeight.BOLD,16));
            botonBooster.setOnAction(new BotonConsumirBoosterExclusividadEventHandler(botonBooster));
            this.getChildren().add(botonBooster);
        }
    }
}
