package co.com.ProyectoBase.Screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.LBL_CANTIDAD_CICLO;
import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.LBL_CANTIDA_LETRA;
import static co.com.ProyectoBase.Screenplay.util.Constantes.LLAVE_CANTIDAD_V;
import static co.com.ProyectoBase.Screenplay.util.Constantes.LLAVE_CICLOS;
import static co.com.ProyectoBase.Screenplay.util.Utils.encontrarCiclos;
import static co.com.ProyectoBase.Screenplay.util.Utils.encontrarCiclosLetra;

public class ObtenerCantidad implements Task {

    public ObtenerCantidad() {
    }

    public static ObtenerCantidad deVecesAIngresarV() {
        return Tasks.instrumented(ObtenerCantidad.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.remember(LLAVE_CANTIDAD_V, encontrarCiclosLetra(Text.of(LBL_CANTIDA_LETRA).viewedBy(actor).asString()));
        actor.remember(LLAVE_CICLOS, encontrarCiclos(Text.of(LBL_CANTIDAD_CICLO).viewedBy(actor).asString()));
    }
}
