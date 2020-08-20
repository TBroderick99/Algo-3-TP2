package edu.fiuba.algo3.vista;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TextoBeige extends Text {

    public TextoBeige(String texto, int tamanio){
        super(texto);
        this.setFont(Font.font("Calibri", FontWeight.BOLD,tamanio));
        this.setFill(Color.web("F7F5E6"));
    }
}
