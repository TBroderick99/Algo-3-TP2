package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.preguntas.boosters.Booster;
import edu.fiuba.algo3.modelo.Turno;
import javafx.scene.control.Button;

public class BotonConsumirBoosterExclusividadEventHandler extends ConsumirBoosterEventHandler {
    private Button boton;

    public BotonConsumirBoosterExclusividadEventHandler(Button boton, Turno turnoActual){
        super(boton, turnoActual);
    }

    @Override
    public Booster consumirBooster() {
        return turnoActual.getJugador().getBoosterExclusividad();
    }
}
