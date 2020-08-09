package edu.fiuba.algo3.controlador;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class BotonAcercaDeEventHandler implements EventHandler {

    @Override
    public void handle(Event event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Acerca de...");
        alert.setHeaderText("TP2 - Kahoot - 75.07 Algoritmos y  programacion III");
        String mensaje =
                "Integrantes del grupo:\n" +
                        "\t- BRODERICK, Thomas\n" +
                        "\t- BROCCA, Pablo Martín\n" +
                        "\t- DE LA PLATA, Facundo Gastón\n" +
                        "\t- DUZAC, Juan Martín\n" +
                        "\t- QUEIROLO DOMINGUEZ, Cristian Daniel\n";
        alert.setContentText(mensaje);
        alert.show();
    }
}
