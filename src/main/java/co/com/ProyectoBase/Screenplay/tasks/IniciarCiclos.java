package co.com.ProyectoBase.Screenplay.tasks;

import co.com.ProyectoBase.Screenplay.interactions.FalsaEspera;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.*;
import static co.com.ProyectoBase.Screenplay.util.Constantes.*;
import static co.com.ProyectoBase.Screenplay.util.Utils.*;
import static co.com.ProyectoBase.Screenplay.util.Utils.encontrarNumerosEnCadena;

public class IniciarCiclos implements Task {


    public IniciarCiclos() {
    }

    public static IniciarCiclos enEvalart() {
        return Tasks.instrumented(IniciarCiclos.class);
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        int ciclo = actor.recall(LLAVE_CICLOS_TOTALES);

        for (int i = 0; i < ciclo; i++) {
            if (LBL_MENSAJE_ERROR.resolveFor(actor).isVisible()) {
                break;
            } else {
                int cicloLetras = encontrarCiclosLetra(Text.of(LBL_LETRA_CANTIDAD).viewedBy(actor).asString());
                String cadena = encontrarLetra(Text.of(LBL_LETRA_CANTIDAD).viewedBy(actor).asString());
                String texto ="";
                String fecha="";
                for (int j = 0; j < cicloLetras; j++) {
                    texto+= cadena;
                }

                if(decision(Text.of(LBL_FECHA_INICIAL).viewedBy(actor).asString()).equals("desde antes de")){
                     fecha = fechaDesdeAntesDe(String.valueOf(Text.of(LBL_FECHA_INICIAL).viewedBy(actor).asString()),
                            encontrarNumerosEnCadena(String.valueOf(Text.of(LBL_FECHA_INICIAL).viewedBy(actor).asString())));
                }
                else{
                    fecha = fechaDespuesDe(String.valueOf(Text.of(LBL_FECHA_INICIAL).viewedBy(actor).asString()),
                            encontrarNumerosEnCadena(String.valueOf(Text.of(LBL_FECHA_INICIAL).viewedBy(actor).asString())));
                }


                actor.attemptsTo(
                        WaitUntil.the(TXT_TEXTO, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                        Enter.theValue(texto).into(TXT_TEXTO),
                        Enter.theValue(fecha).into(INPUT_FECHA),
                        RealizarOperacion.matematica(),
                        VerificarMultiplos.conVariables(),
                        Click.on(BTN_ENVIAR)
                );
            }
        }
        actor.attemptsTo(FalsaEspera.enPantalla(30000000));
    }
}