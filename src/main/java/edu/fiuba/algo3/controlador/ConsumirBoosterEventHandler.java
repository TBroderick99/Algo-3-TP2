package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Booster;
import edu.fiuba.algo3.modelo.Partida;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

    public abstract class ConsumirBoosterEventHandler implements EventHandler {
        private Button boton;
        public ConsumirBoosterEventHandler(Button boton){
            this.boton = boton;
        }

        @Override
        public void handle(Event event) {
            Partida.getInstance().getJugadorActual().consumirBooster(
                    Partida.getInstance().getRonda().getTurnoActual().getRespuesta(),
                    consumirBooster()
            );
            boton.setDisable(true);
        }

        public abstract Booster consumirBooster();
    }
