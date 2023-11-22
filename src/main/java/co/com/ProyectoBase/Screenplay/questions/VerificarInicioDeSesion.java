package co.com.ProyectoBase.Screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.LBL_TITULO;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VerificarInicioDeSesion implements Question<Boolean> {

    private final String mensaje;
    public VerificarInicioDeSesion(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarInicioDeSesion alIngresarLasCredenciales(String mensaje){
        return new VerificarInicioDeSesion(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_TITULO,isVisible()).forNoMoreThan(10).seconds()
        );
        return mensaje.equals(Text.of(LBL_TITULO).viewedBy(actor).asString());
    }
}