package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.preguntas.boosters.Booster;
import edu.fiuba.algo3.modelo.Turno;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

    public abstract class ConsumirBoosterEventHandler implements EventHandler {
        private Button boton;
        protected Turno turnoActual;

        public ConsumirBoosterEventHandler(Button boton, Turno turnoActual){

            this.boton = boton;
            this.turnoActual = turnoActual;
        }

        @Override
        public void handle(Event event) {
            turnoActual.getJugador().consumirBooster(
                    turnoActual.getRespuesta(),
                    consumirBooster()
            );
            boton.setDisable(true);
        }

        public abstract Booster consumirBooster();
    }
