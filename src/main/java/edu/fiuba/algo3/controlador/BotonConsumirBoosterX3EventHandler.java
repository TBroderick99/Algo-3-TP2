package edu.fiuba.algo3.controlador;

        import edu.fiuba.algo3.modelo.preguntas.boosters.Booster;
        import edu.fiuba.algo3.modelo.Turno;
        import javafx.scene.control.Button;

public class BotonConsumirBoosterX3EventHandler extends ConsumirBoosterEventHandler {
    protected int FACTOR_MULTIPLICACION;

    public BotonConsumirBoosterX3EventHandler(Button boton, Turno turnoActual){
        super(boton, turnoActual);
        this.FACTOR_MULTIPLICACION = 3;
    }

    public Booster consumirBooster(){
        return turnoActual.getJugador().getBoosterMultiplicador(FACTOR_MULTIPLICACION);
    }
}