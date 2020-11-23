package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SignIn extends PageObject {

    public SignIn(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#SubmitCreate")
    private WebElement createAccountButton;

    @FindBy(id = "create_account_error")
    private WebElement createAccountError;

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }

    public boolean isCreateAccountErrorVisible() {
        wait.until(ExpectedConditions.visibilityOf(createAccountError));
        return createAccountError.isDisplayed();
    }
}
