package edu.fiuba.algo3.vista;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorPregunta extends VBox {

    private Stage stage;

    public ContenedorPregunta (Stage stage) {
        super();
        this.stage = stage;

        Color color1 = Color.FORESTGREEN;

        Text numeroPregunta = new Text( "Pregunta 1");
        numeroPregunta.setFont(Font.font("Arial", 18));
        numeroPregunta.setFill(color1);

        Text pregunta = new Text( "¿En qué año fue fundada la UBA?" );
        pregunta.setFont(Font.font("Calibri", 30));

        getChildren().addAll(numeroPregunta, pregunta);

    }

}
