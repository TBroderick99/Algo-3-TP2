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

    public static void iniciarTimer(Stage stage, Partida partida, final long delay){
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
                            stage.setScene(new Scene(new ContenedorFinalPartida()));
                        }
                    }
                    ControladorTimer.cancelarTimer();
                });
            }
        }, delay);
    }

    public static void cancelarTimer(){
        timer.cancel();
    }
}