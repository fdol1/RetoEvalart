package co.com.ProyectoBase.Screenplay.interactions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import java.util.List;

public class SeleccionarMultiplo implements Interaction {

    private final Target listaOpciones;
    private final int multiplo;
    public SeleccionarMultiplo(Target listaOpciones, int multiplo) {
        this.listaOpciones = listaOpciones;
        this.multiplo = multiplo;
    }

    public static SeleccionarMultiplo porOpcion(Target listaOpciones, int multiplo) {
        return new SeleccionarMultiplo(listaOpciones, multiplo);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<WebElementFacade> listaOpcines = listaOpciones.resolveAllFor(actor);

        for (int i = 0; i < listaOpcines.size(); i++) {
            int numero = Integer.parseInt(listaOpcines.get(i).getText().trim());
            if(numero % multiplo == 0){
                listaOpcines.get(i).click();
            }
        }
    }
}