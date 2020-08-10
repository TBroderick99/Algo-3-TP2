package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Valor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValorTest{
    @Test
    public void test01ValorSeCreaConBooleanoCorrectamente() {
        //Arrange
        Valor valorVerdadero = new Valor(true); //su valor es 1
        Valor valorFalso = new Valor(false);    //su valor es 0

        //Act
        int valorNumericoVerdadero = valorVerdadero.getValor();
        int valorNumericoFalso = valorFalso.getValor();

        //Assert
        assertEquals(1, valorNumericoVerdadero);
        assertEquals(0, valorNumericoFalso);
    }

    @Test
    public void test02ValorSeCreaConOrdenCorrectamente() {
        //Arrange
        Valor primerValor = new Valor(1);
        Valor segundoValor = new Valor(2);
        Valor tercerValor = new Valor(3);

        //Act
        int valorNumericoPrimero = primerValor.getValor();
        int valorNumericoSegundo = segundoValor.getValor();
        int valorNumericoTercero = tercerValor.getValor();

        //Assert
        assertEquals(1, valorNumericoPrimero);
        assertEquals(2, valorNumericoSegundo);
        assertEquals(3, valorNumericoTercero);
    }

    @Test
    public void test03ValorSeCreaConGrupoCorrecto() {
        //Arrange

        Grupo grupoAutos = new Grupo("Autos", 1);
        Grupo grupoMotos = new Grupo("Motos", 2);
        Grupo grupoAviones = new Grupo("Aviones", 3);

        Valor valorAutos = new Valor(grupoAutos);
        Valor valorMotos = new Valor(grupoMotos);
        Valor valorAviones = new Valor(grupoAviones);


        //Act
        int valorNumericoAutos = valorAutos.getValor();
        int valorNumericoMotos = valorMotos.getValor();
        int valorNumericoAviones = valorAviones.getValor();

        //Assert
        assertEquals(grupoAutos.getNumero(), valorNumericoAutos);
        assertEquals(grupoMotos.getNumero(), valorNumericoMotos);
        assertEquals(grupoAviones.getNumero(), valorNumericoAviones);
    }

    @Test
    public void test04ValorDeBooleanoSeComparanCorrectamente() {
        //Arrange
        Valor valorPruebaVerdadero = new Valor(true);
        Valor valorACompararVerdadero = new Valor(true);

        Valor valorPruebaFalso = new Valor(false);
        Valor valorACompararFalso = new Valor(false);

        //Act
        Boolean valoresVerdaderoSonIguales = valorPruebaVerdadero.esIgual(valorACompararVerdadero);
        Boolean valoresFalsoSonIguales = valorPruebaFalso.esIgual(valorACompararFalso);
        Boolean valoresDistintosNoSonIguales = !(valorPruebaVerdadero.esIgual(valorACompararFalso));

        //Assert
        assert(valoresVerdaderoSonIguales);
        assert(valoresFalsoSonIguales);
        assert(valoresDistintosNoSonIguales);
    }

    @Test
    public void test05ValorDeOrdenSeComparanCorrectamente() {
        //Arrange
        Valor valorPruebaOrden1 = new Valor(1);
        Valor valorACompararOrden1 = new Valor(1);

        Valor valorPruebaOrden2 = new Valor(2);
        Valor valorACompararOrden2 = new Valor(2);

        //Act
        Boolean valoresOrden1SonIguales = valorPruebaOrden1.esIgual(valorACompararOrden1);
        Boolean valoresOrden2SonIguales = valorPruebaOrden2.esIgual(valorACompararOrden2);
        Boolean valoresDeOrdenDistintoNoSonIguales = !(valorPruebaOrden1.esIgual(valorACompararOrden2));

        //Assert
        assert(valoresOrden1SonIguales);
        assert(valoresOrden2SonIguales);
        assert(valoresDeOrdenDistintoNoSonIguales);
    }

    // este test falla
    public void test06ValorSeCreaConGrupoCorrecto() {
        //Arrange
        Grupo grupoAutos = new Grupo("Autos", 1);
        Grupo grupoMotos = new Grupo("Motos", 2);

        Valor valorAutos = new Valor(grupoAutos);
        Valor valorAutosAComparar = new Valor(grupoAutos);

        Valor valorMotos = new Valor(grupoMotos);
        Valor valorMotosAComparar = new Valor(grupoMotos);


        //Act
        Boolean valoresConGrupoAutosSonIguales = valorAutos.esIgual(valorAutosAComparar);
        Boolean valoresConGrupoMotosSonIguales = valorMotos.esIgual(valorMotosAComparar);
        Boolean valoresConGruposDistintosNoSonIguales = valorAutos.esIgual(valorMotosAComparar);

        //Assert
        assert(valoresConGrupoAutosSonIguales);
        assert(valoresConGrupoMotosSonIguales);
        assert(valoresConGruposDistintosNoSonIguales);
    }
}