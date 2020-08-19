package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class ContenedorRespuestasMarcadas extends VBox implements Observer {
    private Respuesta respuesta;
    public ContenedorRespuestasMarcadas(Respuesta respuesta){
        this.respuesta = respuesta;
        respuesta.addObserver(this);
        mostrarMarcadas();
    }

    public void mostrarMarcadas(){
        this.getChildren().clear();
        TextoClaro textoRespuestasMarcadas = new TextoClaro("Respuestas marcadas:", 30);

        HBox sectorOpcionesMarcadas = new HBox();
        sectorOpcionesMarcadas.setSpacing(20);
        for(Opcion opcion: respuesta.getOpcionesMarcadas()){
            TextoClaro opcionMarcada = new TextoClaro(opcion.getTexto(),30);
            sectorOpcionesMarcadas.getChildren().add(opcionMarcada);
        }

        this.getChildren().addAll(textoRespuestasMarcadas, sectorOpcionesMarcadas);
    }

    @Override
    public void change() {
        mostrarMarcadas();
    }
}
