package edu.fiuba.algo3.modelo.preguntas;


import edu.fiuba.algo3.modelo.Excepciones.FalloAlLeerRespuestaArchivoError;
import edu.fiuba.algo3.modelo.Excepciones.FalloLaInicializacionDelArchivoError;
import edu.fiuba.algo3.modelo.Valor;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CreadorDePreguntas {

    public static ArrayList<Pregunta> crearPreguntas() {
        ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();

        preguntas.addAll(cargarPreguntasVoF());
//      preguntas.addAll(cargarPreguntasOrdered());
//      preguntas.addAll(cargarPreguntasGroup());

        return preguntas;
    }

    private static ArrayList<Opcion> parsearOpcionesVoF(String textoOpciones, String textoOpcionesCorrectas) {
        ArrayList<Opcion> opciones = new ArrayList<Opcion>();
        Opcion opcion;

        List<String> arrayTextoOpciones= Arrays.asList(textoOpciones.split("-"));

        for (String textoOpcion: arrayTextoOpciones){
            opcion = new Opcion(textoOpcion, new Valor(textoOpcionesCorrectas.contains(textoOpcion)) );
            opciones. add(opcion);
        }

        return opciones;
    }

    private static ArrayList<Pregunta> cargarPreguntasVoF(){
        /*  FORMATO ARCHIVO
            TipoPuntaje ; TextoPregunta ; Opciones ; OpcionesCorrectas

            FORMATO OPCIONES
            Opcion1 - Opcion2 - Opcion3 ...

            EJEMPLOS
            clasico;La UBA fue fundada en el año 1821;Verdadero-Falso;Verdadero
            conPenalidad;En qué año fue fundada la UBA?;1876-1816-1821-1913;1821
         */

        FileReader archivo = null;
        BufferedReader lector = null;

        ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();
        try {
            archivo = new FileReader("preguntasEleccionSimple.txt");

            if(archivo.ready()) {
                lector = new BufferedReader(archivo);
                String lineaEntera ;
                String[] separadoPorComas;

                while ((lineaEntera = lector.readLine()) != null) {
                    separadoPorComas = lineaEntera.split(";");

                    ArrayList<Opcion> opciones = parsearOpcionesVoF(separadoPorComas[2], separadoPorComas[3]);
                    Puntaje puntaje;
                    //Leo el TipoPuntaje
                    if (separadoPorComas[0].equals("clasico")){
                        puntaje = new PuntajeClasico();
                    }
                    else if (separadoPorComas[0].equals("parcial")){
                        puntaje = new PuntajeParcial();
                    }
                    else if (separadoPorComas[0].equals("conPenalidad")){
                        puntaje = new PuntajePenalidad();
                    }
                    else{
                        throw new FalloAlLeerRespuestaArchivoError();
                    }

                    Pregunta pregunta = new Pregunta(separadoPorComas[1], opciones, puntaje);

                    preguntas.add(pregunta);
                }
                archivo.close();
            }
        } catch (IOException | FalloAlLeerRespuestaArchivoError e) {
            throw new FalloLaInicializacionDelArchivoError();
        }
        return preguntas;
    }

    /*private static ArrayList<PreguntaVyF> cargarPreguntasOrdered(){*/
        /*  FORMATO ARCHIVO
            TextoPregunta ; Opciones

            TIPO PUNTAJE
            Por consigna las ordered son clásicas

            FORMATO OPCIONES (El orden de aparición es el ordenamiento correcto)
            Opcion1 - Opcion2 - Opcion3 ...
            Precondición por consigna: Son desde 2 hasta 5 opciones.

            EJEMPLOS
            clasico;La UBA fue fundada en el año 1821;Verdadero-Falso;Verdadero
            conPenalidad;En qué año fue fundada la UBA?;1876-1816-1821-1913;1821
         */

        /*FileReader archivo = null;
        BufferedReader lector = null;

        ArrayList<PreguntaVyF> preguntas = new ArrayList<PreguntaVyF>();
        try {
            archivo = new FileReader("preguntasOrdered.txt");

            if(archivo.ready()) {
                lector = new BufferedReader(archivo);
                String lineaEntera ;
                String[] separadoPorComas;

                while ((lineaEntera = lector.readLine()) != null) {
                    separadoPorComas = lineaEntera.split(";");

                    ArrayList<OpcionVerdaderoFalso> opciones = parsearOpcionesOrdered(separadoPorComas[2]);
                    Puntaje puntaje = new PuntajeClasico();

                    PreguntaVyF pregunta = new PreguntaVyF(separadoPorComas[0], opciones, puntaje);

                    preguntas.add(pregunta);
                }
                archivo.close();
            }
        } catch (IOException | FalloAlLeerRespuestaArchivoError e) {
            throw new FalloLaInicializacionDelArchivoError();
        }
        return preguntas;
    }

    private static ArrayList<OpcionVerdaderoFalso> parsearOpcionesOrdered(String separadoPorComa) {
        // TO DO
        return new ArrayList<OpcionVerdaderoFalso>();
    }
*/}
