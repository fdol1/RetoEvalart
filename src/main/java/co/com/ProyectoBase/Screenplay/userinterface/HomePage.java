package co.com.ProyectoBase.Screenplay.userinterface;

import co.com.ProyectoBase.Screenplay.util.Constantes;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

@DefaultUrl(Constantes.URL)
public class HomePage extends PageObject {
    public static final Target TXT_USUARIO = Target.the("Campo para ingresar el usuario").located(By.xpath("//html[1]/body[1]/div[1]/div[2]/form[1]/input[1]"));
    public static final Target TXT_CLAVE = Target.the("Campo para ingresar la clave").located(By.xpath("//html[1]/body[1]/div[1]/div[2]/form[1]/input[2]"));
    public static final Target BTN_INICIAR_SESION = Target.the("boton para ingresar al perfil").located(By.xpath("//button[@class= 'bg-white border-black p-2 border-2 rounded-md hover:bg-blue-300 w-1/2 mx-auto']"));
}