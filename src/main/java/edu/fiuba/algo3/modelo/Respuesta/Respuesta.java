package edu.fiuba.algo3.modelo.Respuesta;


import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.opciones.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Pregunta;
import edu.fiuba.algo3.modelo.selecciones.Seleccion;

import java.util.ArrayList;

public class Respuesta implements Observable {

    private ArrayList<Observer> observers = new ArrayList<>();
    private Pregunta preguntaAsociada;
    private Booster booster;
    private ArrayList<Seleccion> selecciones;
    private Jugador jugadorAsociado;
    private int cantidadDeMarcadas;


    public Respuesta(Jugador jugadorAAsociar, Pregunta pregunta){  //tambien la pregunta podria crear la respuesta
        selecciones = new ArrayList<>();
        this.jugadorAsociado = jugadorAAsociar;
        this.preguntaAsociada = pregunta;
        this.booster = new BoosterMultiplicador(1);
        this.cantidadDeMarcadas = 0;

        for(Opcion opcion: pregunta.getOpciones()){
            this.agregarSeleccion(opcion);
        }
    }

    public void marcar(Opcion opcion, Valor valorAMarcar)  {
       Seleccion seleccion = getSeleccion(opcion);
       seleccion.marcar(valorAMarcar);
       cantidadDeMarcadas += 1;

       notifyObservers();
    }

    public void desmarcar(Opcion opcion)  {
        Seleccion seleccion = getSeleccion(opcion);
        seleccion.desmarcar();
        cantidadDeMarcadas -= 1;

        notifyObservers();
    }

    public Boolean fueMarcada(Opcion opcion)  {
        Seleccion seleccion = getSeleccion(opcion);
        return seleccion.fueMarcada();
    }

    public Boolean tieneAlgunaMarcada(){
        for (Seleccion seleccion: selecciones){
            if(seleccion.fueMarcada()){
                return true;
            }
        }
        return false;
    }

    public ArrayList<Seleccion> getSelecciones(){
        return selecciones;
    }

    public Jugador getJugador(){
        return jugadorAsociado;
    }

    public void agregarSeleccion(Opcion opcion){
        Seleccion nuevaSeleccion = new Seleccion(opcion);
        selecciones.add(nuevaSeleccion);

    }

    private Seleccion getSeleccion(Opcion opcion) {   //nunca deberia devolver null, testear postcondicion
        return selecciones.stream().filter(s -> s.getOpcion() == opcion).findFirst().orElse(null);
    }

    public Boolean esPerfecta(){
        int correctasNoMarcadas = (int) selecciones.stream().filter(sel ->!sel.fueMarcada() && sel.debeSerMarcada()).count();
        int incorrectasMarcadas = (int) selecciones.stream().filter(sel -> sel.fueMarcada() && !sel.esCorrecta()).count();
        return (correctasNoMarcadas + incorrectasMarcadas) == 0;
    }

    public void sumarPuntajeAJugador(int puntajeASumar){
        this.jugadorAsociado.sumarPuntos(this.booster.multiplicarPuntaje(puntajeASumar));
    }

    public int getCantidadDeMarcadas(){
        return cantidadDeMarcadas;
    }

    public void setBoost(Booster boosterASetear) {
        boosterASetear.agregarBoost(this.booster);//RESPUESTA EMPIEZA SIN BOOSTER USAR NULL?
        this.booster = boosterASetear;
    }

    public Booster getBooster(){
        return this.booster;
    }

    public Pregunta getPregunta(){ return this.preguntaAsociada; }


    public boolean seleccionesFueronTodasMarcadas() {
        for (Seleccion seleccion: selecciones){
            if (!seleccion.fueMarcada()){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Opcion> getOpcionesMarcadas(){
        ArrayList<Opcion> opcionesMarcadas = new ArrayList<>();
        for( Seleccion seleccion : selecciones)
            if(seleccion.fueMarcada()) {
                opcionesMarcadas.add(seleccion.getOpcion());
            }
        return opcionesMarcadas;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(Observer::change);
    }
}