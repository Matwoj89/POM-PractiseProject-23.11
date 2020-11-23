package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUs extends PageObject{

    public ContactUs(WebDriver driver){
        super(driver);
    }

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy(css = "div.alert")
    private WebElement errorAlert;

    @FindBy(id = "id_contact")
    private WebElement subjectSelect;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(id = "id_order")
    private WebElement orderInput;

    @FindBy(id = "message")
    private WebElement messageTextArea;

    @FindBy(css = "p.alert-success")
    private WebElement successAlert;

    public ContactUs clickOnSendButton(){
        sendButton.click();
        return this;
    }

    public WebElement getErrorAlert(){
        return errorAlert;
    }

    public boolean isErrorAllertDisplayed() {
        return getErrorAlert().isDisplayed();
    }

    public ContactUs selectSubject(){
        new Select(subjectSelect).selectByIndex(1);
        return this;
    }

    public ContactUs enterEmail(){
        emailInput.sendKeys("test@mail.com");
        return this;
    }

    public ContactUs enterOrder(){
        orderInput.sendKeys("123234");
        return this;
    }

    public ContactUs enterMessage(){
        messageTextArea.sendKeys("Lorem Ipsum");
        return this;
    }

    public boolean isSuccessAlertVisible(){
        return successAlert.isDisplayed();
    }
}
