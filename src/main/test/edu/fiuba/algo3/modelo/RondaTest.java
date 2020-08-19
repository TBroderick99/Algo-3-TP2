package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteTurnoError;
import edu.fiuba.algo3.modelo.preguntas.Valor;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.preguntas.puntajes.PuntajeClasico;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RondaTest {

    @Test
    public void test01RondaAgregaTurnoConElJugadorCorrecto(){
        //Arrange
        Ronda ronda = new Ronda();
        Jugador jugador = new Jugador("Tomas");
        ronda.agregarTurno(jugador);

        //Act
        Turno turno = ronda.getTurnos().get(0);

        //Assert
        assertEquals(jugador, turno.getJugador());

    }

    @Test
    public void test02AlActualizarRondaSeActualizaLaPreguntaActual(){
        //Arrange
        Ronda ronda = new Ronda();
        Jugador jugador = new Jugador("Tomas");
        ronda.agregarTurno(jugador);

        Puntaje puntaje = new PuntajeClasico();
        ArrayList<Opcion> opciones = new ArrayList<>();

        Opcion opcionIncorrecta = new Opcion("falso", new Valor(false));
        Opcion opcionCorrecta = new Opcion("verdadero", new Valor(true));

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);
        String textoPregunta1 = "La UBA fue fundada en el año 1821";

        Pregunta pregunta1 = new Pregunta(textoPregunta1, opciones, puntaje, "dummyText");

        String textoPregunta2 = "La lechuga es una verdura";
        Pregunta pregunta2 = new Pregunta(textoPregunta2, opciones, puntaje, "dummyText");

        ronda.actualizar(pregunta1);

        //Act
        ronda.actualizar(pregunta2);
        Pregunta preguntaActual = ronda.getPreguntaActual();

        //Assert
        assertEquals(pregunta2, preguntaActual);

    }


    @Test
    public void test03AlActualizarRondaSeSeteaElIteradorDeTurnosAlTurnoDelPrimerJugador(){
        //Arrange
        Ronda ronda = new Ronda();
        Jugador jugador1 = new Jugador("Tomas");
        Jugador jugador2 = new Jugador("Juan");
        ronda.agregarTurno(jugador1);
        ronda.agregarTurno(jugador2);

        Puntaje puntaje = new PuntajeClasico();
        ArrayList<Opcion> opciones = new ArrayList<>();

        Opcion opcionIncorrecta = new Opcion("falso", new Valor(false));
        Opcion opcionCorrecta = new Opcion("verdadero", new Valor(true));

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);
        String textoPregunta1 = "La UBA fue fundada en el año 1821";

        Pregunta pregunta1 = new Pregunta(textoPregunta1, opciones, puntaje, "dummyText");

        //Act
        ronda.actualizar(pregunta1);
        Turno turno = ronda.getTurnoActual();


        //Assert
        assertEquals(jugador1, turno.getJugador());

    }

    @Test
    public void test04RondaPasaDeTurno() throws NoHaySiguienteTurnoError {
        //Arrange
        Ronda ronda = new Ronda();
        Jugador jugador1 = new Jugador("Tomas");
        Jugador jugador2 = new Jugador("Juan");
        ronda.agregarTurno(jugador1);
        ronda.agregarTurno(jugador2);

        Puntaje puntaje = new PuntajeClasico();
        ArrayList<Opcion> opciones = new ArrayList<>();

        Opcion opcionIncorrecta = new Opcion("falso", new Valor(false));
        Opcion opcionCorrecta = new Opcion("verdadero", new Valor(true));

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);
        String textoPregunta1 = "La UBA fue fundada en el año 1821";

        Pregunta pregunta1 = new Pregunta(textoPregunta1, opciones, puntaje, "dummyText");
        ronda.actualizar(pregunta1);

        //Act
        Turno turno1 = ronda.getTurnoActual();
        ronda.siguienteTurno();
        Turno turno2 = ronda.getTurnoActual();


        //Assert
        assertEquals(jugador1, turno1.getJugador());
        assertEquals(jugador2, turno2.getJugador());

    }


    @Test
    public void test06RondaRecibeUnaRespuesta(){
        Ronda ronda = new Ronda();
        Jugador jugador = new Jugador("Pedro");

        Puntaje puntaje = new PuntajeClasico();
        ArrayList<Opcion> opciones = new ArrayList<>();

        Opcion opcionIncorrecta = new Opcion("falso", new Valor(false));
        Opcion opcionCorrecta = new Opcion("verdadero", new Valor(true));

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);
        String textoPregunta1 = "La UBA fue fundada en el año 1821";

        Pregunta pregunta = new Pregunta(textoPregunta1, opciones, puntaje, "dummyText");
        Respuesta respuesta = new Respuesta(jugador, pregunta);

        //Act
        ronda.recibirRespuesta(respuesta);
        ArrayList<Respuesta> respuestas = ronda.getRespuestas();
        Respuesta primeraRespuesta = respuestas.get(0);

        //Assert
        assertEquals(respuesta, primeraRespuesta);

    }


}
