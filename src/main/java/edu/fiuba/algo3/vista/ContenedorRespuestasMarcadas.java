package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ContenedorRespuestasMarcadas extends VBox implements Observer {
    private Respuesta respuesta;
    public ContenedorRespuestasMarcadas(Respuesta respuesta){
        this.respuesta = respuesta;
        this.setMinHeight(100);
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
