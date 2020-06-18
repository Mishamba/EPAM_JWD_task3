package mishamba.day3.service.process;

import com.mishamba.day3.entity.ball.Ball;
import com.mishamba.day3.entity.ball.configuration.BallColor;
import com.mishamba.day3.entity.ball.configuration.BallSize;
import com.mishamba.day3.entity.basket.Basket;
import com.mishamba.day3.service.process.PutService;
import com.mishamba.day3.service.process.ResultService;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ResultServiceTest {

    @Contract(value = " -> new", pure = true)
    @DataProvider(name = "basketsWithBalls")
    private Object[] @NotNull [] basketsWithBalls() {
        Object[][] baskets = new Object[][] {
                {new Basket(300000, 50000)}
        };
        PutService service = new PutService();
        service.putBallInBasket(new Ball(BallColor.BLACK, 40, BallSize.L),
                (Basket) baskets[0][0]);
        service.putBallInBasket(new Ball(BallColor.RED, 43, BallSize.S),
                (Basket) baskets[0][0]);
        service.putBallInBasket(new Ball(BallColor.BLUE, 62, BallSize.XL), (Basket) baskets[0][0]);
        return baskets;
    }

    @Test(dataProvider = "basketsWithBalls")
    public void testGetQuantityBlueBalls(Basket basket) {
        ResultService service = new ResultService();
        int actual = service.getQuantityBlueBalls(basket, BallColor.BLUE);
        int expected = 1;
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "basketsWithBalls")
    public void testGetBasketWeight(Basket basket) {
        ResultService service = new ResultService();
        double actual = service.getBasketWeight(basket);
        double expected = 145;
        assertEquals(actual, expected);
    }
}