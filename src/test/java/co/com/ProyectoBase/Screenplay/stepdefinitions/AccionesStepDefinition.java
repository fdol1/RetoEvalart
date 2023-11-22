package co.com.ProyectoBase.Screenplay.stepdefinitions;

import co.com.ProyectoBase.Screenplay.model.AccionesModel;
import co.com.ProyectoBase.Screenplay.questions.VerificarMensajeDeError;
import co.com.ProyectoBase.Screenplay.tasks.*;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Dado;
import cucumber.api.java.es.Entonces;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class AccionesStepDefinition {

    @Dado("^que fer verifica la cantidad de veces a ingresar$")
    public void queFerVerificaLaCantidadDeVecesAIngresar() {
        theActorInTheSpotlight().attemptsTo(ObtenerCantidad.deVecesAIngresarV());
    }
    @Cuando("^Cuando realiza las interacciones con los elementos$")
    public void cuandoRealizaLasInteraccionesConLosElementos(List<AccionesModel> accionesModelList) {
        theActorInTheSpotlight().attemptsTo(IniciarCiclos.enEvalart(accionesModelList.get(0)));
    }
    @Entonces("^Verifica el mensaje: (.*)$")
    public void verificaElMensaje(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeDeError.alEnviarLosDatos(mensaje)));
    }
}