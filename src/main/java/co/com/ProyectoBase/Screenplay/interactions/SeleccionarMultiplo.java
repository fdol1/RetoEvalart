package co.com.ProyectoBase.Screenplay.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class SeleccionarMultiplo implements Interaction {

    private Target listaOpciones;
    public SeleccionarMultiplo(Target listaOpciones) {
        this.listaOpciones = listaOpciones;
    }

    public static SeleccionarMultiplo porOpcion(Target listaOpciones) {
        return new SeleccionarMultiplo(listaOpciones);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listaOpcines = listaOpciones.resolveAllFor(actor);

        for (int i = 0; i < listaOpcines.size(); i++) {
            int numero = Integer.parseInt(listaOpcines.get(i).getText().trim());
            if(numero % 7 == 0){
                listaOpcines.get(i).click();
            }
        }
    }
}