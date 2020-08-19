package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.vista.BotonOpcion;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class BotonOpcionZoomOutEventHandler implements EventHandler<MouseEvent> {
    private BotonOpcion boton;

    public BotonOpcionZoomOutEventHandler(BotonOpcion boton){
        this.boton = boton;
    }
    
    @Override
    public void handle(MouseEvent t) {
        boton.zoomOut();
    }
}




