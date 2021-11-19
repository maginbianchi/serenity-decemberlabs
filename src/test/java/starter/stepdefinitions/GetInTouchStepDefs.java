package starter.stepdefinitions;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import org.fluentlenium.core.annotation.Page;
import starter.entities.Form;
import starter.pages.GetInTouch;
import starter.pages.Home;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class GetInTouchStepDefs {

    @Page
    Home home;

    @Page
    GetInTouch getInTouch;

    @Dado("que soy un usuario que se encuentra en la pagina Get In Touch")
    public void queSoyUnUsuarioQueSeEncuentraEnLaPaginaGetInTouch() {
        home.open();
        home.clickOnGetInTouch();
    }

    @Cuando("intento utilizar los diferentes componentes")
    public void intentoUtilizarLosDiferentesComponentes() {
        assertThat(getInTouch.elementsAreDisplayed()).isTrue();

        getInTouch.fillName("Magin");
        getInTouch.fillEmail("test@decemberlabs.com");
        getInTouch.fillMessage("Este es un msg de prueba");
        getInTouch.fillCompany("Google");
        getInTouch.selectAllBudgets();
        getInTouch.selectAllHearUs();
        getInTouch.selectNewsletter(false);
    }

    @Entonces("los componentes funcionan correctamente")
    public void losComponentesFuncionanCorrectamente() {
        assertThat(getInTouch.getName()).isEqualTo("Magin");
        assertThat(getInTouch.getEmail()).isEqualTo("test@decemberlabs.com");
        assertThat(getInTouch.getMessage()).isEqualTo("Este es un msg de prueba");
        assertThat(getInTouch.getCompany()).isEqualTo("Google");
        assertThat(getInTouch.getSelectedBudget()).isEqualTo("Above $200K");
        assertThat(getInTouch.getSelectedHearUs()).isEqualTo("Other");
        assertThat(getInTouch.getNewsletterIsChecked()).isFalse();
    }

    @Cuando("intento enviar el formulario sin completar el campo nombre")
    public void intentoEnviarElFormularioSinCompletarElCampoNombre() {
        getInTouch.fillEmail("test@decemberlabs.com");
        getInTouch.fillMessage("Este es un msg de prueba");
        getInTouch.fillCompany("Google");
        getInTouch.selectAllBudgets();
        getInTouch.selectAllHearUs();
        getInTouch.selectNewsletter(false);
        getInTouch.clickOnSendButton();
    }

    @Entonces("el sitio me informa que el campo nombre es requerido")
    public void elSitioMeInformaQueElCampoNombreEsRequerido() {
        assertThat(getInTouch.isNameMarkedAsMandatory()).isTrue();
    }

    @Cuando("intento enviar el formulario sin completar el campo email")
    public void intentoEnviarElFormularioSinCompletarElCampoEmail() {
        getInTouch.fillName("Magin");
        getInTouch.fillMessage("Este es un msg de prueba");
        getInTouch.fillCompany("Google");
        getInTouch.selectAllBudgets();
        getInTouch.selectAllHearUs();
        getInTouch.selectNewsletter(false);
        getInTouch.clickOnSendButton();
    }

    @Entonces("el sitio me informa que el campo email es requerido")
    public void elSitioMeInformaQueElCampoEmailEsRequerido() {
        assertThat(getInTouch.isEmailMarkedAsMandatory()).isTrue();
    }

    @Cuando("intento enviar el formulario sin completar el campo mensaje")
    public void intentoEnviarElFormularioSinCompletarElCampoMensaje() {
        getInTouch.fillName("Magin");
        getInTouch.fillEmail("test@decemberlabs.com");
        getInTouch.fillCompany("Google");
        getInTouch.selectAllBudgets();
        getInTouch.selectAllHearUs();
        getInTouch.selectNewsletter(false);
        getInTouch.clickOnSendButton();
    }

    @Entonces("el sitio me informa que el campo mensaje es requerido")
    public void elSitioMeInformaQueElCampoMensajeEsRequerido() {
        assertThat(getInTouch.isMessageMarkedAsMandatory()).isTrue();
    }

    @Cuando("intento enviar el formulario con los siguientes datos:")
    public void intentoEnviarElFormularioConLosSiguientesDatos(DataTable dataTable) {
        List<Map<String,String>> mapList = dataTable.transpose().asMaps();
        Form form = new ObjectMapper().convertValue(mapList.get(0), Form.class);

        getInTouch.fillName(form.getName());
        getInTouch.fillEmail(form.getEmail());
        getInTouch.fillMessage(form.getMessage());
        getInTouch.fillCompany(form.getCompany());
        getInTouch.selectBudget(form.getBudget());
        getInTouch.selectHearUs(form.getHouYouHearAbout());
        getInTouch.selectNewsletter(Boolean.parseBoolean(form.getUpdates()));
        getInTouch.clickOnSendButton();
    }

    @Entonces("el sitio muestra un congrats")
    public void elSitioMuestraUnCongrats() {
        assertThat(getInTouch.isCongratsDisplayed()).isTrue();
    }
}
