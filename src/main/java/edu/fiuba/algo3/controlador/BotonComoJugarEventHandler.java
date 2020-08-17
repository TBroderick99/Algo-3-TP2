package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class BotonComoJugarEventHandler implements EventHandler {
    @Override
    public void handle(Event event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("¿Cómo jugar?: Instrucciones");
        alert.setHeaderText("TP2 - Kahoot - 75.07 Algoritmos y  programacion III");
        String mensaje =
                "Kahoot es un juego donde dos jugadores se enfrentan en una feroz batalla de preguntas y respuestas.\r" +
                "Los jugadores juegan, jugando al jugar. Quizas activen un Booster.\r"+
                "Blablabla, blablabla, blabla, bla.";
        alert.setContentText(mensaje);
        alert.show();
    }
}
