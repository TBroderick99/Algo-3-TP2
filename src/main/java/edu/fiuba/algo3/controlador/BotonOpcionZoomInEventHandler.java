package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.BotonOpcion;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonOpcionZoomInEventHandler implements EventHandler<MouseEvent> {
    private BotonOpcion boton;

    public BotonOpcionZoomInEventHandler(BotonOpcion boton){
        this.boton = boton;
    }

    @Override
    public void handle(MouseEvent t) {
        boton.zoomIn();
    }
}
