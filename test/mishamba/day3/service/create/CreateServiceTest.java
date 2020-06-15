package mishamba.day3.service.create;

import com.mishamba.day3.exception.ProgramException;
import com.mishamba.day3.entity.Ball;
import com.mishamba.day3.entity.ballconfiguration.BallColor;
import com.mishamba.day3.service.create.CreateService;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CreateServiceTest {

    @DataProvider(name = "validBalls")
    public Object[][] validBalls() {
        return new Object[][] {
                {new Ball(BallColor.BLACK, 15, 20),
                        BallColor.BLACK, 15, 20},
                {new Ball(BallColor.BLUE,  4,  10),
                        BallColor.BLUE, 4, 10},
                {new Ball(BallColor.GREEN, 20, 12),
                        BallColor.GREEN, 20, 12}
        };
    }

    @Test(dataProvider = "validBalls")
    public void createBall_valid(Ball expected,
                               BallColor color, double weight, double radius) {
        CreateService service = new CreateService();
        try {
            Ball actual = service.createBall(color, weight, radius);
            assertEquals(actual, expected);
        } catch (ProgramException ex) {
            fail("got unexpected exception");
        }
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