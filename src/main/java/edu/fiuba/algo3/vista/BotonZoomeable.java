package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.BotonZoomInEventHandler;
import edu.fiuba.algo3.controlador.BotonZoomOutEventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public abstract class BotonZoomeable extends Button {

    protected double anchoDefault;
    protected double altoDefault;

    protected double anchoZoom;
    protected double altoZoom;

    protected Paint colorDefault;
    protected Paint colorZoom;

    public BotonZoomeable(String texto, double anchoDefault, double altoDefault, double anchoZoom, double altoZoom, Paint colorDefault, Paint colorZoom){
        super(texto);
        this.anchoDefault = anchoDefault;
        this.altoDefault = altoDefault;
        this.anchoZoom = anchoZoom;
        this.altoZoom = altoZoom;
        this.colorDefault = colorDefault;
        this.colorZoom = colorZoom;

        this.setOnMouseEntered(new BotonZoomInEventHandler(this));
        this.setOnMouseExited(new BotonZoomOutEventHandler(this));

        this.setBackground(new Background(new BackgroundFill(colorDefault, new CornerRadii(4), Insets.EMPTY)));
        this.setPrefSize(anchoDefault,altoDefault);

    }

    public void zoomIn(){

        this.setPrefSize(anchoZoom,altoZoom);
        this.setBackground(new Background(new BackgroundFill(colorZoom, new CornerRadii(4), Insets.EMPTY)));
    }

    public void zoomOut(){
        this.setPrefSize(anchoDefault,altoDefault);
        this.setBackground(new Background(new BackgroundFill(colorDefault, new CornerRadii(4), Insets.EMPTY)));
    }


}
