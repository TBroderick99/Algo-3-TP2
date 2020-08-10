package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Valor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrupoTest{

    @Test
    public void test01GruposSeCreanConNombreCorrecto(){
        //Arrange
        Grupo grupoHardcoders = new Grupo("Hardcoders", 1);
        Grupo grupoProcoders = new Grupo("Procoders", 2);

        //Act
        String nombreGrupoHardcoders = grupoHardcoders.getNombre();
        String nombreGrupoProcoders = grupoProcoders.getNombre();

        //Assert
        assertEquals("Hardcoders", nombreGrupoHardcoders);
        assertEquals("Procoders", nombreGrupoProcoders);

    }

    @Test
    public void test02GruposSeCreanConNumeroCorrecto(){
        //Arrange

        Grupo grupoHardcoders = new Grupo("Hardcoders", 1);
        Grupo grupoProcoders = new Grupo("Procoders", 2);

        //Act
        int numeroGrupoHardcoders = grupoHardcoders.getNumero();
        int numeroGrupoProcoders = grupoProcoders.getNumero();

        //Assert
        assertEquals(1, numeroGrupoHardcoders);
        assertEquals(2, numeroGrupoProcoders);

    }

}