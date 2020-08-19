package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class ContenedorInformacion extends VBox {
    private Partida partida;
    public ContenedorInformacion(Partida partida){
        this.setAlignment(Pos.CENTER);

        TextoClaro numeroDeRonda = new TextoClaro("Ronda " + partida.getRonda().getNumeroDeRonda(), 30);

        Text turno = new TextoClaro("Turno de : " + partida.getNombreJugadorActual(),22);

        Text puntaje = new TextoClaro("Puntaje: " + partida.getJugadorActual().getPuntaje(),22);

        this.getChildren().addAll(numeroDeRonda, turno, puntaje);
    }
}
