package co.com.ProyectoBase.Screenplay.tasks;

import co.com.ProyectoBase.Screenplay.model.InicioDeSesionModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.ProyectoBase.Screenplay.userinterface.HomePage.*;

public class IniciarSesion implements Task {

    private final InicioDeSesionModel inicioDeSesionModel;

    public IniciarSesion(InicioDeSesionModel inicioDeSesionModel) {
        this.inicioDeSesionModel = inicioDeSesionModel;
    }

    public static IniciarSesion enEvalart(InicioDeSesionModel inicioDeSesionModel) {
        return Tasks.instrumented(IniciarSesion.class, inicioDeSesionModel);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitUntil.the(TXT_USUARIO, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(inicioDeSesionModel.getUsuario()).into(TXT_USUARIO),
                Click.on(TXT_CLAVE),
                Enter.theValue(inicioDeSesionModel.getClave()).into(TXT_CLAVE),
                Click.on(BTN_INICIAR_SESION)
        );
    }
}