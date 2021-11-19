package starter.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

@DefaultUrl("https://decemberlabs.com/")
public class GetInTouch extends PageObject {

    @FindBy(id = "name")
    WebElementFacade name;

    @FindBy(id = "email")
    WebElementFacade email;

    @FindBy(id = "message")
    WebElementFacade message;

    @FindBy(id = "company")
    WebElementFacade company;

    @FindBy(name = "budget")
    List<WebElementFacade> budgetList;

    @FindBy(name = "hearus")
    List<WebElementFacade> hearusList;

    @FindBy(xpath = "//input[@id='newsletter']/parent::span")
    WebElementFacade newsletter;

    @FindBy(xpath = "//input[@value='Send']")
    WebElementFacade sendButton;

    @FindBy(xpath = "//span[text()='Thanks for reaching out!']")
    WebElementFacade congrats;


    public boolean elementsAreDisplayed() {
        return name.isDisplayed()
                & email.isDisplayed()
                & message.isDisplayed()
                & company.isDisplayed()
                & budgetList.size() > 0
                & hearusList.size() > 0
                & newsletter.isDisplayed()
                & sendButton.isDisplayed();
    }

    public void fillName(String name) {
        this.name.clear();
        this.name.sendKeys(name);
    }

    public String getName() {
        return this.name.getValue();
    }

    public boolean isNameMarkedAsMandatory() {
        return this.name.getAttribute("required").equals("true") &
                this.name.then(By.xpath("./parent::div")).getAttribute("class").contains("warning");
    }

    public void fillEmail(String email) {
        this.email.clear();
        this.email.sendKeys(email);
    }

    public String getEmail() {
        return this.email.getValue();
    }

    public boolean isEmailMarkedAsMandatory() {
        return this.email.getAttribute("required").equals("true") &
                this.email.then(By.xpath("./parent::div")).getAttribute("class").contains("warning");
    }

    public void fillMessage(String message) {
        this.message.clear();
        this.message.sendKeys(message);
    }

    public String getMessage() {
        return this.message.getValue();
    }

    public boolean isMessageMarkedAsMandatory() {
        return this.message.getAttribute("required").equals("true") &
                this.message.then(By.xpath("./parent::div")).getAttribute("class").contains("warning");
    }

    public void fillCompany(String company) {
        this.company.clear();
        this.company.sendKeys(company);
    }

    public String getCompany() {
        return this.company.getValue();
    }

    public void clickOnSendButton() {
        this.sendButton.click();
    }

    public void selectNewsletter(boolean sel) {
        if (this.newsletter.getAttribute("class").equals("checked") != sel)
            this.newsletter.click();
    }

    public boolean getNewsletterIsChecked() {
        return this.newsletter.getAttribute("class").equals("checked");
    }

    public void selectAllBudgets() {
        for (WebElementFacade element : budgetList) {
            element.click();
        }
    }

    public void selectBudget(String budget) {
        for (WebElementFacade element : budgetList) {
            if (Objects.equals(element.getAttribute("value"), budget)) {
                element.click();
                break;
            }
        }
    }

    public String getSelectedBudget() {
        for (WebElementFacade element : budgetList) {
            if (element.isSelected())
                return element.getAttribute("value").toString();
        }
        return "";
    }

    public void selectAllHearUs() {
        for (WebElementFacade element : hearusList) {
            element.click();
        }
    }

    public void selectHearUs(String hearUs) {
        for (WebElementFacade element : hearusList) {
            if (Objects.equals(element.getAttribute("value"), hearUs)) {
                element.click();
                break;
            }
        }
    }

    public String getSelectedHearUs() {
        for (WebElementFacade element : hearusList) {
            if (element.isSelected())
                return element.getAttribute("value").toString();
        }
        return "";
    }

    public boolean isCongratsDisplayed(){
        return congrats.isDisplayed();
    }
}
