package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.preguntas.Grupo;
import edu.fiuba.algo3.modelo.preguntas.Opcion;
import edu.fiuba.algo3.modelo.preguntas.Valor;
import edu.fiuba.algo3.vista.BotonOpcion;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.VBox;

public class CheckBoxMarcarGrupoEventHandler implements EventHandler {
    Respuesta respuesta;
    Opcion opcion;
    Button botonEnviar;
    RadioButton radioButton;
    Grupo grupo;

    public CheckBoxMarcarGrupoEventHandler(Respuesta respuesta, Opcion opcion, Button botonEnviar, RadioButton radioButton, Grupo grupo){
        this.respuesta = respuesta;
        this.opcion = opcion;
        this.botonEnviar = botonEnviar;
        this.radioButton = radioButton;
        this.grupo = grupo;

    }

    @Override
    public void handle(Event event) {

        respuesta.marcar(opcion, new Valor(this.grupo));
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
