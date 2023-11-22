package co.com.ProyectoBase.Screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.LBL_MENSAJE_ERROR;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarMensajeDeError implements Question<Boolean> {

    private final String mensaje;
    public VerificarMensajeDeError(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarMensajeDeError alEnviarLosDatos(String mensaje){
        return new VerificarMensajeDeError(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_MENSAJE_ERROR,isVisible()).forNoMoreThan(10).seconds()
        );
        return mensaje.equals(Text.of(LBL_MENSAJE_ERROR).viewedBy(actor).asString());
    }
}