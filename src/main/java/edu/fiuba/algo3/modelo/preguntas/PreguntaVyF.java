package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Respuesta.RespuestaVerdaderoFalso;
import edu.fiuba.algo3.modelo.opciones.OpcionVerdaderoFalso;
import java.util.ArrayList;

public class PreguntaVyF extends Pregunta {

    protected ArrayList<OpcionVerdaderoFalso> opciones;

    public PreguntaVyF(String textoPregunta, ArrayList<OpcionVerdaderoFalso> opciones, Puntaje puntaje){
        this.textoPregunta = textoPregunta;
        this.opciones = opciones;
        this.puntaje = puntaje;

    }

    public RespuestaVerdaderoFalso crearRespuesta(){
        RespuestaVerdaderoFalso respuesta = new RespuestaVerdaderoFalso();
        opciones.forEach(opcion -> respuesta.agregarSeleccion(opcion));
        //for(int i = 0; i < opciones.size() ; i++){
        //    respuesta.agregarSeleccion(opciones.get(i));
        //}

        return respuesta;
    }

    public ArrayList<OpcionVerdaderoFalso> getOpcionesCorrectas() {

        ArrayList<OpcionVerdaderoFalso> opcionesCorrectas = new ArrayList<>();
        opciones.stream()
                .filter(opcion -> opcion.esCorrecta())
                .forEach(opcionCorrecta -> opcionesCorrectas.add(opcionCorrecta));
        //for (OpcionVerdaderoFalso opcion : this.opciones) {
        //    if (opcion.esCorrecta()) {
        //        opcionesCorrectas.add(opcion);
        //    }
        //}
        return opcionesCorrectas;
    }

    public ArrayList<OpcionVerdaderoFalso> getOpciones(){
            return opciones;
        }

}
