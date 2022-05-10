package test;

import org.junit.jupiter.api.Test;
import pageobjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PapaTest extends AbstractTest {
    private final String pizza = "Маргарита";

    @Test
    public void testAddPizzaToCart() {
        HomePage homePage = new HomePage(driver)
                .openPage().clickMinsk()
                .clickAddPizzaToCart();
        assertTrue( (homePage.isPizzaInCart(pizza)));
    }
}
