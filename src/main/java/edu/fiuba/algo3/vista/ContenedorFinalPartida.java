package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ContenedorFinalPartida extends StackPane {

    public ContenedorFinalPartida(ArrayList<Jugador> jugadores) {

        setBackground(new Background(new BackgroundFill(Color.web("F7F5E6"), new CornerRadii(4), Insets.EMPTY)));

        VBox puntajes = new VBox();
        puntajes.setAlignment(Pos.CENTER);
        puntajes.setSpacing(20);
        puntajes.setMaxSize(400,600);
        puntajes.setBackground(new Background(new BackgroundFill(Color.web("52658F"), new CornerRadii(4), Insets.EMPTY)));

        int numeroDeJugador = 1;
        for (Jugador jugador: jugadores){

            TextoBeige textoNumeroJugador = new TextoBeige(Integer.toString(numeroDeJugador), 30);
            TextoBeige textoNombre = new TextoBeige(jugador.getNombre(), 30);
            TextoBeige textoPuntaje = new TextoBeige(Integer.toString(jugador.getPuntaje()), 30);

            HBox hBox = new HBox(textoNumeroJugador, textoNombre, textoPuntaje);
            hBox.setMaxWidth(350);
            hBox.setPrefHeight(50);

            hBox.setBackground(new Background(new BackgroundFill(Color.web("333A56"), new CornerRadii(4), Insets.EMPTY)));
            hBox.setSpacing(20);
            puntajes.getChildren().add(hBox);

            numeroDeJugador += 1;


        }




        getChildren().add(puntajes);


    }
}
