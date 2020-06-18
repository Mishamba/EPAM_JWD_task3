package mishamba.day3.service.process;

import com.mishamba.day3.entity.ball.Ball;
import com.mishamba.day3.entity.ball.configuration.BallColor;
import com.mishamba.day3.entity.ball.configuration.BallSize;
import com.mishamba.day3.entity.basket.Basket;
import com.mishamba.day3.service.process.PutService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PutServiceTest {

    @Contract(value = " -> new", pure = true)
    @DataProvider(name = "emptyBaskets")
    private Object[] @NotNull [] emptyBaskets() {
        return new Object[][] {
                {new Ball(BallColor.BLUE, 15, BallSize.L),
                        new Basket(3000, 30)},
                {new Ball(BallColor.GREEN, 10, BallSize.M),
                        new Basket(3000, 30)},
                {new Ball(BallColor.RED, 30, BallSize.SUPER_SIZE),
                        new Basket(200000, 31)}
        };
    }

    @Test(dataProvider = "emptyBaskets")
    public void putBallInBasket_true(Ball ball, Basket basket) {
        PutService service = new PutService();
        boolean statement = service.putBallInBasket(ball, basket);
        assertTrue(statement);
    }

    @Contract(" -> new")
    @DataProvider(name = "fullBaskets")
    private Object[] @NotNull [] fullBaskets() {
        return new Object[][] {
                {new Ball(BallColor.BLUE, 15, BallSize.L),
                        new Basket(100, 10)},
                {new Ball(BallColor.GREEN, 20, BallSize.M),
                        new Basket(40, 15)},
                {new Ball(BallColor.RED, 30, BallSize.SUPER_SIZE),
                        new Basket(35, 29)}
        };
    }

    @Test(dataProvider = "fullBaskets")
    public void putBallInBasket_false(Ball ball, Basket basket) {
        PutService service = new PutService();
        assertFalse(service.putBallInBasket(ball, basket));
    }
}