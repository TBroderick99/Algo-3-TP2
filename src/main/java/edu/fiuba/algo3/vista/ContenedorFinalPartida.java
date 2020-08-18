package edu.fiuba.algo3.vista;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class ContenedorFinalPartida extends VBox {

    public ContenedorFinalPartida() {
        Button botonEnviarRespuesta = new Button("Enviar");
        getChildren().add(botonEnviarRespuesta);
    }
}
