package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonConsumirBoosterX2EventHandler;
import edu.fiuba.algo3.controlador.BotonConsumirBoosterX3EventHandler;
import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
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
        Text jugador = new Text("Jugador: " + partida.getNombreJugadorActual() + "\nPuntaje: "+ partida.getJugadorActual().getPuntaje());

        sectorRonda.getChildren().addAll(numeroDeRonda, jugador);


        VBox contenedorCentral = new VBox();
        contenedorCentral.getChildren().addAll(pregunta,opciones);

        VBox sectorBooster = new VBox();

        Text textoBooster = new Text("Boosters:");
        sectorBooster.getChildren().add(textoBooster);

        for(int i=0; i<Partida.getInstance().getJugadorActual().getCantidadBoosterMultiplicadorDisponibles(2); i++){
            Button botonBooster = new Button("x2");
            botonBooster.setOnAction(new BotonConsumirBoosterX2EventHandler(botonBooster));
            sectorBooster.getChildren().add(botonBooster);
        }

        for(int i=0; i<Partida.getInstance().getJugadorActual().getCantidadBoosterMultiplicadorDisponibles(3); i++){
            Button botonBooster = new Button("x3");
            botonBooster.setOnAction(new BotonConsumirBoosterX3EventHandler(botonBooster));
            sectorBooster.getChildren().add(botonBooster);
        }
        for(int i=0; i<Partida.getInstance().getJugadorActual().getCantidadBoosterExclusividadDisponibles(); i++){
            Button botonBooster = new Button("Exclusividad");
            sectorBooster.getChildren().add(botonBooster);
        }
        sectorRonda.getChildren().add(sectorBooster);

        this.setLeft(sectorRonda);
        this.setCenter(contenedorCentral);
    }


    @Override
    public void change() {
        actualizarVista();
    }
}
