package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ContenedorInformacion extends VBox {
    private Partida partida;
    public ContenedorInformacion(Partida partida){
        this.setAlignment(Pos.CENTER);
        Text numeroDeRonda = new Text("Ronda " + partida.getRonda().getNumeroDeRonda());
        numeroDeRonda.setFont(Font.font("Calibri", FontWeight.BOLD,30));
        numeroDeRonda.setFill(Color.web("333A56"));
        Text jugador = new Text("Turno de : " +
                partida.getNombreJugadorActual() +
                        "\nPuntaje: "+ partida.getJugadorActual().getPuntaje()
        );
        jugador.setFont(Font.font("Calibri", FontWeight.BOLD,22));
        jugador.setFill(Color.web("333A56"));

        this.getChildren().addAll(numeroDeRonda, jugador);
    }
}
