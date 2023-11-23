package co.com.ProyectoBase.Screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.questions.Text;

import static co.com.ProyectoBase.Screenplay.userinterface.UiPaginaPrincipal.*;
import static co.com.ProyectoBase.Screenplay.util.Constantes.*;
import static co.com.ProyectoBase.Screenplay.util.Utils.*;

public class ObtenerDatos implements Task {

    public ObtenerDatos() {
    }

    public static ObtenerDatos deVecesAIngresarV() {
        return Tasks.instrumented(ObtenerDatos.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.remember(LLAVE_CICLOS_TOTALES, encontrarCiclos(Text.of(LBL_CANTIDAD_CICLO).viewedBy(actor).asString()));

        actor.remember(LLAVE_CANTIDAD_LETRA, encontrarCiclosLetra(Text.of(LBL_LETRA_CANTIDAD).viewedBy(actor).asString()));
        actor.remember(LLAVE_LETRA, encontrarLetra(Text.of(LBL_LETRA_CANTIDAD).viewedBy(actor).asString()));

        actor.remember(LLAVE_DIAS_ENCONTRADOS, encontrarNumerosEnCadena(String.valueOf(Text.of(LBL_FECHA_INICIAL).viewedBy(actor).asString())));
        actor.remember(LLAVE_FECHA_ENCONTRADA, fechaDesdeAntesDe(String.valueOf(Text.of(LBL_FECHA_INICIAL).viewedBy(actor).asString()),
                encontrarNumerosEnCadena(String.valueOf(Text.of(LBL_FECHA_INICIAL).viewedBy(actor).asString()))));


        System.out.println("cantidad de letras " + actor.recall(LLAVE_CANTIDAD_LETRA));
        System.out.println("letra " + actor.recall(LLAVE_LETRA));
        System.out.println("Dias " + actor.recall(LLAVE_DIAS_ENCONTRADOS));
        System.out.println("fecha encontrada " + actor.recall(LLAVE_FECHA_ENCONTRADA));


    }
}
