package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Valor;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.vista.BotonOpcion;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public abstract class BotonMarcarEventHandler implements EventHandler {

    protected Respuesta respuesta;
    protected Opcion opcion;
    protected Button botonEnviar;
    protected BotonOpcion botonOpcion;
    protected VBox botones;

    public BotonMarcarEventHandler(Respuesta respuesta, Opcion opcion, BotonOpcion botonOpcion, VBox botones, Button botonEnviar){
        this.respuesta = respuesta;
        this.opcion = opcion;
        this.botonEnviar = botonEnviar;
        this.botonOpcion = botonOpcion;
        this.botones = botones;
    }

    public void marcarDesmarcar(Valor valor){
        if (respuesta.fueMarcada(opcion)) {
            respuesta.desmarcar(opcion);
            botonOpcion.desmarcar();
        }
        else {
            respuesta.marcar(opcion, valor);
            botonOpcion.marcar();
        }
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
