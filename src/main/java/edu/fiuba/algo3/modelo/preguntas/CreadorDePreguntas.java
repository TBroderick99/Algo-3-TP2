package edu.fiuba.algo3.modelo.preguntas;

import edu.fiuba.algo3.modelo.opciones.OpcionVerdaderoFalso;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class CreadorDePreguntas {

    public static ArrayList<Pregunta> crearPreguntas() {
        ArrayList<Pregunta> preguntas = new ArrayList<>();
        FileReader archivo = null;
        BufferedReader lector = null;


        Puntaje puntaje = new PuntajeClasico();

        OpcionVerdaderoFalso opcion1 = new OpcionVerdaderoFalso("Rojo", false);
        OpcionVerdaderoFalso opcion2 = new OpcionVerdaderoFalso("Verde", false);
        OpcionVerdaderoFalso opcion3 = new OpcionVerdaderoFalso("Amarillo", false);
        OpcionVerdaderoFalso opcion4 = new OpcionVerdaderoFalso("Negro", true);

        ArrayList<OpcionVerdaderoFalso> opciones = new ArrayList<OpcionVerdaderoFalso>();
        opciones.add(opcion1);
        opciones.add(opcion2);
        opciones.add(opcion3);
        opciones.add(opcion4);

        PreguntaVyF pregunta = new PreguntaVyF("Cual color es mas ocuro", opciones, puntaje);

        preguntas.add(pregunta);


        /*
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
                    if (separadoPorComas[5].equals("verdaderoYFalso")){
                        PreguntaVyF pregunta = new PreguntaVyF();
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
                    pregunta = new Pregunta(separadoPorComas[1], opciones, respuesta);

                    preguntas.add(pregunta);
                }
                archivo.close();
            }
        } catch (IOException | FalloAlLeerRespuestaArchivoError e) {
            throw new FalloLaInicializacionDelArchivoError();
        }

         */

        return preguntas;
    }

    private static String[] parsearOpciones(String opciones) {
        return opciones.split("-");
    }



}
