package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonConsumirBoosterX2EventHandler implements EventHandler {
    protected int FACTOR_MULTIPLICACION;
    private Button boton;

    public BotonConsumirBoosterX2EventHandler(Button boton){
        this.FACTOR_MULTIPLICACION = 2;
        this.boton = boton;
    }
    @Override
    public void handle(Event event) {
        Partida.getInstance().getJugadorActual().consumirBooster(
                Partida.getInstance().getRonda().getTurnoActual().getRespuesta(),
                Partida.getInstance().getJugadorActual().getBoosterMultiplicador(FACTOR_MULTIPLICACION)
        );
        boton.setDisable(true);
    }
}
