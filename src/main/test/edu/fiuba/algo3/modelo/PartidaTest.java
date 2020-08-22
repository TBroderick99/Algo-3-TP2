package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteRondaError;
import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteTurnoError;
import edu.fiuba.algo3.modelo.preguntas.CreadorDePreguntas;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.Valor;
import edu.fiuba.algo3.modelo.preguntas.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajePenalidad;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PartidaTest {

    @Test
    public void test01PartidaAgregaJugador() {
        //Arrange
        Partida partida = new Partida();

        //Act
        partida.agregarJugador("Juan");
        partida.inicializarPartida(CreadorDePreguntas.crearPreguntas());
        Jugador jugador = partida.getJugadorActual();
        String nombreJugador = jugador.getNombre();

        //Assert
        assertEquals("Juan", nombreJugador);

    }


    @Test
    public void test02TrasInicializarPartidaLaRondaEsLaNumero1yTienePreguntaInicial()  {
        //Arrange
        Partida partida = new Partida();

        partida.agregarJugador("Juan");
        partida.agregarJugador("Pedro");
        Ronda ronda = partida.getRonda();

        //Act
        partida.inicializarPartida(CreadorDePreguntas.crearPreguntas());
        int numeroDeRonda = ronda.getNumeroDeRonda();


        //Assert
        assertEquals(1, numeroDeRonda);
        assertEquals(partida.getPreguntaActual(), ronda.getPreguntaActual());

    }

    @Test
    public void test03PartidaPasaDeRonda() throws NoHaySiguienteTurnoError, NoHaySiguienteRondaError {
        //Arrange
        Partida partida = new Partida();
        partida.agregarJugador("Juan");
        partida.agregarJugador("Pedro");
        partida.inicializarPartida(CreadorDePreguntas.crearPreguntas());
        Ronda ronda = partida.getRonda();

        assertEquals(1, ronda.getNumeroDeRonda());

        partida.siguienteTurno();
        partida.siguienteRonda();

        //Act
        int numeroDeRonda = ronda.getNumeroDeRonda();
        Pregunta preguntaActual = ronda.getPreguntaActual();

        //Assert
        assertEquals(2, numeroDeRonda);
        assertEquals( partida.getPreguntaActual(), preguntaActual);
    }



    @Test
    public void test04NoSePuedePasarDelUltimoTurno() throws NoHaySiguienteTurnoError {
        //Arrange
        Partida partida = new Partida();
        partida.agregarJugador("Juan");
        partida.agregarJugador("Pedro");
        partida.inicializarPartida(CreadorDePreguntas.crearPreguntas());

        //Act

        partida.siguienteTurno();

        //Assert
        Assertions.assertThrows(NoHaySiguienteTurnoError.class, () -> {
            partida.siguienteTurno();
        });
    }

    @Test
    public void test05NoSePuedePasarDelUltimaRonda() throws NoHaySiguienteRondaError {
        //Arrange
        Partida partida = new Partida();
        partida.agregarJugador("Juan");
        partida.agregarJugador("Pedro");

        //Pregunta 1
        Puntaje puntaje1 = new PuntajeClasico();
        ArrayList<Opcion> opciones1 = new ArrayList<>();

        Opcion opcionIncorrecta = new Opcion("falso", new Valor(false));
        Opcion opcionCorrecta = new Opcion("verdadero", new Valor(true));

        opciones1.add(opcionIncorrecta);
        opciones1.add(opcionCorrecta);
        String textoPregunta1 = "La UBA fue fundada en el año 1821";

        Pregunta pregunta1VyFClasico = new Pregunta(textoPregunta1, opciones1, puntaje1, "dummyText");


        //Pregunta 2
        Puntaje puntaje2 = new PuntajePenalidad();

        Opcion opcion1 = new Opcion("1", new Valor(false));
        Opcion opcion2 = new Opcion("2", new Valor(true));
        Opcion opcion3 = new Opcion("3", new Valor(true));
        Opcion opcion4 = new Opcion("4", new Valor(false));
        Opcion opcion5 = new Opcion("5", new Valor(true));
        Opcion opcion6 = new Opcion("6", new Valor(false));

        ArrayList<Opcion> opciones2 = new ArrayList<>(
                Arrays.asList(opcion1, opcion2, opcion3, opcion4, opcion5, opcion6)
        );

        String textoPregunta2 = "¿Cuáles de los siguientes números son primos?";

        Pregunta pregunta2MultiplePenalidad = new Pregunta(textoPregunta2, opciones2, puntaje2, "dummyText");


        //Preguntas
        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(pregunta1VyFClasico, pregunta2MultiplePenalidad));
        partida.inicializarPartida(preguntas);

        //Act
        partida.siguienteRonda();

        //Assert
        Assertions.assertThrows(NoHaySiguienteRondaError.class, () -> {
            partida.siguienteRonda();
        });
    }

    @Test
    public void test06() throws NoHaySiguienteRondaError, NoHaySiguienteTurnoError {
        //Arrange
        Partida partida = new Partida();
        partida.agregarJugador("Juan");
        partida.agregarJugador("Pedro");

        partida.inicializarPartida(CreadorDePreguntas.crearPreguntas());

        Turno turnoActual;
        Respuesta respuesta;
        Jugador jugador1;
        // PREGUNTA 1
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();
        jugador1 = partida.getJugadorActual();


        respuesta.marcar(partida.getPreguntaActual().getOpciones().get(0), new Valor (1));
        respuesta.marcar(partida.getPreguntaActual().getOpciones().get(1), new Valor (2));
        respuesta.marcar(partida.getPreguntaActual().getOpciones().get(2), new Valor (3));
        respuesta.marcar(partida.getPreguntaActual().getOpciones().get(3), new Valor (4));
        respuesta.marcar(partida.getPreguntaActual().getOpciones().get(4), new Valor (5));

        partida.enviarRespuesta();
        partida.siguienteTurno();

        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();
        jugador1 = partida.getJugadorActual();


        respuesta.marcar(partida.getPreguntaActual().getOpciones().get(0), new Valor (1));
        respuesta.marcar(partida.getPreguntaActual().getOpciones().get(1), new Valor (2));
        respuesta.marcar(partida.getPreguntaActual().getOpciones().get(2), new Valor (3));
        respuesta.marcar(partida.getPreguntaActual().getOpciones().get(3), new Valor (4));
        respuesta.marcar(partida.getPreguntaActual().getOpciones().get(4), new Valor (5));

        partida.enviarRespuesta();
        partida.asignarPuntajes();
        try {
            partida.siguienteRonda();
        }
        catch(NoHaySiguienteRondaError rondaError) {}

        assertEquals(1, partida.getJugadores().get(0).getPuntaje());
        assertEquals(1, partida.getJugadores().get(1).getPuntaje());
    }
}
