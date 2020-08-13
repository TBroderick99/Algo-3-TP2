package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane implements Observer {

    private Stage stage;
    private Partida partida = Partida.getInstance();
    public ContenedorPrincipal(Stage stage) {
        super();
        this.stage = stage;
        partida.addObserver(this);
        actualizarVista();
    }

    private void actualizarVista() {
        ContenedorPregunta pregunta = new ContenedorPregunta(stage, partida);

       // if(pregunta.esDeRespuestaUnica())

        ContenedorOpcionesRespuestaUnica opciones = new ContenedorOpcionesRespuestaUnica(stage, partida);

        VBox sectorRonda = new VBox();
        sectorRonda.setBackground(new Background(new BackgroundFill(Color.web("F7F5E6"), CornerRadii.EMPTY, Insets.EMPTY)));
        Text numeroDeRonda = new Text("Ronda " + Partida.getInstance().getRonda().getNumeroDeRonda());
        sectorRonda.getChildren().add(numeroDeRonda);


        this.setLeft(sectorRonda);
        this.setTop(pregunta);
        this.setCenter(opciones);
    }


    @Override
    public void change() {
        actualizarVista();
    }
}
