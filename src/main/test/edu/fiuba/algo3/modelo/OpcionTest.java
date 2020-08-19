package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Grupo;
import edu.fiuba.algo3.modelo.preguntas.Valor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpcionTest {

    @Test
    public void test01OpcionSeCreaConNombreCorrecto() {
        //Arrange
        Opcion opcionPrueba = new Opcion("probando", new Valor(1));

        //Act
        String nombreOpcion = opcionPrueba.getTexto();

        //Assert
        assertEquals("probando", nombreOpcion);

    }

    @Test
    public void test02OpcionSeCreaConValorBooleanoCorrecto() {
        //Arrange
        Valor valorPrueba = new Valor(true);
        Opcion opcionPrueba = new Opcion("probando", new Valor(true));

        //Act
        Valor valorOpcion = opcionPrueba.getValor();

        //Assert
        assert(valorOpcion.esIgual(valorPrueba));

    }

    @Test
    public void test03OpcionSeCreaConValorOrdenadoCorrecto() {
        //Arrange
        Valor valorPruebaOrden4 = new Valor(4);
        Opcion opcionPrueba = new Opcion("probando", new Valor(4));

        //Act
        Valor valorOpcion = opcionPrueba.getValor();

        //Assert
        assert(valorOpcion.esIgual(valorPruebaOrden4));

    }

    @Test
    public void test04OpcionSeCreaConValorGrupalCorrecto() {
        //Arrange
        Grupo autos = new Grupo("Autos", 1);

        Opcion opcionPrueba = new Opcion("Mustang", new Valor( autos ));

        //Act
        int valorOpcion = opcionPrueba.getValor().getValor();

        //Assert
        assertEquals(autos.getNumero(), valorOpcion);

    }

    @Test
    public void test05OpcionDeMultipleChoiceDebeSerMarcada() {
        //Arrange
        Opcion opcionIncorrecta1 = new Opcion("isFalse", new Valor( false ));
        Opcion opcionCorrecta1 = new Opcion("isTrue", new Valor( true ));
        Opcion opcionCorrecta2 = new Opcion("isTrue", new Valor( true ));
        Opcion opcionIncorrecta2 = new Opcion("isFalse", new Valor( false ));

        //Act
        Boolean incorrecta1 = opcionIncorrecta1.debeSerMarcada();
        Boolean correcta1 = opcionCorrecta1.debeSerMarcada();
        Boolean correcta2 = opcionCorrecta2.debeSerMarcada();
        Boolean incorrecta2 = opcionIncorrecta1.debeSerMarcada();

        //Assert
        assertEquals(false, incorrecta1);
        assertEquals(true, correcta1);
        assertEquals(true, correcta2);
        assertEquals(false, incorrecta2);

    }

}