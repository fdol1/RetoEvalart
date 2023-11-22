package co.com.ProyectoBase.Screenplay.tasks;

import co.com.ProyectoBase.Screenplay.interactions.Scroll;
import co.com.ProyectoBase.Screenplay.interactions.SeleccionarResultado;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.LBL_OPERACION_MATEMATICA;
import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.LISTA_RESULTADOS;
import static co.com.ProyectoBase.Screenplay.util.Constantes.LLAVE_OPERACION_MAT;
import static co.com.ProyectoBase.Screenplay.util.Utils.calcular;

public class RealizarOperacion implements Task {

    public RealizarOperacion() {
    }

    public static RealizarOperacion matematica() {
        return Tasks.instrumented(RealizarOperacion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        int resultado = calcular(Text.of(LBL_OPERACION_MATEMATICA).viewedBy(actor).asString());
        actor.remember(LLAVE_OPERACION_MAT, resultado);

        actor.attemptsTo(
                Scroll.byPixels(500),
                SeleccionarResultado.porOpcion(LISTA_RESULTADOS,String.valueOf(resultado))
        );
    }
}