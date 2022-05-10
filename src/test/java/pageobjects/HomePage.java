package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

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

    private String cartElementsLocator = "//figure/following-sibling::div";


    @FindBy(xpath = "//div[@id='pizza__list']/descendant::node()[text()='Маргарита']/ancestor::node()/following-sibling::*/button")
    private WebElement buttonAdd;

    @FindBy(xpath = "//aside")
    private WebElement cart;

    public HomePage clickMinsk() {
        buttonMinsk.click();
        return this;
    }
    public HomePage clickAddPizzaToCart() {
        buttonAdd.click();
        return this;
    }

    public boolean isPizzaInCart(String pizza) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(cart));
        List<WebElement> elements = driver.findElements(By.xpath(cartElementsLocator));
        List<String> productCollect = elements.stream().map(s -> s.getText()).collect(Collectors.toList());

        String pr = productCollect.toString();
        return pr.contains(pizza);
    }
}
