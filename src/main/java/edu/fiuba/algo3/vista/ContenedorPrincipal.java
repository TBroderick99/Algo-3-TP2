package edu.fiuba.algo3.vista;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    private Stage stage;

    public ContenedorPrincipal(Stage stage) {
        super();
        this.stage = stage;

        ContenedorPregunta pregunta = new ContenedorPregunta(stage);
        ContenedorOpciones opciones = new ContenedorOpciones(stage);

        this.setTop(pregunta);
        this.setCenter(opciones);

    }


}
