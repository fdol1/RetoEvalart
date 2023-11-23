package co.com.ProyectoBase.Screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.*;
import static co.com.ProyectoBase.Screenplay.util.Constantes.*;
import static co.com.ProyectoBase.Screenplay.util.Utils.*;

public class ObtenerDatos implements Task {

    public ObtenerDatos() {
    }

    public static ObtenerDatos deVecesAIngresarV() {
        return Tasks.instrumented(ObtenerDatos.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.remember(LLAVE_CICLOS_TOTALES, encontrarCiclos(Text.of(LBL_CANTIDAD_CICLO).viewedBy(actor).asString()));
    }
}