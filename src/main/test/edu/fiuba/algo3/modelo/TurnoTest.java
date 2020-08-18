package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Respuesta.Respuesta;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.preguntas.Puntaje;
import edu.fiuba.algo3.modelo.preguntas.PuntajeClasico;
import edu.fiuba.algo3.modelo.selecciones.Seleccion;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TurnoTest {

    @Test
    public void test01TurnoSeCreaConJugadorCorrecto(){
        //Arrange
        Jugador jugador = new Jugador("jose");
        Turno turno = new Turno(jugador);

        //Act
        Jugador jugadorAsociado = turno.getJugador();

        //Assert
        assertEquals(jugador, jugadorAsociado);

    }

    @Test
    public void test02AlActualizarTurnoSuRespuestaEstaSinMarcar(){
        //Arrange
        Jugador jugador = new Jugador("jose");
        Turno turno = new Turno(jugador);

        Puntaje puntaje = new PuntajeClasico();
        ArrayList<Opcion> opciones = new ArrayList<>();

        Opcion opcionIncorrecta = new Opcion("falso", new Valor(false));
        Opcion opcionCorrecta = new Opcion("verdadero", new Valor(true));

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);

        String textoPregunta = "La UBA fue fundada en el año 1821";

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");

        turno.actualizar(pregunta);
        Respuesta respuesta = turno.getRespuesta();

        //Act
        ArrayList<Seleccion> selecciones = respuesta.getSelecciones();
        Boolean respuestaEstaDesmarcada = true;

        for (Seleccion seleccion : selecciones){
            if(seleccion.fueMarcada()){
                respuestaEstaDesmarcada = false;
            }
        }

        //Assert
        assert(respuestaEstaDesmarcada);

    }

    @Test
    public void test03TurnoEnviaRespuestaALaRonda(){
        //Arrange
        Jugador jugador = new Jugador("jose");
        Ronda ronda = new Ronda();
        ronda.agregarTurno(jugador);

        Puntaje puntaje = new PuntajeClasico();
        ArrayList<Opcion> opciones = new ArrayList<>();

        Opcion opcionIncorrecta = new Opcion("falso", new Valor(false));
        Opcion opcionCorrecta = new Opcion("verdadero", new Valor(true));

        opciones.add(opcionIncorrecta);
        opciones.add(opcionCorrecta);

        String textoPregunta = "La UBA fue fundada en el año 1821";

        Pregunta pregunta = new Pregunta(textoPregunta, opciones, puntaje, "dummyText");
        ronda.actualizar(pregunta);

        //Act
        Turno turno = ronda.getTurnoActual();
        Respuesta respuesta = turno.getRespuesta();
        turno.enviarRespuesta(ronda);

        ArrayList<Respuesta> respuestasDeLaRonda = ronda.getRespuestas();
        Respuesta respuestaTurno1 = respuestasDeLaRonda.get(0);

        //Assert
        assertEquals(respuesta, respuestaTurno1);

    }
}
