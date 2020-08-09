package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.ContenedorIngresoJugadores;
import edu.fiuba.algo3.vista.ContenedorInicio;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

        Partida partida = Partida.getInstance();
        partida.agregarJugadores("jugador1", "jugador2");


        Scene escenaIngresoJugadores = new Scene(new ContenedorIngresoJugadores(stage),500,700);
        Scene escenaInicio = new Scene(new ContenedorInicio(stage, escenaIngresoJugadores), 500,700);
//        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, partida);

        stage.setTitle("Kahoot!");
        stage.setScene(escenaInicio);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}