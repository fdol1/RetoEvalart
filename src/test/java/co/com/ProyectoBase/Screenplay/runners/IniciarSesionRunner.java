package co.com.ProyectoBase.Screenplay.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/iniciarSesion.feature",
        tags = "@IniciarSesion",
        glue = {"co.com.ProyectoBase.Screenplay"},
        snippets = SnippetType.CAMELCASE
)

public class IniciarSesionRunner {
}
