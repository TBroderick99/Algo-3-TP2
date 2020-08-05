package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ContenedorInicio extends VBox {
    Stage stage;
    public ContenedorInicio(Stage stage){
        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
     //   this.set
        Text titulo = new Text("Ingrese el nombre de cada jugador:");
        titulo.setFill(Color.PURPLE);
        titulo.setStrokeWidth(2);
        
        Button botonInicio = new Button("Inicio");

        botonInicio.setOnAction(e-> {
            stage.setScene(new Scene(new ContenedorPrincipal(stage)));
            stage.show();
        });

        Button botonComoJugar = new Button("Cómo jugar");
        Button botonAcercaDe = new Button("Acerca De");
        Button botonSalir = new Button("Salir");

        this.getChildren().addAll(titulo, botonInicio, botonComoJugar, botonAcercaDe, botonSalir);
    }

}
