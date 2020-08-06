package edu.fiuba.algo3;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.modelo.Partida;
import edu.fiuba.algo3.vista.ContenedorIngresoJugadores;
import edu.fiuba.algo3.vista.ContenedorInicio;
import edu.fiuba.algo3.vista.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
   //     var javaVersion = SystemInfo.javaVersion();
   //     var javafxVersion = SystemInfo.javafxVersion();

   //     var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
   //     var scene = new Scene(new StackPane(label), 640, 480);

        Partida partida = Partida.getInstance();
        partida.agregarJugadores("jugador1", "jugador2");


 //       ContenedorInicio contenedorInicio = new ContenedorInicio(stage);
 //       ContenedorIngresoJugadores contenedorIngresoJugadores = new ContenedorIngresoJugadores(stage);
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(stage, partida);


        Scene scene = new Scene(contenedorPrincipal);
        stage.setWidth(500);
        stage.setHeight(700);
        stage.setScene(scene);
        stage.show();
    /*    try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    */

    }

    public static void main(String[] args) {
        launch();
    }

}