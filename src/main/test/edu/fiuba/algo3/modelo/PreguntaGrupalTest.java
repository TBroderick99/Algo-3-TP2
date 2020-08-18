package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.PreguntaGrupal;
import edu.fiuba.algo3.modelo.preguntas.Puntaje;
import edu.fiuba.algo3.modelo.preguntas.PuntajeClasico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PreguntaGrupalTest {

    @Test
    public void test01PreguntaGrupalCon2GruposY4OpcionesJugadorAsignaTodasLasOpcionesASuGrupoCorrecto(){
        //Arrange
        Jugador jugador1 = new Jugador("Jose");

        Puntaje puntaje = new PuntajeClasico();
        String textoPregunta = "A que grupo pertenecen las siguientes opciones?";

        Grupo grupoFrutas = new Grupo("Frutas", 1);
        Grupo grupoVegetales = new Grupo("Vegetales", 2);

        Opcion opcionTomate = new Opcion("tomate", new Valor(grupoFrutas));
        Opcion opcionLechuga = new Opcion("lechuga", new Valor(grupoVegetales));
        Opcion opcionBerenjena = new Opcion("berenjena", new Valor(grupoVegetales));
        Opcion opcionSandia = new Opcion("sandia", new Valor(grupoFrutas));

        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcionTomate, opcionLechuga, opcionBerenjena, opcionSandia));

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);

        respuestaJugador1.marcar(opcionTomate,new Valor(grupoFrutas));
        respuestaJugador1.marcar(opcionLechuga,new Valor(grupoVegetales));
        respuestaJugador1.marcar(opcionBerenjena,new Valor(grupoVegetales));
        respuestaJugador1.marcar(opcionSandia,new Valor(grupoFrutas));


        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(1, jugador1.getPuntaje());

    }

    @Test
    public void test02PreguntaGrupalCon2GruposY6OpcionesJugadorAsignaAlgunasOpcionesASuGrupoCorrecto(){
        //Arrange
        Jugador jugador1 = new Jugador("Jose");

        Puntaje puntaje = new PuntajeClasico();
        String textoPregunta = "A que grupo pertenecen las siguientes opciones?";

        Grupo grupoFrutas = new Grupo("Frutas", 1);
        Grupo grupoVegetales = new Grupo("Vegetales", 2);

        Opcion opcionTomate = new Opcion("tomate", new Valor(grupoFrutas));
        Opcion opcionLechuga = new Opcion("lechuga", new Valor(grupoVegetales));
        Opcion opcionBerenjena = new Opcion("berenjena", new Valor(grupoVegetales));
        Opcion opcionSandia = new Opcion("sandia", new Valor(grupoFrutas));
        Opcion opcionBanana = new Opcion("banana", new Valor(grupoFrutas));
        Opcion opcionPapaya = new Opcion("papaya", new Valor(grupoFrutas));

        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcionTomate, opcionLechuga, opcionBerenjena, opcionSandia, opcionBanana, opcionPapaya));

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);

        respuestaJugador1.marcar(opcionTomate,new Valor(grupoVegetales));
        respuestaJugador1.marcar(opcionLechuga,new Valor(grupoVegetales));
        respuestaJugador1.marcar(opcionBerenjena,new Valor(grupoVegetales));
        respuestaJugador1.marcar(opcionSandia,new Valor(grupoFrutas));
        respuestaJugador1.marcar(opcionBanana,new Valor(grupoVegetales));
        respuestaJugador1.marcar(opcionPapaya,new Valor(grupoVegetales));

        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(0, jugador1.getPuntaje());

    }

    @Test
    public void test03PreguntaGrupalJugadorAsignaTodasLasOpcionesASuGruposIncorrectos(){
        //Arrange
        Jugador jugador1 = new Jugador("Jose");

        Puntaje puntaje = new PuntajeClasico();
        String textoPregunta = "A que grupo pertenecen las siguientes opciones?";

        Grupo grupoFrutas = new Grupo("Frutas", 1);
        Grupo grupoVegetales = new Grupo("Vegetales", 2);

        Opcion opcionTomate = new Opcion("tomate", new Valor(grupoFrutas));
        Opcion opcionLechuga = new Opcion("lechuga", new Valor(grupoVegetales));
        Opcion opcionBerenjena = new Opcion("berenjena", new Valor(grupoVegetales));
        Opcion opcionSandia = new Opcion("sandia", new Valor(grupoFrutas));
        Opcion opcionBanana = new Opcion("banana", new Valor(grupoFrutas));

        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcionTomate, opcionLechuga, opcionBerenjena, opcionSandia, opcionBanana));

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);

        respuestaJugador1.marcar(opcionTomate,new Valor(grupoVegetales));
        respuestaJugador1.marcar(opcionLechuga,new Valor(grupoFrutas));
        respuestaJugador1.marcar(opcionBerenjena,new Valor(grupoFrutas));
        respuestaJugador1.marcar(opcionSandia,new Valor(grupoVegetales));
        respuestaJugador1.marcar(opcionBanana,new Valor(grupoVegetales));

        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(0, jugador1.getPuntaje());

    }

    @Test
    public void test04PreguntaGrupalCon3GruposY6OpcionesJugadorAsignaTodasLasOpcionesASuGrupoCorrecto(){
        //Arrange
        Jugador jugador1 = new Jugador("Jose");

        Puntaje puntaje = new PuntajeClasico();
        String textoPregunta = "A que grupo pertenecen las siguientes opciones?";

        Grupo grupoFrutas = new Grupo("Frutas", 1);
        Grupo grupoVegetales = new Grupo("Vegetales", 2);
        Grupo grupoChocolates = new Grupo("Chocolates", 3);

        Opcion opcionTomate = new Opcion("tomate", new Valor(grupoFrutas));
        Opcion opcionLechuga = new Opcion("lechuga", new Valor(grupoVegetales));
        Opcion opcionBerenjena = new Opcion("berenjena", new Valor(grupoVegetales));
        Opcion opcionSandia = new Opcion("sandia", new Valor(grupoFrutas));
        Opcion opcionMilka = new Opcion("milka", new Valor(grupoChocolates));
        Opcion opcionAguila = new Opcion("aguila", new Valor(grupoChocolates));

        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcionTomate, opcionLechuga, opcionBerenjena, opcionSandia, opcionMilka, opcionAguila));

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);

        respuestaJugador1.marcar(opcionTomate,new Valor(grupoFrutas));
        respuestaJugador1.marcar(opcionLechuga,new Valor(grupoVegetales));
        respuestaJugador1.marcar(opcionBerenjena,new Valor(grupoVegetales));
        respuestaJugador1.marcar(opcionSandia,new Valor(grupoFrutas));
        respuestaJugador1.marcar(opcionMilka,new Valor(grupoChocolates));
        respuestaJugador1.marcar(opcionAguila,new Valor(grupoChocolates));


        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(1, jugador1.getPuntaje());

    }
    @Test
    public void test05PreguntaGrupalCon3GruposY6OpcionesJugadorAsignaTodasLasOpcionesASuGrupoCorrecto(){
        //Arrange
        Jugador jugador1 = new Jugador("Jose");

        Puntaje puntaje = new PuntajeClasico();
        String textoPregunta = "A que grupo pertenecen las siguientes opciones?";

        Grupo grupoFrutas = new Grupo("Frutas", 1);
        Grupo grupoVegetales = new Grupo("Vegetales", 2);
        Grupo grupoChocolates = new Grupo("Chocolates", 3);

        Opcion opcionTomate = new Opcion("tomate", new Valor(grupoFrutas));
        Opcion opcionLechuga = new Opcion("lechuga", new Valor(grupoVegetales));
        Opcion opcionBerenjena = new Opcion("berenjena", new Valor(grupoVegetales));
        Opcion opcionSandia = new Opcion("sandia", new Valor(grupoFrutas));
        Opcion opcionMilka = new Opcion("milka", new Valor(grupoChocolates));
        Opcion opcionAguila = new Opcion("aguila", new Valor(grupoChocolates));

        ArrayList<Opcion> opciones = new ArrayList<>(Arrays.asList(opcionTomate, opcionLechuga, opcionBerenjena, opcionSandia, opcionMilka, opcionAguila));

        ArrayList<Grupo> grupos = new ArrayList<>(Arrays.asList(grupoFrutas, grupoChocolates, grupoVegetales));

        Pregunta pregunta = new PreguntaGrupal(textoPregunta, opciones, puntaje, "dummyText", grupos);

        Respuesta respuestaJugador1 = new Respuesta(jugador1, pregunta);

        respuestaJugador1.marcar(opcionTomate,new Valor(grupoFrutas));
        respuestaJugador1.marcar(opcionLechuga,new Valor(grupoVegetales));
        respuestaJugador1.marcar(opcionBerenjena,new Valor(grupoVegetales));
        respuestaJugador1.marcar(opcionSandia,new Valor(grupoFrutas));
        respuestaJugador1.marcar(opcionMilka,new Valor(grupoChocolates));
        respuestaJugador1.marcar(opcionAguila,new Valor(grupoChocolates));


        ArrayList<Respuesta> respuestasJugadores = new ArrayList<Respuesta>();
        respuestasJugadores.add(respuestaJugador1);

        //Act
        pregunta.asignarPuntajes(respuestasJugadores);

        //Assert
        assertEquals(1, jugador1.getPuntaje());

    }

    @Test
    public void test06PreguntaGrupalGuardaCorrectamenteLosGrupos() {
        Puntaje puntaje = new PuntajeClasico();
        String textoPregunta = "A que grupo pertenecen las siguientes opciones?";

        Grupo grupoFrutas = new Grupo("Frutas", 1);
        Grupo grupoVegetales = new Grupo("Vegetales", 2);
        Grupo grupoChocolates = new Grupo("Chocolates", 3);

        ArrayList<Opcion> opciones = new ArrayList<>();

        ArrayList<Grupo> grupos = new ArrayList<>(Arrays.asList(grupoFrutas, grupoChocolates, grupoVegetales));

        Pregunta pregunta = new PreguntaGrupal(textoPregunta, opciones, puntaje, "dummyText", grupos);
        assertEquals(grupos, pregunta.getGrupos());
    }
}
