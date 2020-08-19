package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Seleccion;
import edu.fiuba.algo3.modelo.preguntas.Valor;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleccionTest {

    @Test
    public void test01SeleccionSeCreaConLaOpcionCorrecta() {
        //Arrange
        Opcion opcionPrueba = new Opcion("istrue", new Valor(true));
        Seleccion seleccionPrueba = new Seleccion(opcionPrueba);

        //Act
        Opcion opcionDeLaSeleccion = seleccionPrueba.getOpcion();

        //Assert
        assert(opcionPrueba == opcionDeLaSeleccion);
    }

    @Test
    public void test02SeleccionSeCreaDesmarcada() {
        //Arrange
        Opcion opcionPrueba = new Opcion("istrue", new Valor(true));
        Seleccion seleccionPrueba = new Seleccion(opcionPrueba);

        //Act
        Boolean seleccionFueMarcada = seleccionPrueba.fueMarcada();

        //Assert
        assertEquals(false, seleccionFueMarcada);
    }

    @Test
    public void test03SeleccionSeMarca() {
        //Arrange
        Opcion opcionPrueba = new Opcion("isfalse", new Valor(false));
        Seleccion seleccionPrueba = new Seleccion(opcionPrueba);

        Valor valorAMarcar = new Valor(true);
        seleccionPrueba.marcar(valorAMarcar);

        //Act
        Boolean fueMarcada = seleccionPrueba.fueMarcada();

        //Assert
        assert(fueMarcada);
    }

    @Test
    public void test04SeleccionSeDesmarcaTrasHaberSidoMarcado() {
        //Arrange
        Opcion opcionPrueba = new Opcion("isfalse", new Valor(false));
        Seleccion seleccionPrueba = new Seleccion(opcionPrueba);

        Valor valorAMarcar = new Valor(true);
        seleccionPrueba.marcar(valorAMarcar);
        seleccionPrueba.desmarcar();

        //Act
        Boolean seleccionNoFueMarcada = !(seleccionPrueba.fueMarcada());

        //Assert
        assert(seleccionNoFueMarcada);
    }

    @Test
    public void test05SeleccionSeMarcaConValorCorrecto() {
        //Arrange
        Opcion opcionPrueba = new Opcion("isfalse", new Valor(false));
        Seleccion seleccionPrueba = new Seleccion(opcionPrueba);

        Valor valorAMarcar = new Valor(true);
        seleccionPrueba.marcar(valorAMarcar);

        //Act
        Boolean seleccionValoresSonIguales = seleccionPrueba.getValor().esIgual(valorAMarcar);

        //Assert
        assert(seleccionValoresSonIguales);
    }

    @Test
    public void test06SeleccionMarcadaEsCorrecta() {
        //Arrange
        Opcion opcionPrueba = new Opcion("istrue", new Valor(true));
        Seleccion seleccionPrueba = new Seleccion(opcionPrueba);

        Valor valorAMarcar = new Valor(true);
        seleccionPrueba.marcar(valorAMarcar);

        //Act
        Boolean seleccionEsCorrecta = seleccionPrueba.esCorrecta();

        //Assert
        assert(seleccionEsCorrecta);
    }

    @Test
    public void test07SeleccionMarcadaEsIncorrecta() {
        //Arrange
        Opcion opcionPrueba = new Opcion("isfalse", new Valor(false));
        Seleccion seleccionPrueba = new Seleccion(opcionPrueba);

        Valor valorAMarcar = new Valor(true);
        seleccionPrueba.marcar(valorAMarcar);

        //Act
        Boolean seleccionEsIncorrecta = !(seleccionPrueba.esCorrecta());

        //Assert
        assert(seleccionEsIncorrecta);
    }

}