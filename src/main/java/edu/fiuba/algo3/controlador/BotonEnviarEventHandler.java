package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Excepciones.NoHaySiguienteRondaError;
import edu.fiuba.algo3.modelo.Excepciones.NoHaySiguienteTurnoError;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.vista.ContenedorFinalPartida;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEnviarEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private Partida partida;

    public BotonEnviarEventHandler(Stage stage, Partida partida){
        this.stage = stage;
        this.partida = partida;

    }

    @Override
    public void handle(ActionEvent actionEvent) {

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
                stage.setScene(new Scene(new ContenedorFinalPartida()));
            }
        }
    }

}
