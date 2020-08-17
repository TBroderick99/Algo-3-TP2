package edu.fiuba.algo3.controlador;

        import edu.fiuba.algo3.modelo.Booster;
        import edu.fiuba.algo3.modelo.Partida;
        import javafx.scene.control.Button;

public class BotonConsumirBoosterX3EventHandler extends ConsumirBoosterEventHandler {
    protected int FACTOR_MULTIPLICACION;

    public BotonConsumirBoosterX3EventHandler(Button boton){
        super(boton);
        this.FACTOR_MULTIPLICACION = 3;
    }

    public Booster consumirBooster(){
        return Partida.getInstance().getJugadorActual().getBoosterMultiplicador(FACTOR_MULTIPLICACION);
    }
}