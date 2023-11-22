package co.com.ProyectoBase.Screenplay.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;

public class Scroll implements Interaction {
    private final int pixelsToScroll;
    public Scroll(int pixelsToScroll) {
        this.pixelsToScroll = pixelsToScroll;
    }
    public static Scroll byPixels(int pixelsToScroll) {
        return new Scroll(pixelsToScroll);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) BrowseTheWeb.as(actor).getDriver();
        jsExecutor.executeScript("window.scrollBy(0, " + pixelsToScroll + ");");
    }
}
