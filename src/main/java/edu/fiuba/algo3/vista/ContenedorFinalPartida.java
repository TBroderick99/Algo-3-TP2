package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonInicioEventHandler;
import edu.fiuba.algo3.controlador.BotonSalirEventHandler;
import edu.fiuba.algo3.controlador.BotonZoomInEventHandler;
import edu.fiuba.algo3.controlador.BotonZoomOutEventHandler;
import edu.fiuba.algo3.modelo.Jugador;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ContenedorFinalPartida extends StackPane {

    public ContenedorFinalPartida(Stage stage, ArrayList<Jugador> jugadores) {

        setBackground(new Background(new BackgroundFill(Color.web("F7F5E6"), new CornerRadii(4), Insets.EMPTY)));

        VBox puntajes = new VBox();
        puntajes.setAlignment(Pos.CENTER);
        puntajes.setSpacing(20);
        puntajes.setMaxSize(400,600);
        puntajes.setBackground(new Background(new BackgroundFill(Color.web("52658F"), new CornerRadii(14), Insets.EMPTY)));


        TextoBeige textoNumeroJugador = new TextoBeige("Posición", 30);
        TextoBeige textoNombre = new TextoBeige("Usuario", 30);
        TextoBeige textoPuntaje = new TextoBeige("Puntaje", 30);

        HBox hBox = new HBox(textoNumeroJugador, textoNombre, textoPuntaje);
        hBox.setMaxWidth(350);
        hBox.setPrefHeight(50);
        hBox.setMargin(textoNumeroJugador, new Insets(10,10,10,10));
        hBox.setMargin(textoNombre, new Insets(10,10,10,10));
        hBox.setMargin(textoPuntaje, new Insets(10,10,10,10));

        hBox.setBackground(new Background(new BackgroundFill(Color.web("333A56"), new CornerRadii(4), Insets.EMPTY)));
        hBox.setSpacing(20);
        puntajes.getChildren().add(hBox);
        int numeroDeJugador = 1;
        for (Jugador jugador: jugadores){

            textoNumeroJugador = new TextoBeige(Integer.toString(numeroDeJugador), 30);
            textoNombre = new TextoBeige(jugador.getNombre(), 30);
            textoPuntaje = new TextoBeige(Integer.toString(jugador.getPuntaje()), 30);

            hBox = new HBox(textoNumeroJugador, textoNombre, textoPuntaje);
            hBox.setMaxWidth(350);
            hBox.setPrefHeight(50);
            hBox.setMargin(textoNumeroJugador, new Insets(10,10,10,10));
            hBox.setMargin(textoNombre, new Insets(10,10,10,10));
            hBox.setMargin(textoPuntaje, new Insets(10,10,10,10));

            hBox.setBackground(new Background(new BackgroundFill(Color.web("333A56"), new CornerRadii(4), Insets.EMPTY)));
            hBox.setSpacing(20);
            puntajes.getChildren().add(hBox);

            numeroDeJugador += 1;

        }

        BotonFinal botonVolverAJugar = new BotonFinal("Volver a Jugar", 200, 70, 210, 70, Color.web("333A56"), Color.web("333A56"));
        botonVolverAJugar.setOnAction(new BotonInicioEventHandler(stage));

        BotonFinal botonSalir = new BotonFinal("Salir", 200, 70, 210, 70, Color.web("333A56"),Color.web("333A56"));
        botonSalir.setOnAction(new BotonSalirEventHandler());


        puntajes.getChildren().addAll(botonVolverAJugar, botonSalir);
        getChildren().add(puntajes);


    }
}
