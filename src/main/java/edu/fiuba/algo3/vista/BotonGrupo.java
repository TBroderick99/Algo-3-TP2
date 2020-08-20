package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class BotonGrupo extends BotonZoomeable{
    private Boolean estaMarcado;

    public BotonGrupo(String texto, double anchoDefault, double altoDefault, double anchoZoom, double altoZoom, Paint colorDefault, Paint colorZoom) {
        super(texto, anchoDefault, altoDefault, anchoZoom, altoZoom, colorDefault, colorZoom);
        this.setFont(Font.font("Calibri", FontWeight.BOLD,18));
        this.setTextFill(Paint.valueOf("FFFFFF"));
        estaMarcado = false;
    }

    @Override
    public void zoomIn(){
        if (!estaMarcado) {
        super.zoomIn();
        }
    }


    @Override
    public void zoomOut(){
        this.setPrefSize(anchoDefault, altoDefault);
        if (!estaMarcado) {
            this.setBackground(new Background(new BackgroundFill(colorDefault, new CornerRadii(4), Insets.EMPTY)));
        }
    }

    public void dejarMarcado(){
        estaMarcado = true;
    }

    public void sacarMarca(){
        estaMarcado = false;
    }




}
