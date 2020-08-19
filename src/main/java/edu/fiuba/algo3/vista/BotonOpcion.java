package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BotonOpcion extends Button {
    public BotonOpcion(String texto){
        super(texto);
        this.setPrefSize(100,200);
        this.setBackground(new Background(new BackgroundFill(Color.web("52658F"), new CornerRadii(4), Insets.EMPTY)));
        this.setFont(Font.font("Calibri", FontWeight.BOLD,18));
        this.setTextFill(Paint.valueOf("FFFFFF"));
    }

    public void marcar() {
        this.setBorder(new Border(new BorderStroke(Color.RED, BorderStrokeStyle.SOLID, new CornerRadii(4), new BorderWidths(5))));
    }

    public void desmarcar() {
        this.setBorder(Border.EMPTY);
    }
}
