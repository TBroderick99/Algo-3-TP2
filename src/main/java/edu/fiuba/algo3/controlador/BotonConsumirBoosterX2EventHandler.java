package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Booster;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Turno;
import javafx.scene.control.Button;

public class BotonConsumirBoosterX2EventHandler extends ConsumirBoosterEventHandler {
    protected int FACTOR_MULTIPLICACION;

    public BotonConsumirBoosterX2EventHandler(Button boton, Turno turnoActual){
        super(boton, turnoActual);
        this.FACTOR_MULTIPLICACION = 2;
    }

    public Booster consumirBooster(){
        return turnoActual.getJugador().getBoosterMultiplicador(FACTOR_MULTIPLICACION);
    }
}
