package edu.fiuba.algo3.vista;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorOpciones extends GridPane {

    private Stage stage;

    public ContenedorOpciones(Stage stage) {
        super();
        this.stage = stage;

        this.setAlignment(Pos.CENTER);
        this.setPrefSize(100, 200);

        ColumnConstraints columna1 = new ColumnConstraints();
        columna1.setHalignment(HPos.RIGHT);
        this.getColumnConstraints().add(columna1);

        ColumnConstraints columna2 = new ColumnConstraints();
        columna2.setHalignment(HPos.LEFT);
        this.getColumnConstraints().add(columna2);

        this.setVgap(20);
        this.setHgap(20);

        VBox botones = new VBox();
        botones.setSpacing(10);

        Button opcion1 = new Button("1840");
        Button opcion2 = new Button("1821");
        Button opcion3 = new Button("1817");
        Button opcion4 = new Button("1831");

        opcion1.setMinSize(this.getPrefHeight(), this.getPrefWidth());
        opcion2.setMinSize(this.getPrefHeight(), this.getPrefWidth());
        opcion3.setMinSize(this.getPrefHeight(), this.getPrefWidth());
        opcion4.setMinSize(this.getPrefHeight(), this.getPrefWidth());

        botones.getChildren().addAll(opcion1,opcion2,opcion3,opcion4);

        this.add(botones, 0, 2, 2, 1);

    }
}
