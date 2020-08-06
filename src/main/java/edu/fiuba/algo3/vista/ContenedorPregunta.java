package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Partida;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorPregunta extends VBox {

    private Stage stage;
    private Partida partida;
    public ContenedorPregunta (Stage stage, Partida partida) {
        super();
       // partida.addObserver(this);
        this.partida = partida;
        this.stage = stage;

        inicializarPregunta(partida);
    }

    private void inicializarPregunta(Partida partida){
        Color color1 = Color.FORESTGREEN;
        Text numeroPregunta = new Text( "Numero Pregunta");
        numeroPregunta.setFont(Font.font("Arial", 18));
        numeroPregunta.setFill(color1);
        Text jugador = new Text("Jugador: " + partida.getNombreJugadorActual() + " Puntaje: "+ partida.getJugadorActual().getPuntaje());
        Text pregunta = new Text( partida.getPreguntaActual().getTextoPregunta());
        pregunta.setFont(Font.font("Calibri", 30));
        getChildren().addAll(jugador, numeroPregunta, pregunta);
    }
}
