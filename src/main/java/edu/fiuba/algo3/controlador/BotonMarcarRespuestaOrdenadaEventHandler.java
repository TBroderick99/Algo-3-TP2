package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Valor;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.vista.BotonOpcion;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonMarcarRespuestaOrdenadaEventHandler  extends BotonMarcarEventHandler {

    public BotonMarcarRespuestaOrdenadaEventHandler(Respuesta respuesta, Opcion opcion, BotonOpcion botonOpcion, VBox botones, Button botonEnviar){
        super(respuesta, opcion, botonOpcion, botones, botonEnviar);

    }

    @Override
    public void handle(Event event) {

        Valor valor = new Valor(true);
        marcarDesmarcar(valor);
        actualizarBotonEnviar();
    }

    @Override
    public void actualizarBotonEnviar(){
        if (respuesta.seleccionesFueronTodasMarcadas()){
            botonEnviar.setDisable(false);
        }
        else{
            botonEnviar.setDisable(true);
        }
    }
}
