package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.modelo.Observer;
import edu.fiuba.algo3.modelo.Partida;
import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane implements Observer {

    private Stage stage;
    private Partida partida;

    public ContenedorPrincipal(Stage stage, Partida partida) {
        super();
        this.stage = stage;
        this.partida = partida;
    //    this.setPadding(new Insets(0,20,20,20));

        partida.addObserver(this);
        actualizarVista();
    }

    private void actualizarVista() {
        VBox opciones;
        switch (partida.getPreguntaActual().getTipoPregunta()) {
            case "Ordenada":
                opciones = new ContenedorOpcionesRespuestaOrdenada(stage, partida);
                break;
            case "Grupal":
                opciones = new ContenedorOpcionesRespuestaGrupal(stage, partida);
                break;
            case "Multiple":
                opciones = new ContenedorOpcionesRespuestaMultiple(stage, partida);
                break;
            default: // Acá entra Verdadero o Falso
                opciones = new ContenedorOpcionesRespuestaUnica(stage, partida);
        }


        VBox sectorIzquierda = new VBox();
        sectorIzquierda.setPadding(new Insets(10,10,10,10));
        sectorIzquierda.setSpacing(300);
        sectorIzquierda.setPrefWidth(400);
        sectorIzquierda.setBackground(new Background(new BackgroundFill(Color.web("F7F5E6"), CornerRadii.EMPTY, Insets.EMPTY)));

        VBox sectorInformacion = new ContenedorInformacion(partida);

        BorderPane contenedorCentral = new BorderPane();
        ContenedorPregunta pregunta = new ContenedorPregunta(stage, partida);
        ContenedorRespuestasMarcadas respuestasMarcadas = new ContenedorRespuestasMarcadas(partida.getRonda().getTurnoActual().getRespuesta());
        contenedorCentral.setTop(pregunta);
        contenedorCentral.setCenter(opciones);
        contenedorCentral.setBottom(respuestasMarcadas);

        ContenedorBoosters sectorBooster = new ContenedorBoosters(partida);

        sectorIzquierda.getChildren().addAll(sectorInformacion, sectorBooster);

        this.setLeft(sectorIzquierda);
        this.setCenter(contenedorCentral);
    }


    @Override
    public void change() {
        actualizarVista();
    }
}
