package co.com.ProyectoBase.Screenplay.tasks;

import co.com.ProyectoBase.Screenplay.userinterface.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

public class AbrirNavegador implements Task {

    private HomePage homePage;

    public static AbrirNavegador enEvalart() {
        return Tasks.instrumented(AbrirNavegador.class);

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn(homePage));
        BrowseTheWeb.as(actor).getDriver().manage().window().maximize();
    }
}
