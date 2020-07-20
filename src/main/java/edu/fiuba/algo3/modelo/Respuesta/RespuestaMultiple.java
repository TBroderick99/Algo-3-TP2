package edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RespuestaMultiple{

    private ArrayList<String> opciones;

    public RespuestaMultiple() {}

    public RespuestaMultiple(ArrayList<String> opciones_) {
        this.opciones = opciones_;
    }

    public ArrayList<String> getOpciones() {
        return this.opciones;
    }

    //@Override
    public ArrayList<Boolean> esCorrecta(ArrayList<String> respuestas) {
        ArrayList<Boolean> returnValue = new ArrayList<>();
        /*FIXME*/
        /*Hay que ver la forma de pasar de este for loop a lago utilizando streams + lambda expressions*/
        for (int i = 0; i < this.opciones.size(); i++) {
            returnValue.add(this.opciones.get(i).equals(respuestas.get(i)));
        }
        return returnValue;
    }
}
