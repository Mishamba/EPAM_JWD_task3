package mishamba.day3.service.create;

import com.mishamba.day3.entity.ball.configuration.BallMaterial;
import com.mishamba.day3.entity.ball.configuration.BallSize;
import com.mishamba.day3.exception.ProgramException;
import com.mishamba.day3.entity.ball.Ball;
import com.mishamba.day3.entity.ball.configuration.BallColor;
import com.mishamba.day3.service.create.CreateService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateServiceTest {

    @DataProvider(name = "validBalls")
    public Object[][] validBalls() {
        return new Object[][] {
                {new Ball(BallColor.BLACK, 23, BallSize.M),
                        BallColor.BLACK, 15, 20},
                {new Ball(BallColor.BLUE,  4,  BallSize.XL),
                        BallColor.BLUE, 4, 10},
                {new Ball(BallColor.GREEN, 20, BallSize.SUPER_SIZE),
                        BallColor.GREEN, 20, 12}
        };
    }

    @Test(dataProvider = "validBalls")
    public void createBall_valid(Ball expected,
                                 BallColor color,
                                 BallSize size,
                                 BallMaterial material) {
        CreateService service = new CreateService();
        Ball actual = service.createBall(color, size, material);
        assertEquals(actual, expected);
    }

    @DataProvider(name = "invalidBalls")
    public Object[][] invalidBalls() {
        return new Object[][] {
                {BallColor.GREEN, 835, 2326},
                {BallColor.BLUE, 2, 2164},
                {BallColor.WHITE, 642, 10}
        };
    }

    @Test(dataProvider = "invalidBalls", expectedExceptions = ProgramException.class)
    public void createBall_invalid(BallColor color, double weight, double radius)
    throws ProgramException{
        CreateService service = new CreateService();
        service.createBall(color, weight, radius);
    }

    @Test
    public void testCreateBasket() {
    }
}