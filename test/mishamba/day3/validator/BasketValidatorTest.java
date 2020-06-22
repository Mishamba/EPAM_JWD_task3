package mishamba.day3.validator;

import com.mishamba.day3.validator.BasketValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BasketValidatorTest {

    @DataProvider(name = "validBaskets")
    public Object[][] validBasketFactory() {
        return new Object[][] {
                {150, 30},
                {250, 80},
                {100, 50}
        };
    }

    @Test(dataProvider = "validBaskets", groups = "valid")
    public void correctBasketData_valid(double capacity, double maxWeight) {
        BasketValidator validator = new BasketValidator();
        boolean actual = validator.correctBasketData(capacity, maxWeight);
        assertTrue(actual);
    }

    @DataProvider(name = "invalidBaskets")
    public Object[][] invalidBasketFactory() {
        return new Object[][]{
                {350, 100},
                {100, 100},
                {400, 50}
        };
    }

    @Test(dataProvider = "invalidBaskets", groups = "invalid")
    public void correctBasketData_invalid(double capacity, double maxWeight) {
        BasketValidator validator = new BasketValidator();
        boolean actual = validator.correctBasketData(capacity, maxWeight);
        assertFalse(actual);
    }
}