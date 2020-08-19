package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import javafx.geometry.Orientation;
import javafx.scene.control.Separator;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

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

        Separator separador = new Separator();
        separador.setOrientation(Orientation.HORIZONTAL);

        TextoClaro textoRespuestasMarcadas = new TextoClaro("Respuestas marcadas:", 30);

        HBox sectorOpcionesMarcadas = new HBox();
        sectorOpcionesMarcadas.setSpacing(20);
        for(Opcion opcion: respuesta.getOpcionesMarcadas()){
            TextoClaro opcionMarcada = new TextoClaro(opcion.getTexto(),30);
            opcionMarcada.setFill(Color.web("333A56"));
            sectorOpcionesMarcadas.getChildren().add(opcionMarcada);
        }

        this.getChildren().addAll(separador, textoRespuestasMarcadas, sectorOpcionesMarcadas);
    }

    @Override
    public void change() {
        mostrarMarcadas();
    }
}
