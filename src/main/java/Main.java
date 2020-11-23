import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.ContactUs;
import page.SignIn;
import page.TopMenu;


public class Main {

    private static WebDriver driver;
    private static TopMenu topMenu;
    private static ContactUs contactUs;
    private static SignIn signIn;

    @BeforeAll
    public static void beforeAll() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        topMenu = new TopMenu(driver);
        contactUs = new ContactUs(driver);
        signIn = new SignIn(driver);
    }

    @BeforeEach
    public void beforeEach() {
        driver.get("http://automationpractice.com/");
    }

    @AfterAll
    public static void afterAll() {
        driver.quit();
    }

    @Test
    public void checkTitle() {
        Assertions.assertEquals(driver.getTitle(), "My Store");
    }

    @Test
    public void canNotSendContactUsMessageWithEmptyEmail() {
        topMenu.clickOnContactUsButton();
        contactUs.clickOnSendButton();

        Assertions.assertTrue(contactUs.isErrorAllertDisplayed());
    }

    @Test
    public void canNotCreatAnAccountWithoutEmail() {
        topMenu.clickOnSignInButton();
        signIn.clickCreateAccountButton();

        Assertions.assertTrue(signIn.isCreateAccountErrorVisible());
    }

    @Test
    public void sendContactAsMessage() {
        topMenu.clickOnContactUsButton();
        contactUs.selectSubject()
                .enterEmail()
                .enterOrder()
                .enterMessage()
                .clickOnSendButton();

        Assertions.assertTrue(contactUs.isSuccessAlertVisible());
    }
}
