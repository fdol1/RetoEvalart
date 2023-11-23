package co.com.ProyectoBase.Screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiProcesoFinalizado {

    public static final Target LBL_MENSAJE_PROCESO_EXITOSO = Target.the("campo que contiene el mensaje de finalizacion exitoso").located(By.xpath("//h1[@class = 'text-center text-3xl p-5']"));

}
