package co.com.ProyectoBase.Screenplay.tasks;

import co.com.ProyectoBase.Screenplay.interactions.Scroll;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.INPUT_FECHA;
import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.LBL_FECHA_INICIAL;
import static co.com.ProyectoBase.Screenplay.util.Utils.fechaDesde;

public class EncontrarFecha implements Task {
    public EncontrarFecha() {
    }

    public static EncontrarFecha desde() {
        return Tasks.instrumented(EncontrarFecha.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Enter.theValue(fechaDesde(String.valueOf(Text.of(LBL_FECHA_INICIAL).viewedBy(actor).asString()))).into(INPUT_FECHA),
                Scroll.byPixels(500));
    }
}