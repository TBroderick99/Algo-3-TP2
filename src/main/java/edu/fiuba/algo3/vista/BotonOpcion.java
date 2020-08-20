package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BotonOpcion extends BotonZoomeable {

    public BotonOpcion(String texto, double anchoDefault, double altoDefault, double anchoZoom, double altoZoom, Paint colorDefault, Paint colorZoom){
        super(texto, anchoDefault, altoDefault, anchoZoom, altoZoom, colorDefault, colorZoom);
        this.setFont(Font.font("Calibri", FontWeight.BOLD,18));
        this.setTextFill(Paint.valueOf("FFFFFF"));
    }

    public void marcar() {
        this.setBorder(new Border(new BorderStroke(Color.web("333A56"), BorderStrokeStyle.SOLID, new CornerRadii(4), new BorderWidths(5))));
    }

    public void desmarcar() {
        this.setBorder(Border.EMPTY);
    }


}

