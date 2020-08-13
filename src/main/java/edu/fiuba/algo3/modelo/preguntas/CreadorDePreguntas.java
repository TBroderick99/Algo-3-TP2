package edu.fiuba.algo3.modelo.preguntas;


import edu.fiuba.algo3.modelo.Excepciones.FalloAlLeerRespuestaArchivoError;
import edu.fiuba.algo3.modelo.Excepciones.FalloLaInicializacionDelArchivoError;
import edu.fiuba.algo3.modelo.Grupo;
import edu.fiuba.algo3.modelo.Valor;
import edu.fiuba.algo3.modelo.opciones.Opcion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class CreadorDePreguntas {

    public static ArrayList<Pregunta> crearPreguntas() {
        ArrayList<Pregunta> preguntas = new ArrayList<>();

        preguntas.addAll(cargarPreguntasVoF());
        preguntas.addAll(cargarPreguntasOrdered());
        preguntas.addAll(cargarPreguntasGroup());

    //    Collections.shuffle(preguntas);

        return preguntas;
    }

    private static ArrayList<Pregunta> cargarPreguntasGroup() {
        /*  FORMATO ARCHIVO
            TextoPregunta ; Opciones

            TIPO PUNTAJE
            Por consigna las group son clásicas

            FORMATO OPCIONES
            Grupo1 | Op1 | Op2 | Op3 ~ Grupo2 ; Op4 ; Op5
            Precondición por consigna: Son desde 2 hasta 5 opciones.

            EJEMPLOS
            A que grupo pertenecen las siguientes opciones;Frutas|Tomate|Sandia~Banana|Verduras|Lechuga|Berenjena
         */

        FileReader archivo;
        BufferedReader lector;

        ArrayList<Pregunta> preguntas = new ArrayList<>();
        try {
            archivo = new FileReader("preguntasGrupal.txt");

            if(archivo.ready()) {
                lector = new BufferedReader(archivo);
                String lineaEntera ;
                String[] separadoPorComas;

                while ((lineaEntera = lector.readLine()) != null) {
                    separadoPorComas = lineaEntera.split(";");

                    String[] arrayTextoOpciones = separadoPorComas[1].split("~");
                    ArrayList<Grupo> grupos = new ArrayList<>();
                    ArrayList<Opcion> opciones = parsearOpcionesGrupal(arrayTextoOpciones, grupos);
                    Puntaje puntaje = new PuntajeClasico();

                    Pregunta pregunta = new PreguntaGrupal(separadoPorComas[0], opciones, puntaje, grupos);

                    preguntas.add(pregunta);
                }
                archivo.close();
            }
        } catch (IOException | FalloAlLeerRespuestaArchivoError e) {
            throw new FalloLaInicializacionDelArchivoError();
        }
        return preguntas;
    }

    private static ArrayList<Opcion> parsearOpcionesGrupal(String[] arrayTextoOpciones, ArrayList<Grupo> grupos) {
        ArrayList<Opcion> opciones = new ArrayList<>();
        Opcion opcion;

        Grupo grupo;
        int i = 0;
        for (String textoOpcion: arrayTextoOpciones){
            i++;
            String[] arrayTextoOpcion = textoOpcion.split("\\|");
            grupo = new Grupo(arrayTextoOpcion[0], i);
            grupos.add(grupo);
            for (int j = 1; j < arrayTextoOpcion.length; j++){
                opcion = new Opcion(arrayTextoOpcion[j], new Valor(grupo));
                opciones.add(opcion);
            }
        }

        return opciones;
    }


    /*private static ArrayList<Grupo> parsearGrupos(String[] arrayTextoOpciones) {
        ArrayList<Grupo> grupos = new ArrayList<>();
        Grupo grupo;

        int i = 0;
        for (String textoOpcion: arrayTextoOpciones){
            i++;
            String[] arrayTextoOpcion = textoOpcion.split("\\|");
            grupo = new Grupo(arrayTextoOpcion[0], i);
            grupos.add(grupo);
        }

        return grupos;
    }*/


    private static ArrayList<Opcion> parsearOpcionesVoF(String textoOpciones, String textoOpcionesCorrectas) {
        ArrayList<Opcion> opciones = new ArrayList<>();
        Opcion opcion;

        String[] arrayTextoOpciones = textoOpciones.split("-");

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

        FileReader archivo;
        BufferedReader lector;

        ArrayList<Pregunta> preguntas = new ArrayList<>();
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
                    switch (separadoPorComas[0]) {
                        case "clasico":
                            puntaje = new PuntajeClasico();
                            break;
                        case "parcial":
                            puntaje = new PuntajeParcial();
                            break;
                        case "conPenalidad":
                            puntaje = new PuntajePenalidad();
                            break;
                        default:
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

    private static ArrayList<Pregunta> cargarPreguntasOrdered(){
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

        FileReader archivo;
        BufferedReader lector;

        ArrayList<Pregunta> preguntas = new ArrayList<>();
        try {
            archivo = new FileReader("preguntasOrdered.txt");

            if(archivo.ready()) {
                lector = new BufferedReader(archivo);
                String lineaEntera ;
                String[] separadoPorComas;

                while ((lineaEntera = lector.readLine()) != null) {
                    separadoPorComas = lineaEntera.split(";");

                    ArrayList<Opcion> opciones = parsearOpcionesOrdered(separadoPorComas[1]);
                    Puntaje puntaje = new PuntajeClasico();

                    Pregunta pregunta = new Pregunta(separadoPorComas[0], opciones, puntaje);

                    preguntas.add(pregunta);
                }
                archivo.close();
            }
        } catch (IOException | FalloAlLeerRespuestaArchivoError e) {
            throw new FalloLaInicializacionDelArchivoError();
        }
        return preguntas;
    }

    private static ArrayList<Opcion> parsearOpcionesOrdered(String textoOpciones) {
        ArrayList<Opcion> opciones = new ArrayList<>();
        Opcion opcion;

        String[] arrayTextoOpciones = textoOpciones.split("-");

        int i = 0;
        for (String textoOpcion: arrayTextoOpciones){
            i++;
            opcion = new Opcion(textoOpcion, new Valor(i));
            opciones.add(opcion);
        }

        return opciones;
    }
}
