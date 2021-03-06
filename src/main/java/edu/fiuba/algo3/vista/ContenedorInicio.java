package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonAcercaDeEventHandler;
import edu.fiuba.algo3.controlador.BotonComoJugarEventHandler;
import edu.fiuba.algo3.controlador.BotonInicioEventHandler;
import edu.fiuba.algo3.controlador.BotonSalirEventHandler;
import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorInicio extends VBox {
    Stage stage;
    public ContenedorInicio(Stage stage){
        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(20,20,20,20));
        this.setBackground(new Background(new BackgroundFill(Color.web("F7F5E6"), CornerRadii.EMPTY, Insets.EMPTY)));

        Text titulo = new Text("Kahoot!");
        titulo.setFont(Font.font("Calibri", FontWeight.BOLD,60));
        titulo.setFill(Color.web("333A56"));

        VBox botoneraInicio = new VBox();

        Button botonInicio = new BotonInicio("Inicio", 140, 70, 160, 70, Color.web("52658F"), Color.web("333A56"));
        botonInicio.setOnAction(new BotonInicioEventHandler(stage));
        botonInicio.setDefaultButton(true);

        // Este es un separador
        Region region = new Region();
        region.setPrefHeight(100);

        Button botonComoJugar = new BotonInicio("Cómo jugar",  140, 70, 160, 70, Color.web("52658F"), Color.web("333A56"));
        botonComoJugar.setOnAction(new BotonComoJugarEventHandler());

        Button botonAcercaDe = new BotonInicio("Acerca De",  140, 70, 160, 70, Color.web("52658F"), Color.web("333A56"));
        botonAcercaDe.setOnAction(new BotonAcercaDeEventHandler());

        Button botonSalir = new BotonInicio("Salir", 140, 70, 160, 70, Color.web("52658F"), Color.web("333A56"));
        botonSalir.setOnAction(new BotonSalirEventHandler());

        botoneraInicio.getChildren().addAll(botonInicio, botonComoJugar, botonAcercaDe, botonSalir);
        botoneraInicio.setSpacing(10);
        botoneraInicio.setAlignment(Pos.BOTTOM_CENTER);

        this.getChildren().addAll(titulo, region, botoneraInicio);
    }

}
