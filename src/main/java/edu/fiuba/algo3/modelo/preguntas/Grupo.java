package edu.fiuba.algo3.modelo.preguntas;

import java.util.ArrayList;

public class Grupo {
    private String nombreDelGrupo;
    private int numeroDeGrupo;

    public Grupo(String nombreDelGrupo, int numeroDeGrupo){
        this.nombreDelGrupo = nombreDelGrupo;
        this.numeroDeGrupo = numeroDeGrupo;
    }

    public int getNumero(){
        return numeroDeGrupo;
    }

    public String getNombre(){
        return nombreDelGrupo;
    }
}
