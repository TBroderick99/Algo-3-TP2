package edu.fiuba.algo3.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ContenedorTimer extends VBox {
    public ContenedorTimer(){
        Text titulo = new Text("Tiempo restante:");

        HBox tiempo = new HBox();

        Text contador = new Text("60"); // Obtener el tiempo con un getter desde el modelo
        Text textoSegundos = new Text(" segundos");

        tiempo.getChildren().addAll(contador, textoSegundos);

        titulo.setFont(Font.font("Calibri", FontWeight.BOLD,30));
        titulo.setFill(Color.web("333A56"));
        contador.setFont(Font.font("Calibri", FontWeight.BOLD,30));
        contador.setFill(Color.web("333A56"));
        textoSegundos.setFont(Font.font("Calibri", FontWeight.BOLD,30));
        textoSegundos.setFill(Color.web("333A56"));

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    contador.setText(Integer.toString(Integer.valueOf(contador.getText()) - 1));
                    if(Integer.valueOf(contador.getText())<=5)
                        contador.setFill(Color.RED);

                })
        );
        timeline.setCycleCount(60);
        timeline.play();

        this.getChildren().addAll(titulo, tiempo);
    }
}
