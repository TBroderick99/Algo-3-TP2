package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.ContenedorIngresoJugadores;
import edu.fiuba.algo3.vista.ContenedorInicio;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {

/*        Partida partida = Partida.getInstance();
        partida.agregarJugador("jugador1");
        partida.agregarJugador("jugador2");
        partida.inicializarPartida();
*/
        Scene escenaIngresoJugadores = new Scene(new ContenedorIngresoJugadores(stage),500,700);
    //    Scene escenaPrincipal = new Scene(new ContenedorPrincipal(stage), 1020,768);
        Scene escenaInicio = new Scene(new ContenedorInicio(stage, escenaIngresoJugadores), 500,700);

        stage.setTitle("Kahoot!");
        stage.getIcons().add(new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenes/icon.jpg"));
        stage.setScene(escenaInicio);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}