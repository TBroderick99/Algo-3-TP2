package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.boosters.Booster;
import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteRondaError;
import edu.fiuba.algo3.modelo.excepciones.NoHaySiguienteTurnoError;
import edu.fiuba.algo3.modelo.preguntas.puntajes.Puntaje;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.puntajes.*;
import edu.fiuba.algo3.modelo.preguntas.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;


public class KahootTest {


    @Test
    public void test01DosJugadoresJueganUnaPartidaDeCuatroPreguntasSinBoosters() throws NoHaySiguienteTurnoError, NoHaySiguienteRondaError{
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


        //Pregunta 3
        Puntaje puntaje3 = new PuntajeClasico();
        String textoPregunta3 = "Seleccione el orden correcto de los pasos para hacer una pizza";

        Opcion opcionHornear = new Opcion("hornear", new Valor(4));
        Opcion opcionHacerLaMasa = new Opcion("hacer la masa", new Valor(1));
        Opcion opcionAgregarSalsa = new Opcion("agregar salsa", new Valor(2));
        Opcion opcionAgregarQueso = new Opcion("agregar queso", new Valor(3));

        ArrayList<Opcion> opciones3 = new ArrayList<>(Arrays.asList(opcionHornear, opcionHacerLaMasa, opcionAgregarSalsa, opcionAgregarQueso));

        Pregunta pregunta3Ordered = new Pregunta(textoPregunta3, opciones3, puntaje3, "dummyText");


        //Pregunta 4
        Puntaje puntaje4 = new PuntajeClasico();
        String textoPregunta4 = "A que grupo pertenecen las siguientes opciones?";

        Grupo grupoFrutas = new Grupo("Frutas", 1);
        Grupo grupoVegetales = new Grupo("Vegetales", 2);

        Opcion opcionTomate = new Opcion("tomate", new Valor(grupoFrutas));
        Opcion opcionLechuga = new Opcion("lechuga", new Valor(grupoVegetales));
        Opcion opcionBerenjena = new Opcion("berenjena", new Valor(grupoVegetales));
        Opcion opcionSandia = new Opcion("sandia", new Valor(grupoFrutas));

        ArrayList<Opcion> opciones4 = new ArrayList<>(Arrays.asList(opcionTomate, opcionLechuga, opcionBerenjena, opcionSandia));
        ArrayList<Grupo> grupos = new ArrayList<>(Arrays.asList(grupoFrutas, grupoVegetales));

        Pregunta pregunta4Group = new PreguntaGrupal(textoPregunta4, opciones4, puntaje4, "dummyText", grupos);

        //Preguntas
        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(pregunta1VyFClasico, pregunta2MultiplePenalidad, pregunta3Ordered, pregunta4Group));


        //Test

        Partida partida = new Partida();

        partida.agregarJugador("Jose");
        partida.agregarJugador("Tomas");
        partida.inicializarPartida(preguntas); // Constructor especial para el test

        Turno turnoActual;
        Respuesta respuesta;
        // PREGUNTA 1
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();


        respuesta.marcar(opcionCorrecta, new Valor (true));    //Jugador1. Clasico, -> Puntos totales: 1 punto

        partida.enviarRespuesta();

        partida.siguienteTurno();

        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();

        respuesta.marcar(opcionIncorrecta, new Valor(true));   //Jugador2. Clasico, -> puntos totales: 0 puntos

        partida.enviarRespuesta();
        partida.asignarPuntajes();
        partida.siguienteRonda();

        // PREGUNTA 2
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();

        respuesta.marcar(opcion1, new Valor(true));         //Jugador1. Penalidad, 2 bien y una mal -> puntos totales: 2
        respuesta.marcar(opcion2, new Valor(true));
        respuesta.marcar(opcion3, new Valor(true));

        partida.enviarRespuesta();
        partida.siguienteTurno();

        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();

        respuesta.marcar(opcion2, new Valor(true));         //Jugador2. Penalidad, 3 bien -> puntos totales: 3
        respuesta.marcar(opcion3, new Valor(true));
        respuesta.marcar(opcion5, new Valor(true));

        partida.enviarRespuesta();
        partida.asignarPuntajes();
        partida.siguienteRonda();

        // PREGUNTA 3
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();

        respuesta.marcar(opcionHacerLaMasa, new Valor(respuesta.getCantidadDeMarcadas() + 1));         //Jugador1, Ordered(siempre clasico), todos los ordenes correctos -> puntos totales: 3
        respuesta.marcar(opcionAgregarSalsa, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        respuesta.marcar(opcionAgregarQueso, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        respuesta.marcar(opcionHornear, new Valor(respuesta.getCantidadDeMarcadas() + 1));

        partida.enviarRespuesta();
        partida.siguienteTurno();

        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();


        respuesta.marcar(opcionAgregarQueso, new Valor(respuesta.getCantidadDeMarcadas() + 1));         //Jugador2, Ordered(siempre clasico), todos los ordenes mal -> puntos totales:3
        respuesta.marcar(opcionHornear, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        respuesta.marcar(opcionHacerLaMasa, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        respuesta.marcar(opcionAgregarSalsa, new Valor(respuesta.getCantidadDeMarcadas() + 1));

        partida.enviarRespuesta();
        partida.asignarPuntajes();
        partida.siguienteRonda();

        // PREGUNTA 4
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();


        respuesta.marcar(opcionTomate, new Valor(grupoFrutas));                  //Jugador 1. Grupal(siempre clasico), marco los grupos bien. puntos totales: 4
        respuesta.marcar(opcionLechuga, new Valor(grupoVegetales));
        respuesta.marcar(opcionSandia, new Valor(grupoFrutas));
        respuesta.marcar(opcionBerenjena, new Valor(grupoVegetales));

        partida.enviarRespuesta();
        partida.siguienteTurno();

        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();

        respuesta.marcar(opcionTomate, new Valor(grupoVegetales));               // //Jugador 2. Grupal(siempre clasico), marco los grupos mal. puntos totales: 3
        respuesta.marcar(opcionLechuga, new Valor(grupoVegetales));
        respuesta.marcar(opcionSandia, new Valor(grupoFrutas));
        respuesta.marcar(opcionBerenjena, new Valor(grupoVegetales));

        partida.enviarRespuesta();
        partida.asignarPuntajes();

        try {
            partida.siguienteRonda();
        }
        catch (NoHaySiguienteRondaError rondaError) {}

        ArrayList<Jugador> jugadores = partida.getJugadores();
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        //Assert
        assertEquals(4, jugador1.getPuntaje());         // 4
        assertEquals(3, jugador2.getPuntaje());         // 3
    }

    @Test
    public void test02DosJugadoresJueganUnaPartidaDeCuatroPreguntasConBoosters() throws NoHaySiguienteTurnoError, NoHaySiguienteRondaError{
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


        //Pregunta 3
        Puntaje puntaje3 = new PuntajeClasico();
        String textoPregunta3 = "Seleccione el orden correcto de los pasos para hacer una pizza";

        Opcion opcionHornear = new Opcion("hornear", new Valor(4));
        Opcion opcionHacerLaMasa = new Opcion("hacer la masa", new Valor(1));
        Opcion opcionAgregarSalsa = new Opcion("agregar salsa", new Valor(2));
        Opcion opcionAgregarQueso = new Opcion("agregar queso", new Valor(3));

        ArrayList<Opcion> opciones3 = new ArrayList<>(Arrays.asList(opcionHornear, opcionHacerLaMasa, opcionAgregarSalsa, opcionAgregarQueso));

        Pregunta pregunta3Ordered = new Pregunta(textoPregunta3, opciones3, puntaje3, "dummyText");


        //Pregunta 4
        Puntaje puntaje4 = new PuntajeClasico();
        String textoPregunta4 = "A que grupo pertenecen las siguientes opciones?";

        Grupo grupoFrutas = new Grupo("Frutas", 1);
        Grupo grupoVegetales = new Grupo("Vegetales", 2);

        Opcion opcionTomate = new Opcion("tomate", new Valor(grupoFrutas));
        Opcion opcionLechuga = new Opcion("lechuga", new Valor(grupoVegetales));
        Opcion opcionBerenjena = new Opcion("berenjena", new Valor(grupoVegetales));
        Opcion opcionSandia = new Opcion("sandia", new Valor(grupoFrutas));

        ArrayList<Opcion> opciones4 = new ArrayList<>(Arrays.asList(opcionTomate, opcionLechuga, opcionBerenjena, opcionSandia));
        ArrayList<Grupo> grupos = new ArrayList<>(Arrays.asList(grupoFrutas, grupoVegetales));

        Pregunta pregunta4Group = new PreguntaGrupal(textoPregunta4, opciones4, puntaje4, "dummyText", grupos);

        //Preguntas
        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(pregunta1VyFClasico, pregunta2MultiplePenalidad, pregunta3Ordered, pregunta4Group));


        //Test

        Partida partida = new Partida();

        partida.agregarJugador("Jose");
        partida.agregarJugador("Tomas");
        partida.inicializarPartida(preguntas);


        ArrayList<Jugador> jugadores = partida.getJugadores();
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        Turno turnoActual;
        Respuesta respuesta;

        // PREGUNTA 1
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();


        respuesta.marcar(opcionCorrecta, new Valor (true));    //Jugador1. Clasico, -> Puntos turno: 1 Puntos totales: 1 punto

        partida.enviarRespuesta();
        partida.siguienteTurno();

        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();

        respuesta.marcar(opcionIncorrecta, new Valor(true));   //Jugador2. Clasico, -> Puntos turno: 0 Puntos totales: 0 puntos

        partida.enviarRespuesta();
        partida.asignarPuntajes();
        partida.siguienteRonda();




        // PREGUNTA 2
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();
        jugador1 = partida.getJugadorActual();


        Booster boosterMultiplicadorx2Jugador1 = jugador1.getBoosterMultiplicador(2);
        jugador1.consumirBooster(respuesta,boosterMultiplicadorx2Jugador1);


        respuesta.marcar(opcion1, new Valor(true));                             //Jugador1. Penalidad, 2 bien y una mal -> Puntos ronda: 2 puntos totales: 3
        respuesta.marcar(opcion2, new Valor(true));
        respuesta.marcar(opcion3, new Valor(true));

        partida.enviarRespuesta();
        partida.siguienteTurno();

        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();
        jugador2 = partida.getJugadorActual();

        Booster boosterMultiplicadorx3Jugador2 = jugador2.getBoosterMultiplicador(3);
        jugador2.consumirBooster(respuesta,boosterMultiplicadorx3Jugador2);

        respuesta.marcar(opcion2, new Valor(true));                     //Jugador2. Penalidad, 3 bien -> Puntos turno: 9 puntos totales: 9
        respuesta.marcar(opcion3, new Valor(true));
        respuesta.marcar(opcion5, new Valor(true));


        partida.enviarRespuesta();
        partida.asignarPuntajes();
        partida.siguienteRonda();


        // PREGUNTA 3
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();
        jugador1 = partida.getJugadorActual();

        Booster boosterExlusividad = jugador1.getBoosterExclusividad();
        jugador1.consumirBooster(respuesta,boosterExlusividad);

        respuesta.marcar(opcionHacerLaMasa, new Valor(respuesta.getCantidadDeMarcadas() + 1));         //Jugador1, Ordered(siempre clasico), todos los ordenes correctos -> puntos ronda: 2 puntos totales: 5
        respuesta.marcar(opcionAgregarSalsa, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        respuesta.marcar(opcionAgregarQueso, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        respuesta.marcar(opcionHornear, new Valor(respuesta.getCantidadDeMarcadas() + 1));

        partida.enviarRespuesta();
        partida.siguienteTurno();

        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();


        respuesta.marcar(opcionAgregarQueso, new Valor(respuesta.getCantidadDeMarcadas() + 1));         //Jugador2, Ordered(siempre clasico), todos los ordenes mal ->puntos ronda: 0 puntos totales:9
        respuesta.marcar(opcionHornear, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        respuesta.marcar(opcionHacerLaMasa, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        respuesta.marcar(opcionAgregarSalsa, new Valor(respuesta.getCantidadDeMarcadas() + 1));

        partida.enviarRespuesta();
        partida.asignarPuntajes();
        partida.siguienteRonda();


        // PREGUNTA 4
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();

        jugador1 = partida.getJugadorActual();
        Booster boosterExlusividadJugador1 = jugador1.getBoosterExclusividad();
        jugador1.consumirBooster(respuesta,boosterExlusividadJugador1);


        respuesta.marcar(opcionTomate, new Valor(grupoFrutas));                   //Jugador 1. Grupal(siempre clasico), marco los grupos bien. puntos ronda: 4 puntos totales: 9
        respuesta.marcar(opcionLechuga, new Valor(grupoVegetales));
        respuesta.marcar(opcionSandia, new Valor(grupoFrutas));
        respuesta.marcar(opcionBerenjena, new Valor(grupoVegetales));

        partida.enviarRespuesta();
        partida.siguienteTurno();

        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();

        jugador2 = partida.getJugadorActual();
        Booster boosterExlusividadJugador2 = jugador2.getBoosterExclusividad();
        jugador2.consumirBooster(respuesta,boosterExlusividadJugador2);

        respuesta.marcar(opcionTomate, new Valor(grupoVegetales));                //Jugador 2. Grupal(siempre clasico), marco los grupos mal. puntos ronda: 0 puntos totales: 9
        respuesta.marcar(opcionLechuga, new Valor(grupoVegetales));
        respuesta.marcar(opcionSandia, new Valor(grupoFrutas));
        respuesta.marcar(opcionBerenjena, new Valor(grupoVegetales));

        partida.enviarRespuesta();
        partida.asignarPuntajes();
        try {
            partida.siguienteRonda();
        }
        catch (NoHaySiguienteRondaError rondaError) {}



        //Assert
        assertEquals(9, jugador1.getPuntaje());         // 9
        assertEquals(9, jugador2.getPuntaje());         // 9
    }


    @Test
    public void test03DosJugadoresJueganUnaPartidaDeCuatroPreguntasConDistintosBoosters()  throws NoHaySiguienteTurnoError, NoHaySiguienteRondaError {
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


        //Pregunta 3
        Puntaje puntaje3 = new PuntajeClasico();
        String textoPregunta3 = "Seleccione el orden correcto de los pasos para hacer una pizza";

        Opcion opcionHornear = new Opcion("hornear", new Valor(4));
        Opcion opcionHacerLaMasa = new Opcion("hacer la masa", new Valor(1));
        Opcion opcionAgregarSalsa = new Opcion("agregar salsa", new Valor(2));
        Opcion opcionAgregarQueso = new Opcion("agregar queso", new Valor(3));

        ArrayList<Opcion> opciones3 = new ArrayList<>(Arrays.asList(opcionHornear, opcionHacerLaMasa, opcionAgregarSalsa, opcionAgregarQueso));

        Pregunta pregunta3Ordered = new Pregunta(textoPregunta3, opciones3, puntaje3, "dummyText");


        //Pregunta 4
        Puntaje puntaje4 = new PuntajeClasico();
        String textoPregunta4 = "A que grupo pertenecen las siguientes opciones?";

        Grupo grupoFrutas = new Grupo("Frutas", 1);
        Grupo grupoVegetales = new Grupo("Vegetales", 2);

        Opcion opcionTomate = new Opcion("tomate", new Valor(grupoFrutas));
        Opcion opcionLechuga = new Opcion("lechuga", new Valor(grupoVegetales));
        Opcion opcionBerenjena = new Opcion("berenjena", new Valor(grupoVegetales));
        Opcion opcionSandia = new Opcion("sandia", new Valor(grupoFrutas));

        ArrayList<Opcion> opciones4 = new ArrayList<>(Arrays.asList(opcionTomate, opcionLechuga, opcionBerenjena, opcionSandia));
        ArrayList<Grupo> grupos = new ArrayList<>(Arrays.asList(grupoFrutas, grupoVegetales));

        Pregunta pregunta4Group = new PreguntaGrupal(textoPregunta4, opciones4, puntaje4, "dummyText", grupos);

        //Preguntas
        ArrayList<Pregunta> preguntas = new ArrayList<>(Arrays.asList(pregunta1VyFClasico, pregunta2MultiplePenalidad, pregunta3Ordered, pregunta4Group));


        //Test

        Partida partida = new Partida();

        partida.agregarJugador("Jose");
        partida.agregarJugador("Tomas");
        partida.inicializarPartida(preguntas);

        ArrayList<Jugador> jugadores = partida.getJugadores();
        Jugador jugador1 = jugadores.get(0);
        Jugador jugador2 = jugadores.get(1);

        Turno turnoActual;
        Respuesta respuesta;

        // PREGUNTA 1
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();
        jugador1 = partida.getJugadorActual();

        Booster boosterExclusividadJugador1 = jugador1.getBoosterExclusividad();
        jugador1.consumirBooster(respuesta,boosterExclusividadJugador1);


        respuesta.marcar(opcionIncorrecta, new Valor (true));    //Jugador1. Clasico, -> Puntos turno: 0 Puntos totales: 0 punto

        partida.enviarRespuesta();
        partida.siguienteTurno();



        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();

        respuesta.marcar(opcionIncorrecta, new Valor(true));   //Jugador2. Clasico, -> Puntos turno: 0 Puntos totales: 0 puntos

        partida.enviarRespuesta();
        partida.asignarPuntajes();
        partida.siguienteRonda();


        // PREGUNTA 2
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();
        jugador1 = partida.getJugadorActual();


        Booster boosterMultiplicadorx2Jugador1 = jugador1.getBoosterMultiplicador(2);
        jugador1.consumirBooster(respuesta,boosterMultiplicadorx2Jugador1);


        respuesta.marcar(opcion1, new Valor(true));                             //Jugador1. Penalidad, 2 bien y una mal -> Puntos ronda: 2 puntos totales: 2
        respuesta.marcar(opcion2, new Valor(true));
        respuesta.marcar(opcion3, new Valor(true));

        partida.enviarRespuesta();
        partida.siguienteTurno();

        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();
        jugador2 = partida.getJugadorActual();

        Booster boosterMultiplicadorx3Jugador2 = jugador2.getBoosterMultiplicador(3);
        jugador2.consumirBooster(respuesta,boosterMultiplicadorx3Jugador2);

        respuesta.marcar(opcion2, new Valor(true));                     //Jugador2. Penalidad, 3 bien -> Puntos turno: 9 puntos totales: 9
        respuesta.marcar(opcion3, new Valor(true));
        respuesta.marcar(opcion5, new Valor(true));

        partida.enviarRespuesta();
        partida.asignarPuntajes();
        partida.siguienteRonda();


        // PREGUNTA 3
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();
        jugador1 = partida.getJugadorActual();

        Booster boosterExlusividad = jugador1.getBoosterExclusividad();
        jugador1.consumirBooster(respuesta,boosterExlusividad);

        respuesta.marcar(opcionAgregarSalsa, new Valor(respuesta.getCantidadDeMarcadas() + 1));         //Jugador1, Ordered(siempre clasico), todos los ordenes correctos -> puntos ronda: 0 puntos totales: 2
        respuesta.marcar(opcionHacerLaMasa, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        respuesta.marcar(opcionAgregarQueso, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        respuesta.marcar(opcionHornear, new Valor(respuesta.getCantidadDeMarcadas() + 1));

        partida.enviarRespuesta();
        partida.siguienteTurno();

        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();


        respuesta.marcar(opcionHacerLaMasa, new Valor(respuesta.getCantidadDeMarcadas() + 1));         //Jugador2, Ordered(siempre clasico), todos los ordenes mal ->puntos ronda: 2 puntos totales: 11
        respuesta.marcar(opcionAgregarSalsa, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        respuesta.marcar(opcionAgregarQueso, new Valor(respuesta.getCantidadDeMarcadas() + 1));
        respuesta.marcar(opcionHornear, new Valor(respuesta.getCantidadDeMarcadas() + 1));

        partida.enviarRespuesta();
        partida.asignarPuntajes();
        partida.siguienteRonda();


        // PREGUNTA 4
        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();

        jugador1 = partida.getJugadorActual();


        respuesta.marcar(opcionTomate, new Valor(grupoFrutas));                   //Jugador 1. Grupal(siempre clasico), marco los grupos bien. puntos ronda: 1 puntos totales: 3
        respuesta.marcar(opcionLechuga, new Valor(grupoVegetales));
        respuesta.marcar(opcionSandia, new Valor(grupoFrutas));
        respuesta.marcar(opcionBerenjena, new Valor(grupoVegetales));

        partida.enviarRespuesta();
        partida.siguienteTurno();

        turnoActual = partida.getTurnoActual();
        respuesta = turnoActual.getRespuesta();


        respuesta.marcar(opcionTomate, new Valor(grupoVegetales));                //Jugador 2. Grupal(siempre clasico), marco los grupos mal. puntos ronda: 0 puntos totales: 11
        respuesta.marcar(opcionLechuga, new Valor(grupoVegetales));
        respuesta.marcar(opcionSandia, new Valor(grupoFrutas));
        respuesta.marcar(opcionBerenjena, new Valor(grupoVegetales));

        partida.enviarRespuesta();
        partida.asignarPuntajes();
        try {
            partida.siguienteRonda();
        }
        catch(NoHaySiguienteRondaError rondaError) {}

        //Assert
        assertEquals(3, jugador1.getPuntaje());         // 3
        assertEquals(11, jugador2.getPuntaje());         // 11
    }


}