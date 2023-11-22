package co.com.ProyectoBase.Screenplay.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class SeleccionarResultado implements Interaction {

    private Target listaOpciones;
    private String opcion;

    public SeleccionarResultado(Target listaOpciones, String opcion) {
        this.listaOpciones = listaOpciones;
        this.opcion = opcion;
    }

    public static SeleccionarResultado porOpcion(Target listaOpciones, String opcion) {
        return new SeleccionarResultado(listaOpciones, opcion);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listaOpcines = listaOpciones.resolveAllFor(actor);

        for (int i = 0; i < listaOpcines.size(); i++) {
            if (listaOpcines.get(i).getText().trim().equals(opcion)) {
                listaOpcines.get(i).click();
                break;
            }
        }
    }
}