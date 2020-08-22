package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.PuntajeSorter;
import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteRondaError;
import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteTurnoError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.ContenedorFinalPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

public class BotonEnviarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Partida partida;

    public BotonEnviarEventHandler(Stage stage, Partida partida){
        this.stage = stage;
        this.partida = partida;

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ControladorTimer.cancelarTimer();
        ControladorTimer.iniciarTimer(stage, partida);
        BotonMarcarRespuestaOrdenadaEventHandler.reiniciarContador();
        partida.enviarRespuesta();
        try {
            partida.siguienteTurno();
        }
        catch (NoHaySiguienteTurnoError turnoError) {
            partida.asignarPuntajes();
            try {
                partida.siguienteRonda();
            }
            catch (NoHaySiguienteRondaError rondaError) {
                ArrayList<Jugador> jugadores = partida.getJugadores();
                jugadores.sort(new PuntajeSorter());
                stage.setScene(new Scene(new ContenedorFinalPartida(stage, jugadores ), 500, 700));
            }
        }
    }

}

