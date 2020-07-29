package edu.fiuba.algo3.modelo.Respuesta;

import edu.fiuba.algo3.modelo.opciones.OpcionVerdaderoFalso;
import edu.fiuba.algo3.modelo.selecciones.SeleccionVerdaderoFalso;
import java.util.ArrayList;

public class RespuestaVerdaderoFalso extends Respuesta{

    private ArrayList<SeleccionVerdaderoFalso> selecciones;


    public RespuestaVerdaderoFalso(){
        selecciones = new ArrayList<SeleccionVerdaderoFalso>();
    }

    public void agregarSeleccion(OpcionVerdaderoFalso opcion){       //TO DO: pasar a privado
        SeleccionVerdaderoFalso seleccion = new SeleccionVerdaderoFalso(opcion);
        selecciones.add(seleccion);
    }

    public void marcar(int posicion){
        selecciones.get(posicion).seleccionar();

    }

    public ArrayList<SeleccionVerdaderoFalso> getSelecciones(){
        return selecciones;
    }

}
