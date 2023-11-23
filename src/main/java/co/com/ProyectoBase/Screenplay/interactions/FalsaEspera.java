package co.com.ProyectoBase.Screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

import java.util.logging.Logger;

public class FalsaEspera implements Interaction {

    private final int tiempo;

    public FalsaEspera(int tiempo) {
        this.tiempo = tiempo;
    }

    public static FalsaEspera enPantalla(int tiempo) {
        return Tasks.instrumented(FalsaEspera.class, tiempo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            Thread.sleep(tiempo);
            Logger.getAnonymousLogger().info("El tiempo de espera de : " + (tiempo/1000) + " segundos, ha terminado");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}