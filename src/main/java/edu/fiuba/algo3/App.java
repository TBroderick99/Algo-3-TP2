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

        Scene escenaInicio = new Scene(new ContenedorInicio(stage), 500,700);

        stage.setTitle("Kahoot!");
        stage.getIcons().add(new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenes/icon.jpg"));
        stage.setScene(escenaInicio);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}