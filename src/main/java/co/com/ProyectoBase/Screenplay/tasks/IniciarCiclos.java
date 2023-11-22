package co.com.ProyectoBase.Screenplay.tasks;

import co.com.ProyectoBase.Screenplay.model.AccionesModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.*;
import static co.com.ProyectoBase.Screenplay.util.Constantes.LLAVE_CANTIDAD_V;
import static co.com.ProyectoBase.Screenplay.util.Constantes.LLAVE_CICLOS;

public class IniciarCiclos implements Task {

    private final AccionesModel accionesModel;

    public IniciarCiclos(AccionesModel accionesModel) {
        this.accionesModel = accionesModel;
    }

    public static IniciarCiclos enEvalart(AccionesModel accionesModel) {
        return Tasks.instrumented(IniciarCiclos.class, accionesModel);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        int cicloLetras = actor.recall(LLAVE_CANTIDAD_V);
        int ciclo = actor.recall(LLAVE_CICLOS);
        String cadena = "";
        for (int i = 0; i < cicloLetras; i++) {
            cadena += accionesModel.getLetra();
        }

        for (int i = 0; i < ciclo; i++) {
            if (LBL_MENSAJE_ERROR.resolveFor(actor).isVisible()) {
                break;
            } else {
                actor.attemptsTo(
                        WaitUntil.the(TXT_TEXTO, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                        Enter.theValue(cadena).into(TXT_TEXTO),
                        EncontrarFecha.desde(),
                        RealizarOperacion.matematica(),
                        VerificarMultiplos.de7(),
                        Click.on(BTN_ENVIAR)
                );
            }
        }
    }
}