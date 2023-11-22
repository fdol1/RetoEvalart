package co.com.ProyectoBase.Screenplay.tasks;

import co.com.ProyectoBase.Screenplay.interactions.Scroll;
import co.com.ProyectoBase.Screenplay.interactions.SeleccionarMultiplo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.LISTA_MULTIPLOS;

public class VerificarMultiplos implements Task {

    public VerificarMultiplos() {
    }

    public static VerificarMultiplos de7() {
        return Tasks.instrumented(VerificarMultiplos.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.byPixels(500),
                SeleccionarMultiplo.porOpcion(LISTA_MULTIPLOS)
        );

    }
}