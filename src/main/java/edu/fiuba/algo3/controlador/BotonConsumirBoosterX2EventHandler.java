package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Booster;
import edu.fiuba.algo3.modelo.Partida;
import javafx.scene.control.Button;

public class BotonConsumirBoosterX2EventHandler extends ConsumirBoosterEventHandler {
    protected int FACTOR_MULTIPLICACION;

    public BotonConsumirBoosterX2EventHandler(Button boton){
        super(boton);
        this.FACTOR_MULTIPLICACION = 2;
    }

    public Booster consumirBooster(){
        return Partida.getInstance().getJugadorActual().getBoosterMultiplicador(FACTOR_MULTIPLICACION);
    }
}
