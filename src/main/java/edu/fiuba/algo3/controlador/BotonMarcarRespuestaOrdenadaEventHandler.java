package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.Valor;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class BotonMarcarRespuestaOrdenadaEventHandler  extends BotonMarcarEventHandler {


    public BotonMarcarRespuestaOrdenadaEventHandler(Respuesta respuesta, Opcion opcion, Button botonEnviar){
        super(respuesta, opcion, botonEnviar);

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
