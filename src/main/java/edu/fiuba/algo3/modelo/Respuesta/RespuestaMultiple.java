package edu.fiuba.algo3.modelo.Respuesta;

import java.util.ArrayList;

public class RespuestaMultiple implements IRespuesta{

    private ArrayList<String> opciones;

    public RespuestaMultiple() {}

    public RespuestaMultiple(ArrayList<String> opciones_) {
        this.opciones = opciones_;
    }

    @Override
    public ArrayList<Boolean> esCorrecta(IRespuesta respuesta) {
        /*TODO*/
        return null;
    }
}
