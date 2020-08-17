package edu.fiuba.algo3.controlador;

import javafx.scene.control.Button;

public class BotonConsumirBoosterX3EventHandler extends BotonConsumirBoosterX2EventHandler {
    public BotonConsumirBoosterX3EventHandler(Button boton) {
        super(boton);
        this.FACTOR_MULTIPLICACION = 3;
    }
}
