package co.com.ProyectoBase.Screenplay.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class UiPaginaPrincipal {
    public static final Target LBL_TITULO = Target.the("campo con la palabra Prueba de automatización").located(By.xpath("//h1[@class = 'text-center text-3xl p-3 m-3']"));
    public static final Target TXT_TEXTO = Target.the("Campo para ingresar la letra V 290 veces").located(By.xpath("//textarea[@class = 'border-2 border-black rounded-sm p-2 resize-y']"));
    public static final Target LBL_LETRA_CANTIDAD = Target.the("Campo que contiene la cantidad de veces a ingresar la letra").located(By.xpath("//p[@class = 'text-center text-xl'][1]"));
    public static final Target LBL_OPERACION_MATEMATICA = Target.the("Campo con la operacion matematica a realizar").located(By.xpath("//p[@class = 'text-center text-xl font-bold']"));
    public static final Target LISTA_RESULTADOS = Target.the("Lista con los resultados de la operacion matematica").located(By.xpath("//body[1]/div[2]/form[1]/div[1]/div[2]/div[1]/label"));
    public static final Target LISTA_RESULTADOS_ITEM = Target.the("Item de la lista").located(By.xpath("//body[1]/div[2]/form[1]/div[1]/div[3]/div[1]/label/input"));
    public static final Target LISTA_MULTIPLOS = Target.the("Lista con numeros para validar si son multiplos de 7").located(By.xpath("//body[1]/div[2]/form[1]/div[1]/div[4]/div[1]/label"));
    public static final Target INPUT_FECHA = Target.the("Campo donde se ingresa la fecha calculada").located(By.xpath("//input[@class = 'border-2 border-black rounded-sm p-2']"));
    public static final Target LBL_FECHA_INICIAL = Target.the("Fecha desde donde se calcula").located(By.xpath("//div[@class = 'flex flex-col items-center p-4 space-y-5 bg-white rounded-md w-2/5 shadow-md my-5']//p"));
    public static final Target BTN_ENVIAR = Target.the("Boton para enviar").located(By.xpath("//button[@class = ' border-black p-2 border-2 rounded-md mx-auto hover:bg-blue-300']"));
    public static final Target LBL_MENSAJE_ERROR = Target.the("Mensaje de error").located(By.xpath("//p[@class = 'text-2xl text-center text-red-500']"));
    public static final Target LBL_CANTIDAD_CICLO = Target.the("cantidad de veces a repetir el ciclo").located(By.xpath("//p[@class = 'text-xl text-center text-green-500']"));
    public static final Target LBL_NUMERO_MULTIPLO = Target.the("numero multiplo").located(By.xpath("//div[@class = 'bg-white rounded-md shadow-md p-5 flex flex-col items-center my-5 w-2/5 ']//p"));

}


