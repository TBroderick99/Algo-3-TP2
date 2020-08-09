package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BotonInicio extends Button {
    public BotonInicio(String texto){
        super(texto);
        this.setPrefSize(140,70);
        this.setBackground(new Background(new BackgroundFill(Color.web("52658F"), CornerRadii.EMPTY, Insets.EMPTY)));
        this.setFont(Font.font("Calibri", FontWeight.BOLD,18));
        this.setTextFill(Paint.valueOf("FFFFFF"));
    }
}
