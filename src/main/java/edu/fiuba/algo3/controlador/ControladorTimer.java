package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteRondaError;
import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteTurnoError;
import edu.fiuba.algo3.vista.ContenedorFinalPartida;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Timer;
import java.util.TimerTask;

public class ControladorTimer {
    private static Timer timer;
    private static final long DELAY_MILIS = 30000;
    public static void iniciarTimer(Stage stage, Partida partida){
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                // Esto es copy paste de lo que hace BotonEnviarEventHandler
                Platform.runLater(() -> {
                    partida.enviarRespuesta();
                    try {
                        partida.siguienteTurno();
                    }
                    catch (NoHaySiguienteTurnoError turnoError) {
                        partida.asignarPuntajes();
                        try {
                            partida.siguienteRonda();
                        } catch (NoHaySiguienteRondaError rondaError) {
                            stage.setScene(new Scene(new ContenedorFinalPartida(stage, partida.getJugadores()), 500, 700));
                        }
                    }
                    ControladorTimer.cancelarTimer();
                    ControladorTimer.iniciarTimer(stage, partida);
                });
            }
        }, DELAY_MILIS);
    }

    public static void cancelarTimer(){
        if (timer != null)
            timer.cancel();
    }

    public static long getDelay() {
        return DELAY_MILIS;
    }
}