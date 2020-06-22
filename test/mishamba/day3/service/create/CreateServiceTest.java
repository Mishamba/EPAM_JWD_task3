package mishamba.day3.service.create;

import com.mishamba.day3.entity.ball.configuration.BallMaterial;
import com.mishamba.day3.entity.ball.configuration.BallSize;
import com.mishamba.day3.entity.ball.Ball;
import com.mishamba.day3.entity.ball.configuration.BallColor;
import com.mishamba.day3.entity.basket.Basket;
import com.mishamba.day3.exception.ProgramException;
import com.mishamba.day3.service.create.CreateService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateServiceTest {

    @Contract(" -> new")
    @DataProvider(name = "validBalls")
    private Object[] @NotNull [] validBalls() {
        return new Object[][] {
                {new Ball(BallColor.BLACK, 23, BallSize.M),
                        BallColor.BLACK, 15, 20},
                {new Ball(BallColor.BLUE,  4,  BallSize.XL),
                        BallColor.BLUE, 4, 10},
                {new Ball(BallColor.GREEN, 20, BallSize.SUPER_SIZE),
                        BallColor.GREEN, 20, 12}
        };
    }

    @Test(dataProvider = "validBalls", groups = "valid")
    public void createBall_valid(Ball expected,
                                 BallColor color,
                                 BallSize size,
                                 BallMaterial material) {
        CreateService service = new CreateService();
        Ball actual = service.createBall(color, size, material);
        assertEquals(actual, expected);
    }

    @Contract(" -> new")
    @DataProvider(name = "validBaskets")
    private Object[] @NotNull [] validBaskets() {
        return new Object[][] {
                {new Basket(100, 50), 100, 50},
                {new Basket(150, 60), 150, 60},
                {new Basket(200, 70), 250, 70},
                {new Basket(250, 75), 250, 75}
        };
    }

    @Test(dataProvider = "validBaskets", groups = "valid")
    public void createBasket_valid(Basket expected,
                                   int capacity, int maxWeight ) {
        CreateService service = new CreateService();
        try {
            Basket actual = service.createBasket(capacity, maxWeight);
            assertEquals(actual, expected);
        } catch (ProgramException ex) {
            fail("got exception");
        }
    }

    @Contract(value = " -> new", pure = true)
    @DataProvider(name = "invalidBaskets")
    private Object[] @NotNull [] invalidBaskets() {
        return new Object[][] {
                {-1, 40},
                {4, 100},
                {10, -45},
                {350, 85},
                {-10, -10}
        };
    }

    @Test(dataProvider = "invalidBaskets",
            expectedExceptions = ProgramException.class, groups = "invalid")
    public void createBaskets_invalid(int capacity, int maxWeight)
            throws ProgramException {
        CreateService service = new CreateService();
        service.createBasket(capacity, maxWeight);
    }
}