package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Partida;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane implements Observer {

    private Stage stage;
    private Partida partida;
    public ContenedorPrincipal(Stage stage, Partida partida) {
        super();
        this.stage = stage;
        this.partida = partida;
        partida.addObserver(this);
        actualizarVista();
    }

    private void actualizarVista() {
        ContenedorPregunta pregunta = new ContenedorPregunta(stage, partida);
        ContenedorOpciones opciones = new ContenedorOpciones(stage, partida);

        this.setTop(pregunta);
        this.setCenter(opciones);
    }


    @Override
    public void change() {
        actualizarVista();
    }
}
