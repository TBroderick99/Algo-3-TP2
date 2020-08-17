package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Booster;
import edu.fiuba.algo3.modelo.Partida;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonConsumirBoosterExclusividadEventHandler extends ConsumirBoosterEventHandler {
    private Button boton;
    public BotonConsumirBoosterExclusividadEventHandler(Button boton){
        super(boton);
    }

    @Override
    public Booster consumirBooster() {
        return Partida.getInstance().getJugadorActual().getBoosterExclusividad();
    }
}
