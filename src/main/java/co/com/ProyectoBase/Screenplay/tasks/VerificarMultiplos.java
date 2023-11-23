package co.com.ProyectoBase.Screenplay.tasks;

import co.com.ProyectoBase.Screenplay.interactions.Scroll;
import co.com.ProyectoBase.Screenplay.interactions.SeleccionarMultiplo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.LBL_NUMERO_MULTIPLO;
import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.LISTA_MULTIPLOS;
import static co.com.ProyectoBase.Screenplay.util.Utils.encontrarNumerosEnCadena;

public class VerificarMultiplos implements Task {

    public VerificarMultiplos() {
    }

    public static VerificarMultiplos conVariables() {
        return Tasks.instrumented(VerificarMultiplos.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.byPixels(500),
                SeleccionarMultiplo.porOpcion(LISTA_MULTIPLOS,encontrarNumerosEnCadena(Text.of(LBL_NUMERO_MULTIPLO).viewedBy(actor).asString()))
        );
    }
}