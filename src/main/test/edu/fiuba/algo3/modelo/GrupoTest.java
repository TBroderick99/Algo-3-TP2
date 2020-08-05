package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Valor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GrupoTest{

    public void test01GruposSeCreanConNombreCorrecto(){
        //Arrange
        ArrayList<String> textosGrupos = new ArrayList<String>(Arrays.asList("Hardcoders", "Procoders"));
        ArrayList<Grupo> grupos = Grupo.crearGrupos(textosGrupos);

        Grupo grupoHardcoders = grupos.get(0);
        Grupo grupoProcoders = grupos.get(1);

        //Act
        String nombreGrupoHardcoders = grupoHardcoders.getNombre();
        String nombreGrupoProcoders = grupoProcoders.getNombre();

        //Assert
        assertEquals("Hardcoders", nombreGrupoHardcoders);
        assertEquals("Procoders", nombreGrupoProcoders);

    }

    public void test02GruposSeCreanConNumeroCorrecto(){
        //Arrange
        ArrayList<String> textosGrupos = new ArrayList<String>(Arrays.asList("Hardcoders", "Procoders"));
        ArrayList<Grupo> grupos = Grupo.crearGrupos(textosGrupos);

        Grupo grupoHardcoders = grupos.get(0); //es grupo 1
        Grupo grupoProcoders = grupos.get(1);  //es grupo 2

        //Act
        int numeroGrupoHardcoders = grupoHardcoders.getNumero();
        int numeroGrupoProcoders = grupoProcoders.getNumero();

        //Assert
        assertEquals(1, numeroGrupoHardcoders);
        assertEquals(2, numeroGrupoProcoders);

    }

}