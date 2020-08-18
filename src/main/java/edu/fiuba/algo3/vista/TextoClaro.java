package edu.fiuba.algo3.vista;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class TextoClaro extends Text {
    public TextoClaro(String texto, int tamanio){
        super(texto);
        this.setFont(Font.font("Calibri", FontWeight.BOLD,tamanio));
        this.setFill(Color.web("52658F"));
    }
}
