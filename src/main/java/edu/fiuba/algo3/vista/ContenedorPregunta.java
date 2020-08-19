package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Separator;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class ContenedorPregunta extends VBox {
    //private Partida partida;
    public ContenedorPregunta (Partida partida) {
        super();
        //this.partida = partida;
        this.setSpacing(30);
        this.setPadding(new Insets(20,20,0,20));
        inicializarPregunta(partida);
    }

    private void inicializarPregunta(Partida partida){
        BorderPane sectorInformacionPregunta = new BorderPane();
//        sectorInformacionPregunta.setAlignment(Pos.CENTER);
        String tipoPregunta = "Pregunta: " + partida.getPreguntaActual().getTipoPregunta();
        Text textoTipoPregunta = new TextoClaro(tipoPregunta, 30);

        String textoPuntaje = "Tipo puntaje: " + partida.getPreguntaActual().getTipoPuntaje();
        Text textoTipoPuntaje = new TextoClaro(textoPuntaje, 30);
        ContenedorTimer contenedorTimer = new ContenedorTimer();

        sectorInformacionPregunta.setLeft(textoTipoPregunta);
        sectorInformacionPregunta.setCenter(textoTipoPuntaje);
        sectorInformacionPregunta.setRight(contenedorTimer);


        Separator separador = new Separator();
        separador.setOrientation(Orientation.HORIZONTAL);

        Text pregunta = new TextoClaro( partida.getPreguntaActual().getTextoPregunta(), 40);
        pregunta.setWrappingWidth(1000);
//        pregunta.wrappingWidthProperty().bind(this.widthProperty());
        pregunta.setFill(Color.web("333A56"));
        this.setAlignment(Pos.CENTER);
        getChildren().addAll(sectorInformacionPregunta, separador, pregunta);
    }
}
