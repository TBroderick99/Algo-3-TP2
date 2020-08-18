package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public abstract class BotonMarcarEventHandler implements EventHandler {

    protected Respuesta respuesta;
    protected Opcion opcion;
    protected Button botonEnviar;

    public BotonMarcarEventHandler(Respuesta respuesta, Opcion opcion, Button botonEnviar){
        this.respuesta = respuesta;
        this.opcion = opcion;
        this.botonEnviar = botonEnviar;
    }

    public void actualizarBotonEnviar(){

        if (respuesta.tieneAlgunaMarcada()){
            botonEnviar.setDisable(false);
        }
        else{
            botonEnviar.setDisable(true);
        }
    }
}
