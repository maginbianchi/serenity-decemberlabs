package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://decemberlabs.com/")
public class Home extends PageObject {

    @FindBy(xpath = "//a[text()='Get in touch']")
    WebElementFacade getInTouchButton;

    @FindBy(id = "hearus")
    WebElementFacade modal;

    public void clickOnGetInTouch() {
        getInTouchButton.click();
        try {
            Thread.sleep(45000); //No es necesaria ya que esta el implicitWait pero la agrego para que se vea la ejecución
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
