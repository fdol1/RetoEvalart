package co.com.ProyectoBase.Screenplay.stepdefinitions;

import co.com.ProyectoBase.Screenplay.model.InicioDeSesionModel;
import co.com.ProyectoBase.Screenplay.questions.VerificarInicioDeSesion;
import co.com.ProyectoBase.Screenplay.tasks.AbrirNavegador;
import co.com.ProyectoBase.Screenplay.tasks.IniciarSesion;
import cucumber.api.java.Before;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class IniciarSesionstepDefinition {

    @Before
    public void configuracionInicial(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Dado("^que (.*) ingresa a la pagina de Evalart$")
    public void queFerIngresaALaPaginaDeEvalart(String actor) {
        theActorCalled(actor).wasAbleTo(AbrirNavegador.enEvalart());
    }
    @Dado("^que fer ingresa sus credenciales$")
    public void queFerIngresaSusCredenciales(List<InicioDeSesionModel> inicioDeSesionModelList) {
        theActorInTheSpotlight().attemptsTo(IniciarSesion.enEvalart(inicioDeSesionModelList.get(0)));
    }
    @Entonces("^Entonces verifica el titulo (.*)$")
    public void entoncesVerificaElTitulo(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarInicioDeSesion.alIngresarLasCredenciales(mensaje)));
    }
}