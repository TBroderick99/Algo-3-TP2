package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ContenedorPregunta extends VBox {
    //private Partida partida;
    public ContenedorPregunta (Partida partida) {
        super();
        //this.partida = partida;
        this.setSpacing(30);
        inicializarPregunta(partida);
    }

    private void inicializarPregunta(Partida partida){
        TilePane sectorInformacionPregunta = new TilePane();
        sectorInformacionPregunta.setAlignment(Pos.CENTER);
        String tipoPregunta = "Pregunta: " + partida.getPreguntaActual().getTipoPregunta();
        Text textoTipoPregunta = new TextoClaro(tipoPregunta, 30);


        String textoPuntaje = "Tipo puntaje: " + partida.getPreguntaActual().getTipoPuntaje();
        Text textoTipoPuntaje = new TextoClaro(textoPuntaje, 30);
        ContenedorTimer contenedorTimer = new ContenedorTimer();

        sectorInformacionPregunta.getChildren().addAll(textoTipoPregunta, textoTipoPuntaje, contenedorTimer);

        Separator separador = new Separator();
        separador.setOrientation(Orientation.HORIZONTAL);

        Text pregunta = new TextoClaro( partida.getPreguntaActual().getTextoPregunta(), 50);
        pregunta.setFill(Color.web("333A56"));
        this.setAlignment(Pos.CENTER);
        getChildren().addAll(sectorInformacionPregunta, separador, pregunta);
    }
}
