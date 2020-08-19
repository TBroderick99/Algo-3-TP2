package edu.fiuba.algo3.controlador;

        import edu.fiuba.algo3.modelo.Respuesta;
        import edu.fiuba.algo3.modelo.preguntas.Valor;
        import edu.fiuba.algo3.modelo.preguntas.Opcion;
        import edu.fiuba.algo3.vista.BotonOpcion;
        import javafx.event.Event;
        import javafx.scene.control.Button;
        import javafx.scene.layout.VBox;

public class BotonMarcarRespuestaMultipleEventHandler extends BotonMarcarEventHandler {

    public BotonMarcarRespuestaMultipleEventHandler(Respuesta respuesta, Opcion opcion, BotonOpcion botonOpcion, VBox botones, Button botonEnviar){
        super(respuesta, opcion, botonOpcion, botones, botonEnviar);

    }
    @Override
    public void handle(Event event) {

        Valor valor = new Valor(respuesta.getCantidadDeMarcadas() + 1);
        marcarDesmarcar(valor);
        actualizarBotonEnviar();

    }

    public void marcarDesmarcar(Valor valor){
        if (respuesta.fueMarcada(opcion)) {
            respuesta.desmarcar(opcion);
            botonOpcion.desmarcar();
        }
        else {
            respuesta.marcar(opcion, valor);
            botonOpcion.marcar();
        }
    }
}
