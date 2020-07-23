package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.Excepciones.FalloAlLeerRespuestaArchivoError;
import edu.fiuba.algo3.modelo.Excepciones.FalloLaInicializacionDelArchivoError;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaGrupal;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaMultiple;
import edu.fiuba.algo3.modelo.Respuesta.RespuestaSimple;
import edu.fiuba.algo3.modelo.Respuesta.TipoRespuesta;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreadorDePreguntas {

    public static ArrayList<Pregunta> crearPreguntas() {
        ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
        FileReader archivo = null;
        BufferedReader lector = null;

        try {
            archivo = new FileReader("preguntas.txt");

            if(archivo.ready()) {
                lector = new BufferedReader(archivo);
                String lineaEntera ;
                String[] separadoPorComas;

                while ((lineaEntera = lector.readLine()) != null) {
                    separadoPorComas = lineaEntera.split(";");
                    Pregunta pregunta;
                    TipoRespuesta respuesta = null;
                    String[] opciones = parsearOpciones(separadoPorComas[3]);

                    //Leo el TipoTespuesta
                    if (separadoPorComas[5].equals("simple")){
                        respuesta = new RespuestaSimple(opciones);
                    }
                    else if (separadoPorComas[5].equals("multiple")){
                        respuesta = new RespuestaMultiple(opciones);
                    }
                    else if (separadoPorComas[5].equals("grupal")){
                        respuesta = new RespuestaGrupal(opciones);
                    }
                    else{
                        throw new FalloAlLeerRespuestaArchivoError();
                    }

                    // Está casteado porque todavia no se implementó la interfaz TipoRespuesta en Pregunta.
                    pregunta = new Pregunta(separadoPorComas[1], opciones, (RespuestaSimple) respuesta);

                    preguntas.add(pregunta);
                }
                archivo.close();
            }
        } catch (IOException | FalloAlLeerRespuestaArchivoError e) {
            throw new FalloLaInicializacionDelArchivoError();
        }
        return preguntas;
    }

    private static String[] parsearOpciones(String opciones) {
        return opciones.split("-");
    }
}
