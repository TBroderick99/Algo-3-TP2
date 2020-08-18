package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Pos;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ContenedorPregunta extends VBox {

    private Stage stage;
    private Partida partida;
    public ContenedorPregunta (Stage stage, Partida partida) {
        super();
       // partida.addObserver(this);
        this.partida = partida;
        this.stage = stage;
        this.setSpacing(30);
        inicializarPregunta(partida);
    }

    private void inicializarPregunta(Partida partida){
        TilePane sectorInformacion = new TilePane();

        String tipoPregunta = "Pregunta " + partida.getPreguntaActual().getTipoPregunta();
        Text textoTipoPregunta = new TextoClaro(tipoPregunta, 30);


        String textoPuntaje = "Tipo puntaje: " + partida.getPreguntaActual().getTipoPuntaje();
        Text textoTipoPuntaje = new TextoClaro(textoPuntaje, 30);
        ContenedorTimer contenedorTimer = new ContenedorTimer();

        sectorInformacion.getChildren().addAll(textoTipoPregunta, textoTipoPuntaje, contenedorTimer);

        Color color1 = Color.FORESTGREEN;

        Text pregunta = new TextoClaro( partida.getPreguntaActual().getTextoPregunta(), 50);
        pregunta.setFill(Color.web("333A56"));
    //    pregunta.setTextAlignment(TextAlignment.CENTER);
        this.setAlignment(Pos.CENTER);
        getChildren().addAll(sectorInformacion, pregunta);
    }

    public String getTipoPregunta() {
        return partida.getPreguntaActual().getTipoPregunta();
    }
}
