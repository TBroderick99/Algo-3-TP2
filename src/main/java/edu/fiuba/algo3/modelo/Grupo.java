package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Grupo {
    private String nombreDelGrupo;
    private int numeroDeGrupo;

    private Grupo(String nombreDelGrupo, int numeroDeGrupo){
        this.nombreDelGrupo = nombreDelGrupo;
        this.numeroDeGrupo = numeroDeGrupo;
    }

    public static ArrayList<Grupo> crearGrupos(ArrayList<String> nombresDeLosGrupos){
        ArrayList<Grupo> grupos = new ArrayList<Grupo>();

        int cantidadDeGrupos = 0;

        for(String nombreDelGrupo: nombresDeLosGrupos){
            Grupo grupo = new Grupo(nombreDelGrupo, cantidadDeGrupos + 1 );
            grupos.add(grupo);
            cantidadDeGrupos += 1;
        }

        return grupos;
    }

    public int getNumero(){
        return numeroDeGrupo;
    }

    public String getNombre(){
        return nombreDelGrupo;
    }
}
