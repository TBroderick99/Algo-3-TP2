package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Grupo;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Valor;
import edu.fiuba.algo3.vista.BotonGrupo;
import edu.fiuba.algo3.vista.BotonOpcion;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class BotonMarcarRespuestaGrupalEventHandler implements EventHandler {
    Respuesta respuesta;
    Opcion opcion;
    Button botonEnviar;
    BotonGrupo boton;
    BotonGrupo botonGrupoContrario;
    Grupo grupo;


    public BotonMarcarRespuestaGrupalEventHandler(Respuesta respuesta, Opcion opcion, Button botonEnviar, BotonGrupo boton, BotonGrupo botonGrupoContrario, Grupo grupo){
        this.respuesta = respuesta;
        this.opcion = opcion;
        this.botonEnviar = botonEnviar;
        this.boton = boton;
        this.botonGrupoContrario = botonGrupoContrario;
        this.grupo = grupo;

    }

    @Override
    public void handle(Event event) {

        respuesta.marcar(opcion, new Valor(this.grupo));
        boton.dejarMarcado();
        botonGrupoContrario.sacarMarca();
        boton.setBackground(new Background(new BackgroundFill(Color.web("333A56"), new CornerRadii(4), Insets.EMPTY)));
        botonGrupoContrario.setBackground(new Background(new BackgroundFill(Color.web("52658f"), new CornerRadii(4), Insets.EMPTY)));
        actualizarBotonEnviar();

    }

    public void actualizarBotonEnviar(){

        if (respuesta.seleccionesFueronTodasMarcadas()){
            botonEnviar.setDisable(false);
        }
        else{
            botonEnviar.setDisable(true);
        }

    }
}
