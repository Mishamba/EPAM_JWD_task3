package mishamba.day3.validator;

import com.mishamba.day3.entity.Ball;
import com.mishamba.day3.entity.ballconfiguration.BallColor;
import com.mishamba.day3.validator.BallBasketValidator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.nio.ReadOnlyBufferException;

import static org.testng.Assert.*;

public class BallBasketValidatorTest {

    @DataProvider(name = "validBalls")
    public Object[][] validBallsFactory() {
        return new Object[][] {
                {BallColor.BLACK, 12.5, 7},
                {BallColor.RED,   3.1,  20},
                {BallColor.GREEN, 10,   20},
                {BallColor.WHITE, 15,   16}
        };
    }

    @Test(dataProvider = "validBalls")
    public void correctBallData_valid(BallColor color, double weight, double radius) {
        BallBasketValidator validator = new BallBasketValidator();
        boolean actual = validator.correctBallData(color, weight, radius);
        assertTrue(actual);
    }

    @DataProvider(name = "invalidBalls")
    public Object[][] invalidBallsFactory() {
        return new Object[][] {
                {BallColor.GREEN, 100, 52},
                {BallColor.RED, 4, 631},
                {BallColor.BLACK, 100, 4}
        };
    }

    @Test(dataProvider = "invalidBalls")
    public void correctBallData_invalid(BallColor color, double weight, double radius) {
        BallBasketValidator validator = new BallBasketValidator();
        boolean actual = validator.correctBallData(color, weight, radius);
        assertFalse(actual);
    }

    @DataProvider(name = "validBaskets")
    public Object[][] validBasketFactory() {
        return new Object[][] {
                {150, 30},
                {250, 80},
                {100, 50}
        };
    }

    @Test(dataProvider = "validBaskets")
    public void correctBasketData_valid(double capacity, double maxWeight) {
        BallBasketValidator validator = new BallBasketValidator();
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

    @Test(dataProvider = "invalidBaskets")
    public void correctBasketData_invalid(double capacity, double maxWeight) {
        BallBasketValidator validator = new BallBasketValidator();
        boolean actual = validator.correctBasketData(capacity, maxWeight);
        assertFalse(actual);
    }
}