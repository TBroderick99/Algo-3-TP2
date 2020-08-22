package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Valor;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.vista.BotonOpcion;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonMarcarRespuestaOrdenadaEventHandler  extends BotonMarcarEventHandler {

    private static int orden = 0;

    public BotonMarcarRespuestaOrdenadaEventHandler(Respuesta respuesta, Opcion opcion, BotonOpcion botonOpcion, VBox botones, Button botonEnviar){
        super(respuesta, opcion, botonOpcion, botones, botonEnviar);
    }

    public static void reiniciarContador() {
        orden = 0;
    }

    @Override
    public void handle(Event event) {
        sumarRestar();
        System.out.println(orden);
        Valor valor = new Valor(orden);
        marcarDesmarcar(valor);
        actualizarBotonEnviar();
    }

    private void sumarRestar() {
        if (!respuesta.fueMarcada(opcion))
            this.orden = orden + 1;
    }

    @Override
    public void actualizarBotonEnviar(){
        if (respuesta.seleccionesFueronTodasMarcadas()){
            botonEnviar.setDisable(false);
        }
        else{
            botonEnviar.setDisable(true);
        }
    }

    @Override
    public void marcarDesmarcar(Valor valor){
        if (respuesta.fueMarcada(opcion)) {
            respuesta.desmarcar(opcion);
            botonOpcion.desmarcar();
            this.orden = orden - 1;
        }
        else {
            respuesta.marcar(opcion, valor);
            botonOpcion.marcar();
        }
    }
}
