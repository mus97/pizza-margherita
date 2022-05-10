package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends AbstractPage {
    private final String BASE_URL = "https://papajohns.by/";


    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage() {
        driver.get(BASE_URL);
        return this;
    }

    @FindBy (xpath = "//header/descendant::button/span[text()='Да']")
    private WebElement buttonMinsk;

    @FindBy (xpath = "//figure/following-sibling::div")
    private WebElement cartElementsLocator;

    @FindBy(xpath = "//div[@id='pizza__list']/descendant::node()[text()='Маргарита']/ancestor::node()/following-sibling::*/button")
    private WebElement buttonAdd;

    @FindBy(xpath = "//aside")
    private WebElement cart;

    public HomePage clickMinsk() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(cart));
        buttonMinsk.click();
        return this;
    }
    public HomePage clickAddPizzaToCart() {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(cart));
        buttonAdd.click();
        return this;
    }

    public boolean isPizzaInCart(String pizza) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(cart));
        String pr = cartElementsLocator.getText();
        return pr.contains(pizza);
    }
}
