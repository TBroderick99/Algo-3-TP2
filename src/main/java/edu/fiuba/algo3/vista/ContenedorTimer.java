package edu.fiuba.algo3.vista;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class ContenedorTimer extends VBox {
    public ContenedorTimer(){
        Text titulo = new TextoClaro("Tiempo restante:", 30);

        HBox tiempo = new HBox();

        Text contador = new TextoClaro("60", 30); // Obtener el tiempo con un getter desde el modelo
        Text textoSegundos = new TextoClaro(" segundos", 30);

        tiempo.getChildren().addAll(contador, textoSegundos);

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
